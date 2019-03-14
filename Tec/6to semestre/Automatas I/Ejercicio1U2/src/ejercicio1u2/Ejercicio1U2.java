/*
 * Hola!
 */
package ejercicio1u2;

import java.awt.Color;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Ejercicio1U2 extends JFrame {

    public Ejercicio1U2() {
        this.setTitle("Ejercicio 1 U2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new MigLayout("", "", "[]15[]15[]10[]15[]"));

        JTextField tfOperacion = new JTextField(20);
        JButton btnIngresar = new JButton("Comprobar");
        btnIngresar.setBackground(Color.decode("#0BA802"));
        btnIngresar.setForeground(Color.WHITE);
        JLabel lblEntrada = new JLabel("______");
        JLabel lblResultado = new JLabel("______");
        lblResultado.setFont(new Font("Arial", 1, 18));

        //Logica
        btnIngresar.addActionListener((ActionEvent) -> {
            String patron;
            String entrada = tfOperacion.getText();
            tfOperacion.setText("");
            tfOperacion.requestFocus();
            lblEntrada.setText(entrada);

            patron = "([13579]*[02468]?[13579]+)+";
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

        this.add(new JLabel("Introduzca la secuencia de numeros"), "left,wrap");
        this.add(tfOperacion, "pushx,growx,wrap");
        this.add(btnIngresar, "right,wrap");
        this.add(lblEntrada, "wrap");
        this.add(lblResultado, "center,pushy,,wrap");

        this.pack();
        this.setLocationRelativeTo(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Ejercicio1U2().setVisible(true);
    }

}
