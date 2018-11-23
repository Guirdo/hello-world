package gatoraton;

import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tablero extends JFrame {

    //Atributos
    private Boton[][] listaBotones;
    private boolean turno, clickPropio;
    private JPanel pnlMesa, pnlOpciones;
    private JLabel jugador;
    private JLabel jugando;
    private String animalJugando, animalAsignado;
    private boolean gato;
    private int clicks, pos1, pos2;
    private Socket cs;
    private DataOutputStream salida;

    public Tablero() {
        this.setTitle("Gato y al raton");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gato = true;
        turno = true;
        clickPropio = false;
        clicks = 0;
        setAnimalJugando();

        pnlMesa = new JPanel();
        pnlMesa.setBounds(0, 0, 350, 400);
        pnlMesa.setLayout(null);
        crearJuego();

        //Panel de opciones------------------------------------------------------------------------(Inicio)
        pnlOpciones = new JPanel();
        pnlOpciones.setBounds(350, 0, 150, 400);
        pnlOpciones.setLayout(null);

        jugando = new JLabel("Jugando: " + animalJugando);
        jugando.setBounds(20, 100, 100, 20);

        pnlOpciones.add(jugando);
        //Panel de opciones------------------------------------------------------------------------(Fin) 

        add(pnlMesa);
        add(pnlOpciones);
    }

    public void conectarServidor() {
        String direccionIP = JOptionPane.showInputDialog(null, "Direccion IP:", "Conectar al servidor", JOptionPane.QUESTION_MESSAGE);
        try {
            cs = new Socket(direccionIP, 9000);
            salida = new DataOutputStream(cs.getOutputStream());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void escucharServidor() {
        DataInputStream entrada = null;
        boolean conectado = true;
        String mensaje;
        try {
            entrada = new DataInputStream(cs.getInputStream());
        } catch (IOException ex) {

        }

        while (conectado) {
            try {
                mensaje = entrada.readUTF();
                pos1 = Integer.parseInt(String.valueOf(mensaje.charAt(0)));
                pos2 = Integer.parseInt(String.valueOf(mensaje.charAt(1)));

                listaBotones[pos1][pos2].setEsClickeado(true);

                listaBotones[pos1][pos2].setAnimal(gato);
                gato = !gato;
                clicks++;
                if (clickPropio) {
                    turno = false;
                } else {
                    turno = true;
                }

                if (victoria()) {
                    reiniciarJuego();
                } else {
                    if (clicks == 9) {
                        reiniciarJuego();
                    }
                }

                setAnimalJugando();
                jugando.setText("Jugando: " + animalJugando);
                clickPropio = false;
            } catch (IOException ex) {
                conectado=false;
                try {
                    entrada.close();
                } catch (IOException ex1) {
                    
                }
            }
        }

    }

    public void reiniciarJuego() {
        Reinicio rc = new Reinicio(animalJugando, animalAsignado, clicks,this);
        rc.setVisible(true);

        if (rc.isReiniciar()) {
            gato = true;
            turno = true;
            clickPropio = false;
            clicks = 0;
            setAnimalJugando();

            pnlMesa.removeAll();
            crearJuego();
            pnlMesa.revalidate();
            pnlMesa.repaint();
        }else{
            try {
                cs.close();
                salida.close();
                System.exit(0);
            } catch (IOException ex) {
                
            }
            
        }
    }

    public void crearJuego() {
        listaBotones = new Boton[3][3];
        Boton b;
        int x = 25;
        int y = 25;

        // TODO arreglar para un arreglo bidimensional
        for (int i = 0; i < 3; i++) {
            final int FINALI = i;
            for (int j = 0; j < 3; j++) {
                b = new Boton(i, j);
                b.setBounds(x, y, 100, 100);

                final int FINALJ = j;
                b.addActionListener((ActionEvent e) -> {
                    if (turno) {
                        if (!listaBotones[FINALI][FINALJ].getEsClickeado()) {
                            try {

                                if (clicks == 0) {
                                    animalAsignado = "Gato";
                                    this.setTitle("Gato y al raton: Tú eres el gato");
                                } else if (clicks == 1) {
                                    animalAsignado = "Ratón";
                                    this.setTitle("Gato y al raton: Tú eres el raton");
                                }

                                clickPropio = true;
                                salida.writeUTF(FINALI + "" + FINALJ);
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    }
                });

                listaBotones[i][j] = b;
                pnlMesa.add(listaBotones[i][j]);

                x += 100;
                if (x == 325) {
                    x = 25;
                    y += 100;
                }
            }
        }

    }   

    public void setAnimalJugando() {
        if (gato) {
            animalJugando = "Gato";
        } else {
            animalJugando = "Ratón";
        }
    }

    public boolean victoria() {
        for (int i = 0; i < 3; i++) {
            //Por renglon
            if (listaBotones[i][0].getAnimal().equals(listaBotones[i][1].getAnimal()) && !listaBotones[i][0].getAnimal().equals("INDEFINIDO")) {
                if (listaBotones[i][0].getAnimal().equals(listaBotones[i][2].getAnimal())) {
                    return true;
                }
            }
            //Por Columna
            if (listaBotones[0][i].getAnimal().equals(listaBotones[1][i].getAnimal()) && !listaBotones[0][i].getAnimal().equals("INDEFINIDO")) {
                if (listaBotones[0][i].getAnimal().equals(listaBotones[2][i].getAnimal())) {
                    return true;
                }
            }
        }

        //Por diagonal
        if (listaBotones[0][0].getAnimal().equals(listaBotones[1][1].getAnimal()) && !listaBotones[0][0].getAnimal().equals("INDEFINIDO")) {
            if (listaBotones[0][0].getAnimal().equals(listaBotones[2][2].getAnimal())) {
                return true;
            }
        }
        if (listaBotones[0][2].getAnimal().equals(listaBotones[1][1].getAnimal()) && !listaBotones[0][2].getAnimal().equals("INDEFINIDO")) {
            if (listaBotones[0][2].getAnimal().equals(listaBotones[2][0].getAnimal())) {
                return true;
            }
        }

        return false;
    }
}
