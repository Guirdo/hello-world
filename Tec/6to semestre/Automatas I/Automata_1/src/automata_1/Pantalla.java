package automata_1;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Ventana;
import net.miginfocom.swing.MigLayout;

public class Pantalla extends Ventana{
    
    public JTextField tfCadena;
    public JLabel lblResultado;
    public JButton btnIngresar;

    public Pantalla() {
        super("Automata", new MigLayout("wrap","[]","[]10[]10[]20[]10[]"));
        
        btnIngresar = new JButton("Ingresar");
        tfCadena = new JTextField(15);
        lblResultado = new JLabel();
        
        this.add(new JLabel("Introduce una cadena: "));
        this.add(tfCadena);
        this.add(btnIngresar,"growx");
        this.add(new JLabel("Resultado"));
        this.add(lblResultado,"w :100:,h 25,center");
        
        this.pack();
        this.setLocationRelativeTo(null);
    }

}
