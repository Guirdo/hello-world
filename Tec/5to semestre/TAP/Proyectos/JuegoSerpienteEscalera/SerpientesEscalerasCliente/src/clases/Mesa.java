package clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Mesa extends JFrame {

    private int modo, jugador;
    static ArrayList<Recuadro> listaRecuadro;
    private ArrayList<Jugador> listaJugadores;
    private boolean turno, clickPropio, esperando;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private Socket cs;
    private String nombre;
    private String RIVAL;
    private JTextArea tablaTurnos;
    private JButton tirar;
    private Dado dado;

    public Mesa() {
        this.setTitle("Serpientes y escaleras");
        this.setSize(1000, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        modo = 1;
        jugador = 0;
        turno = false;
        esperando = false;
        clickPropio = false;
        listaRecuadro = new ArrayList<>();
        listaJugadores = new ArrayList<>();

        //Menu bar-------------------------------------------------------------(inicio)
        JMenuBar menu = new JMenuBar();

        JMenu archivo = new JMenu("Archivo");
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener((ActionEvent) -> {
            System.exit(0);
        });
        archivo.add(salir);

        menu.add(archivo);
        this.setJMenuBar(menu);
        //Menu bar-------------------------------------------------------------(fin)

        //Tablero---------------------------------------------------------------(Inicio)
        JPanel tablero = new JPanel();
        tablero.setLayout(null);
        tablero.setBackground(Color.decode("#BBDCC7"));

        tablaTurnos = new JTextArea("Le toca a:\nNadie aún");
        tablaTurnos.setBounds(865, 100, 100, 50);
        tablaTurnos.setEditable(false);
        tablaTurnos.setBackground(Color.decode("#ff34b3"));
        tablaTurnos.setFont(new Font("Arial", 1, 13));
        tablero.add(tablaTurnos);

        Jugador j;
        int x = 35;

        int y = 535;
        for (int i = 0; i < 2; i++) {
            j = new Jugador(i, x, y);
            j.setBounds(x, y, 40, 40);
            j.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            y += 55;
            listaJugadores.add(j);
            tablero.add(listaJugadores.get(i));
        }

        Recuadro r;
        x = 90;
        y = 520;
        int fila = 0;
        int serpEsca = 0;
        for (int i = 0; i < 30; i++) {

            switch (i) {
                //Escaleras
                case 2:
                    serpEsca = 19;
                    break;
                case 4:
                    serpEsca = 3;
                    break;
                case 10:
                    serpEsca = 15;
                    break;
                case 19:
                    serpEsca = 9;
                    break;
                //Serpientes
                case 16:
                    serpEsca = -13;
                    break;
                case 18:
                    serpEsca = -12;
                    break;
                case 20:
                    serpEsca = -12;
                    break;
                case 26:
                    serpEsca = -26;
                    break;
                default:
                    serpEsca = 0;
            }

            r = new Recuadro("/imagenes/sp/" + i + ".png", serpEsca);
            r.setBounds(x, y, 124, 124);

            if (fila % 2 == 0) {
                x += 124;
            } else {
                x -= 124;
            }

            if ((i + 1) % 6 == 0) {
                y -= 124;
                fila++;
                if (fila % 2 == 0) {
                    x += 124;
                } else {
                    x -= 124;
                }
            }

            listaRecuadro.add(r);
            tablero.add(listaRecuadro.get(i));
        }

        dado = new Dado("/imagenes/dado/0.png");
        dado.setBounds(865, 265, 100, 100);
        tablero.add(dado);

        tirar = new JButton("Tirar");
        tirar.setBounds(880, 375, 70, 25);
        tirar.addActionListener((ActionEvent) -> {
            if (turno && !esperando) {
                Random aleatorio = new Random();
                int numero = 0;
                int iteraciones = (aleatorio.nextInt(3) + 1) * 8;

                for (int i = 0; i < iteraciones; i++) {
                    numero = aleatorio.nextInt(6);
                }

                clickPropio = true;

                try {
                    salida.writeUTF("dado@" + numero);
                } catch (IOException ex) {

                }
            }

        });
        tablero.add(tirar);
        //Tablero---------------------------------------------------------------(Fin)
        this.add(tablero);
    }

    public static void main(String[] args) {
        Mesa m = new Mesa();
        m.setVisible(true);
        m.conectarServer();
        m.escucharServer();
    }

    public void conectarServer() {
        try {
            String dicIP = JOptionPane.showInputDialog(null, "Ingrese la direccion IP:");
            cs = new Socket(dicIP, 4000);

            entrada = new DataInputStream(cs.getInputStream());
            salida = new DataOutputStream(cs.getOutputStream());

            nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre");
            salida.writeUTF("clienteNom@" + nombre);
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage()+"\nAsegurate de que el servidor este encendido...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
             System.exit(1);
        }
    }

    public void escucharServer() {
        boolean conectado = true;
        String mensajeRecibido;
        String array[];
        while (conectado) {
            try {
                mensajeRecibido = entrada.readUTF();
                array = mensajeRecibido.split("@");

                switch (array[0]) {
                    case "serverTurno":
                        System.out.println(array[1]);
                        if (!turno) {
                            turno = Boolean.valueOf(array[1]);
                        }
                        if (!turno) {
                            salida.writeUTF("clientePideNom@//");
                        } else {
                            esperando = true;
                            tirar.setToolTipText("¡Aún no puedes jugar!");
                        }

                        break;
                    case "serverDaNom":
                        String arrayAux[] = array[1].split("#");
                        listaJugadores.get(0).setNombre(arrayAux[0]);
                        listaJugadores.get(1).setNombre(arrayAux[1]);

                        esperando = false;
                        tablaTurnos.setText("Le toca a:\n" + listaJugadores.get(jugador).getNombre());
                        tirar.setToolTipText("¡Qué la fuerza te acompañe!");
                        break;
                    case "dado":
                        int numero = Integer.parseInt(array[1]);
                        dado.setCara("/imagenes/dado/" + numero + ".png");
                        listaJugadores.get(jugador).avanzar(numero + 1);

                        if (listaJugadores.get(jugador).getContador() == 29) {
                            if (listaJugadores.get(jugador).getNombre().equals(nombre)) {
                                JOptionPane.showMessageDialog(null, "¡HAS GANADO!");
                            } else {
                                JOptionPane.showMessageDialog(null, "¡Ha ganado " + listaJugadores.get(jugador).getNombre() + "!");
                            }

                            listaJugadores.get(0).devolverInicio();
                            listaJugadores.get(1).devolverInicio();
                            jugador = 0;
                            if (listaJugadores.get(0).getNombre().equals(this.nombre)) {
                                turno = true;
                            } else {
                                turno = false;
                            }
                            clickPropio=false;
                        } else {
                            jugador++;
                            if (jugador > 1) {
                                jugador = 0;
                            }
                            turno = !clickPropio;
                            clickPropio = false;
                        }
                        tablaTurnos.setText("Le toca a:\n" + listaJugadores.get(jugador).getNombre());
                        break;
                }

            } catch (IOException ex) {

            }
        }
    }

}
