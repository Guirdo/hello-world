/*
 * Hola!
 */
package actividad5;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.image.BufferedImage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Actividad5 extends JFrame{
    
    public Actividad5(){
        this.setTitle("Actividad 5");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(260, 245);
        
        JTextField tfEntrada = new JTextField(20);
        JButton comprobar = new JButton("Comprobar");
        JLabel lbl_0 = new JLabel("Ingrese cadena de texto:");
        JLabel lblRFC = new JLabel();
        
        lbl_0.setBounds(23, 10, 200, 20);
        tfEntrada.setBounds(23, 40, 200, 25);
        comprobar.setBounds(123, 80, 100, 20);
        lblRFC.setBounds(23, 105,100, 25);
        
        JLabel lbl_1 = new JLabel("Verdadero");
        JLabel lbl_2 = new JLabel("Falso");
        lbl_1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        lbl_2.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        lbl_1.setHorizontalAlignment(JLabel.CENTER);
        lbl_2.setHorizontalAlignment(JLabel.CENTER);
        lbl_1.setVisible(false);
        lbl_2.setVisible(false);
        
        lbl_1.setBounds(30, 150, 75, 30);
        lbl_2.setBounds(140, 150, 75, 30);
        
        
        comprobar.addActionListener((ActionEvent)->{
            String patron;
            String entrada = tfEntrada.getText();
            //String entrada = "";
            tfEntrada.setText("");
            tfEntrada.requestFocus();
            lblRFC.setText(entrada);
            
            //patron = "[A-Z]{4}\\d{6}(\\w{3})?";
            //patron = "[+-]?(\\s*\\d+[xX]?\\s*[+-]?)+";
            //patron = "(rojo|verde|azul)\\s(tierra|mar)";
            //patron = "amor(cito|es)";
            patron = "This is the";
            Pattern pattern = Pattern.compile(patron,Pattern.CASE_INSENSITIVE);

            
//            String cuchillo = "\\W";
//            Pattern pattern = Pattern.compile(cuchillo);
//            String[] split = pattern.split(entrada);
//            
//            System.out.println("Numero de pedazos del pastel"+split.length);
//            
//            for(String element : split){
//                System.out.println(element);
//            }
            
            Matcher matcher = pattern.matcher(entrada);
            boolean matches = matcher.lookingAt();
            
            if(matches){
                lbl_1.setVisible(true);
                lbl_2.setVisible(false);
            }else{
                lbl_1.setVisible(false);
                lbl_2.setVisible(true);
            }
        });
        
        this.add(lbl_0);
        this.add(tfEntrada);
        this.add(comprobar);
        this.add(lblRFC);
        this.add(lbl_1);
        this.add(lbl_2);
        this.setLocationRelativeTo(null);
        //new Presentacion().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Actividad5().setVisible(true);
    }
    
}
