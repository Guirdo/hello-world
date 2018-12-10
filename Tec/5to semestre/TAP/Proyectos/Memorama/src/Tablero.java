
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 * 
 * Salon de la fama:
 * Bello Marina Francisco III
 * Record: 00:13
 * 
 * 
 * Salon de la verguenza
 * Joab Jaret Valdez Nava
 * record: toda la vida
 */

public class Tablero extends JFrame {

    //Atributos
    private JPanel panelMesa, panelOpciones;
    private ArrayList<Boton> listaBotones = null;
    private Boton pulsadoAnterior, pulsadoActual;
    private JButton jugar;
    private JLabel lblCronometro, lblMovimiento, lblAcierto;
    private JTextArea record;
    private String anterior, actual, salSeg, salMin;
    private int pos1, pos2, clicks, parejas, movimientos;
    private int segundos, minutos;
    private boolean voltearMas;
    private Timer temporizador, cronometro;

    public Tablero() {
        setTitle("Memorama");
        setSize(620, 640);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //Inicialización
        anterior = "";
        actual = "";
        clicks = 0;
        voltearMas = false;
        parejas = 0;
        movimientos = 0;
        temporizador = new Timer(250, (ActionEvent) -> {
            listaBotones.get(pos1).setVolteado(false);
            listaBotones.get(pos2).setVolteado(false);
            voltearMas = true;
        });
        temporizador.setRepeats(false);

        //Panel Mesa
        panelMesa = new JPanel();
        panelMesa.setBounds(0, 0, 440, 600);
        panelMesa.setLayout(null);
        panelMesa.setBackground(Color.white);
        crearJuego();

        //Panel Opciones
        panelOpciones = new JPanel();
        panelOpciones.setBounds(440, 0, 180, 600);
        panelOpciones.setLayout(null);
        crearOpciones();

        add(panelMesa);
        add(panelOpciones);
    }

    public void crearJuego() {
        listaBotones = new ArrayList<>();
        Boton b;
        int x = 20;
        int y = 20;
        double contador = 0;

        //Agrego imagenes a lo botones y lo meto al arreglo
        for (int i = 0; i < 16; i++) {
            b = new Boton("src\\imagenes\\" + (int) Math.floor(contador) + ".jpg");
            listaBotones.add(b);
            contador += 0.5;
        }

        //Revolver los botones
        Random aleatorio = new Random();
        for (int i = 0; i < 16; i++) {
            int randomPos = aleatorio.nextInt(16);
            Boton temp = listaBotones.get(i);
            listaBotones.set(i, listaBotones.get(randomPos));
            listaBotones.set(randomPos, temp);
        }

        //Dio limites a los botones
        for (int i = 0; i < 16; i++) {
            listaBotones.get(i).setBounds(x, y, 100, 140);

            //Agregando listeners
            final int FINALI = i;
            listaBotones.get(i).addActionListener((ActionEvent e) -> {
                if (voltearMas) {
                    if (clicks == 0) { //Primer click
                        pos1 = FINALI;
                        listaBotones.get(pos1).setVolteado(true);
                        pulsadoAnterior = (Boton) e.getSource();
                        clicks++;
                    } else {
                        if (!e.getSource().equals(pulsadoAnterior)) {//Comprueba que no sea el mismo evento
                            pos2 = FINALI;
                            listaBotones.get(pos2).setVolteado(true);
                            voltearMas = false;

                            if (comprobarCorrecto()) {
                                listaBotones.get(pos1).setEnabled(false);
                                listaBotones.get(pos2).setEnabled(false);
                                voltearMas = true;
                                lblAcierto.setText("Aciertos: " + parejas);
                                victoria();
                            } else {
                                temporizador.start();
                            }
                            clicks = 0;
                            movimientos++;
                            lblMovimiento.setText("Movimientos: " + movimientos);
                        } else {
                            System.out.println("Hola, soy el mismo evento.");
                        }
                    }
                }
            });

            panelMesa.add(listaBotones.get(i));
            x += 100;
            if (x == 420) {
                x = 20;
                y += 140;
            }
        }
    }

    public void crearOpciones() {
        //Label movimientos
        lblMovimiento = new JLabel("Movimientos: ");
        lblMovimiento.setBounds(25, 100, 110, 45);
        lblMovimiento.setFont(new Font("Arial", 0, 13));

        //Label aciertos
        lblAcierto = new JLabel("Aciertos: ");
        lblAcierto.setBounds(25, 150, 110, 45);
        lblAcierto.setFont(new Font("Arial", 0, 13));

        //Label cronometro
        lblCronometro = new JLabel("00:00");
        lblCronometro.setBounds(60, 300, 50, 30);
        lblCronometro.setFont(new Font("Arial", 1, 16));
        lblCronometro.setOpaque(true);

        //Record
        record = new JTextArea();
        record.setBounds(30, 340, 110, 150);
        record.setBorder(BorderFactory.createTitledBorder("Record"));
        record.setEditable(false);

        //Cronometro
        cronometro = new Timer(1000, (ActionEvent) -> {
            segundos++;

            if (segundos > 59) {
                minutos++;
                segundos = 0;
            }

            if (segundos < 10) {
                salSeg = "0" + segundos;
            } else {
                salSeg = segundos + "";
            }

            if (minutos < 10) {
                salMin = "0" + minutos;
            } else {
                salMin = minutos + "";
            }

            lblCronometro.setText(salMin + ":" + salSeg);
        });

        //Boton jugar
        jugar = new JButton("Jugar");
        jugar.setBounds(30, 550, 100, 30);
        jugar.setFont(new Font("Arial", 3, 14));
        jugar.addActionListener((ActionEvent) -> {
            voltearMas = true;
            jugar.setEnabled(false);
            cronometro.start();
        });

        panelOpciones.add(jugar);
        panelOpciones.add(record);
        panelOpciones.add(lblCronometro);
        panelOpciones.add(lblMovimiento);
        panelOpciones.add(lblAcierto);
    }

    public boolean comprobarCorrecto() {
        if (listaBotones.get(pos1).getCara().equals(listaBotones.get(pos2).getCara())) {
            parejas++;
            return true;
        } else {
            return false;
        }
    }

    public void victoria() {
        if (parejas == 8) {
            cronometro.stop();
            Final fin = new Final();
            fin.setVisible(true);
            if (fin.getContinuar()) {
                listaBotones = null;
                voltearMas = false;
                parejas = 0;
                movimientos = 0;
                cronometro.stop();
                record.setText(record.getText() + lblCronometro.getText() + "\n");
                jugar.setEnabled(true);

                segundos = 0;
                minutos = 0;
                lblCronometro.setText("00:00");
                lblMovimiento.setText("Movimientos: ");
                lblAcierto.setText("Aciertos: ");

                panelMesa.removeAll();
                crearJuego();
                panelMesa.revalidate();
                panelMesa.repaint();
            }else{
                System.exit(0);
            }

        }
    }
}
