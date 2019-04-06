/*
 * Hola!
 */
package actividad6;

import java.awt.Color;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Actividad6 extends JFrame {
    
    public Actividad6(){
        this.setTitle("Actividad 6");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new MigLayout("","","[]15[]15[]10[]15[]"));
        
        JTextField tfOperacion = new JTextField(20);
        JButton btnIngresar = new JButton("Comprobar");
        btnIngresar.setBackground(Color.decode("#0BA802"));
        btnIngresar.setForeground(Color.WHITE);
        JLabel lblEntrada = new JLabel();
        JLabel lblResultado = new JLabel();
        lblResultado.setFont(new Font("Arial",1,18));
        JLabel lbl_1 = new JLabel("Resultado");
        lbl_1.setFont(new Font("Arial",1,16));
        
        //Logica
        btnIngresar.addActionListener((ActionEvent)->{
            String patron;
            String entrada = tfOperacion.getText();
            tfOperacion.setText("");
            tfOperacion.requestFocus();
            lblEntrada.setText(entrada);
            
            patron="[+-]?\\d+\\s*([+-\\\\*/%]\\s*\\d+)*";
            Pattern pattern = Pattern.compile(patron);
            Matcher matcher = pattern.matcher(entrada);
            
            if(matcher.matches()){
                lblResultado.setText("Verdadero");
                lblResultado.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
            }else{
                lblResultado.setText("Falso");
                lblResultado.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            }
        });
        
        this.add(new JLabel("Introduzca la operación"),"left,wrap");
        this.add(tfOperacion,"pushx,growx,wrap");
        this.add(btnIngresar,"right,wrap");
        this.add(lbl_1,"wrap");
        this.add(lblEntrada,"h 20,wrap");
        this.add(lblResultado,"h 20,center,pushy,,wrap");
        
        this.pack();
        this.setLocationRelativeTo(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Actividad6().setVisible(true);
    }
    
}
