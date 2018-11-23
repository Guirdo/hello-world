package clases;

import java.awt.Container;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Esta clase esta solo esta aquí para poder ofrecer modos de juego
 * que por ahora no seran implentadas.
 * Por su posible utlidad en el futuro, no lo borro
 * @author Sebastián Méndez <ITCH>
 */

public class ModoJuego extends JDialog {

    private int modoJuego,puerto;
    private String direccion;

    public ModoJuego(Container c, int modoJuego) {
        this.setTitle("Modo de juego");
        this.setSize(210, 315);
        this.setLocationRelativeTo(c);
        this.setLayout(null);
        this.setModal(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        this.modoJuego=modoJuego;
        
        JRadioButton rb1 = new JRadioButton("Jugar en linea");
        rb1.setBounds(15, 20, 120, 20);

        JLabel lb_1 = new JLabel("Dirección IP:");
        lb_1.setBounds(30, 45, 150, 20);
        JTextField jtfIP = new JTextField();
        jtfIP.setBounds(30, 70, 150, 25);
        JLabel lb_2 = new JLabel("Puerto:");
        lb_2.setBounds(30, 105, 150, 25);
        JTextField jtfPuerto = new JTextField();
        jtfPuerto.setBounds(30, 130, 150, 25);
        jtfIP.setEnabled(false);
        jtfPuerto.setEnabled(false);
        rb1.addActionListener((ActionEvent) -> {
            jtfIP.setEnabled(true);
            jtfPuerto.setEnabled(true);
        });

        JRadioButton rb2 = new JRadioButton("Jugador vs PC");
        rb2.setBounds(15, 170, 120, 20);
        rb2.addActionListener((ActionEvent) -> {
            jtfIP.setEnabled(false);
            jtfPuerto.setEnabled(false);
        });
        JRadioButton rb3 = new JRadioButton("Jugador vs Jugador");
        rb3.setBounds(15, 200, 150, 20);
        rb3.addActionListener((ActionEvent) -> {
            jtfIP.setEnabled(false);
            jtfPuerto.setEnabled(false);
        });

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        rb2.setSelected(true);

        JButton jugar = new JButton("Jugar");
        jugar.setBounds(15, 235, 70, 25);
        jugar.addActionListener((ActionEvent) -> {
            if (rb1.isSelected()) {
                if (jtfIP.getText().isEmpty() && jtfPuerto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No deje campos en blanco");
                }else{
                    direccion = jtfIP.getText();
                    puerto = Integer.parseInt(jtfPuerto.getText());
                    this.setModoJuego(0);
                    this.dispose();
                }
            }else if(rb2.isSelected()){
                this.setModoJuego(1);
                this.dispose();
            }else if(rb3.isSelected()){
                this.setModoJuego(2);
                this.dispose();
            }
        });

        JButton cancelar = new JButton("Cancelar");
        cancelar.setBounds(90, 235, 90, 25);
        cancelar.addActionListener((ActionEvent)->{
            this.dispose();
        });

        this.add(rb1);
        this.add(lb_1);
        this.add(jtfIP);
        this.add(lb_2);
        this.add(jtfPuerto);
        this.add(rb2);
        this.add(rb3);
        this.add(jugar);
        this.add(cancelar);
    }

    public int getModoJuego() {
        return modoJuego;
    }

    public void setModoJuego(int modoJuego) {
        this.modoJuego = modoJuego;
    }

    public int getPuerto() {
        return puerto;
    }

    public String getDireccion() {
        return direccion;
    }

}
