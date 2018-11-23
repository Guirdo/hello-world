/*
 * Hola!
 */
package arrastrarsoltar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class ArrastrarSoltar extends JFrame implements MouseMotionListener, MouseListener {

    //Atributos
    static private JPanel pnlJuego, pnlEstado;
    static private JLabel imagen, lblProgreso, lblTiempo,lblInicio;
    static private JTextArea record;
    static private JButton jugar;
    static private ArrayList<String> palabras;
    static private int turnoPalabra;
    static private ArrayList<Tarjeta> tarjetas;
    static private int ancho, segundos, minutos;
    static private String salSeg, salMin;
    static private Timer cronometro;
    //static private boolean jugable;
    //private boolean gano;

    public ArrastrarSoltar() {
        this.setTitle("Arrastra y suelta");
        this.setSize(800, 650);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        turnoPalabra = 0;
        segundos = 0;
        minutos = 0;
        salSeg = "";
        salMin = "";
        ancho = this.getWidth();
        palabras = new ArrayList<>();

        try {
            String palabra;
            BufferedReader br = new BufferedReader(new FileReader("src\\palabras.txt"));
            while ((palabra = br.readLine()) != null) {
                if (palabra.charAt(0) != '#') {
                    palabras.add(palabra);
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArrastrarSoltar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArrastrarSoltar.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collections.shuffle(palabras);
        jugar = new JButton("Jugar");
        jugar.setBounds(600, 35, 100, 30);
        jugar.setFont(new Font("Arial", 1, 20));

        pnlJuego = new JPanel();
        pnlJuego.setBounds(0, 0, this.getWidth(), this.getHeight() - 150);
        pnlJuego.setLayout(null);
        pnlJuego.setBackground(Color.WHITE);
        
        lblInicio = new JLabel("¿Preparado?");
        lblInicio.setSize(250,50);
        lblInicio.setLocation(pnlJuego.getWidth()/2-125,pnlJuego.getHeight()/2-30);
        lblInicio.setFont(new Font("Arial",1,40));
        pnlJuego.add(lblInicio);
        //crearJuego();
        
        pnlEstado = new JPanel();
        pnlEstado.setBounds(0, this.getHeight() - 150, this.getWidth(), (this.getHeight() - pnlJuego.getHeight()));
        pnlEstado.setBackground(Color.GRAY);
        pnlEstado.setLayout(null);
        crearEstado();
//        
//        JMenuBar menu = new JMenuBar();
//        JMenu archivo = new JMenu("Archivo");
//        JMenuItem completar = new JMenuItem("Completar");
//        completar.addActionListener((ActionEvent) -> {
//            if (!jugar.isEnabled()) {
//                ArrastrarSoltar.gano();
//            }
//        });
//        completar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK));
//        archivo.add(completar);
//        menu.add(archivo);
//        this.setJMenuBar(menu);

        this.add(pnlJuego);
        this.add(pnlEstado);

    }

    public void crearEstado() {
        lblProgreso = new JLabel("Palabras: " + turnoPalabra + "/" + palabras.size());
        lblProgreso.setBounds(30, 40, 150, 30);
        lblProgreso.setFont(new Font("Arial", 1, 20));

        lblTiempo = new JLabel("00:00");
        lblTiempo.setBounds(250, 40, 100, 30);
        lblTiempo.setFont(new Font("Arial", 1, 20));

        record = new JTextArea();
        record.setEditable(false);
        record.setBorder(BorderFactory.createTitledBorder("Record"));
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(400, 15, 100, 80);
        scroll.setViewportView(record);

        cronometro = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                lblTiempo.setText(salMin + ":" + salSeg);
            }
        });

        jugar.addActionListener((ActionEvent) -> {
            cronometro.start();
            pnlJuego.removeAll();
            crearJuego();
            pnlJuego.revalidate();
            pnlJuego.repaint();
            jugar.setEnabled(false);
        });

        pnlEstado.add(lblProgreso);
        pnlEstado.add(lblTiempo);
        pnlEstado.add(scroll);
        pnlEstado.add(jugar);

    }

    public static void crearJuego() {
        String palabra = palabras.get(turnoPalabra);
        Tarjeta t;
        Zocalo z;
        tarjetas = new ArrayList<>();

        imagen = new JLabel();
        imagen.setBounds((ancho / 2) - (200 / 2), 50, 200, 200);
        imagen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        imagen.setIcon(new ImageIcon("src\\imagenes\\" + palabra + ".png"));
        pnlJuego.add(imagen);

        //Calcular primeras x's
        int x1 = (pnlJuego.getWidth() - ((palabra.length() * 70) + ((palabra.length() - 1) * 5))) / 2;
        int x2 = (pnlJuego.getWidth() - ((palabra.length() * 50) + ((palabra.length() - 1) * 5))) / 2;

        for (int i = 0; i < palabra.length(); i++) {
            z = new Zocalo();
            z.setLocation(x1, 300);
            z.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            x1 += 75;
            pnlJuego.add(z);

            t = new Tarjeta(z.getX(), z.getY());
            t.setText("" + palabra.toUpperCase().charAt(i));
            t.setFont(new Font("Arial", 1, 30));
            t.setHorizontalAlignment(JLabel.CENTER);
            t.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            tarjetas.add(t);
        }

        Collections.shuffle(tarjetas);

        for (int i = 0; i < tarjetas.size(); i++) {
            tarjetas.get(i).setLocation(x2, 400);
            x2 += 55;
            pnlJuego.add(tarjetas.get(i));
        }

    }

    public static void gano() {
        turnoPalabra++;

        lblProgreso.setText("Palabras: " + turnoPalabra + "/" + palabras.size());

        if (turnoPalabra != palabras.size()) {
            pnlJuego.removeAll();
            crearJuego();
            pnlJuego.revalidate();
            pnlJuego.repaint();

        } else {
            cronometro.stop();
            new Final().setVisible(true);
            if (Final.getContinuar()) {
                record.setText(record.getText() + lblTiempo.getText() + "\n");
                Collections.shuffle(palabras);
                turnoPalabra = 0;
                segundos = 0;
                minutos = 0;
                salSeg = "";
                salMin = "";

                lblProgreso.setText("Palabras: " + turnoPalabra + "/" + palabras.size());
                lblTiempo.setText("00:00");

                pnlJuego.removeAll();
                pnlJuego.add(lblInicio);
                pnlJuego.revalidate();
                pnlJuego.repaint();

                jugar.setEnabled(true);
            } else {
                System.exit(0);
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new ArrastrarSoltar().setVisible(true);
    }

    public static ArrayList<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.setLocation(this.getX() + e.getX() - (this.getWidth() / 2), this.getY() + e.getY() - (this.getHeight() / 2));
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
