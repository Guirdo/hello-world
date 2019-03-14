/*
 * Hola!
 */
package graficadora;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Graficadora extends JFrame {

    public Graficadora() {
        this.setTitle("Graficadora");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(600, 480);

        JLabel lbl_1 = new JLabel("y = ");
        JTextField tfA = new JTextField(3);
        JLabel lbl_2 = new JLabel("x + ");
        JTextField tfB = new JTextField(3);

        lbl_1.setBounds(10, 10, 20, 20);
        tfA.setBounds(35, 10, 30, 20);
        lbl_2.setBounds(70, 10, 20, 20);
        tfB.setBounds(95, 10, 30, 20);
        
        JLabel lbl_3 = new JLabel("X1");
        JLabel lbl_4 = new JLabel("X2");
        JTextField equis1 = new JTextField();
        JTextField equis2 = new JTextField();
        
        lbl_3.setBounds(10, 50, 20, 20);
        equis1.setBounds(35,50,20,20);
        lbl_4.setBounds(60, 50, 20, 20);
        equis2.setBounds(85,50,20,20);
        
        JButton graficar = new JButton("Graficar");
        graficar.setBounds(10, 100, 80, 25);
        
        Plano plano = new Plano(150, 10,400, 400);
        
        graficar.addActionListener((ActionEvent)->{
            int a, b, x1, x2;
            int escala=5;
            a = Integer.parseInt(tfA.getText());
            b = Integer.parseInt(tfB.getText());
            x1 = Integer.parseInt(equis1.getText());
            x2 = Integer.parseInt(equis2.getText());
            
            plano.graficar(a*escala, b*escala, x1*escala, x2*escala);
        });
        
        this.add(lbl_1);
        this.add(tfA);
        this.add(lbl_2);
        this.add(tfB);
        
        this.add(lbl_3);
        this.add(equis1);
        this.add(lbl_4);
        this.add(equis2);
        
        this.add(graficar);
        
        this.add(plano);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Graficadora().setVisible(true);
    }

}
