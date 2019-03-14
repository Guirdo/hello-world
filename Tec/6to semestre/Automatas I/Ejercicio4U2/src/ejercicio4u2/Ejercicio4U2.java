/*
 * Hola!
 */
package ejercicio4u2;

import java.awt.Color;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Ejercicio4U2 extends JFrame{
    
    public Ejercicio4U2(){
        this.setTitle("Ejercicio 3 U2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new MigLayout("", "", "[]15[]15[]10[]15[]"));

        JTextArea taOperacion = new JTextArea(4,20);
        taOperacion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JButton btnIngresar = new JButton("Comprobar");
        btnIngresar.setBackground(Color.decode("#0BA802"));
        btnIngresar.setForeground(Color.WHITE);
        JTextArea taEntrada = new JTextArea(4,20);
        taEntrada.setEditable(false);
        taEntrada.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        JLabel lblResultado = new JLabel("______");
        lblResultado.setFont(new Font("Arial", 1, 18));

        //Logica
        btnIngresar.addActionListener((ActionEvent) -> {
            String patron;
            String entrada = taOperacion.getText();
            taOperacion.setText("");
            taOperacion.requestFocus();
            taEntrada.setText(entrada);

            patron = "ini(\\d*\\W*\\n^)fin";
            Pattern pattern = Pattern.compile(patron);
            Matcher matcher = pattern.matcher(entrada);

            if (matcher.matches()) {
                lblResultado.setText("Verdadero");
                lblResultado.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            } else {
                lblResultado.setText("Falso");
                lblResultado.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            }
        });

        this.add(new JLabel("Introduzca la cadena"), "left,wrap");
        this.add(taOperacion, "pushx,growx,pushy,wrap");
        this.add(btnIngresar, "right,wrap");
        this.add(new JLabel("Resultado"),"left,wrap");
        this.add(taEntrada, "pushy,pushx,growx,wrap");
        this.add(lblResultado, "center,pushy,,wrap");

        this.pack();
        this.setLocationRelativeTo(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Ejercicio4U2().setVisible(true);
    }
    
}
