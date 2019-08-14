package mx.edu.itch.isc.seblab.principal;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class Pantalla extends JFrame {

    public JTextField tfCadena;
    public JButton btnIngresar;
    public JTextArea taResultado;

    public Pantalla(){
        this.setTitle("Proyecto final");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new MigLayout("wrap","10[]10",
                "10[][][]15[][]10"));

        tfCadena = new JTextField(25);
        btnIngresar = new JButton("Ingresar");
        taResultado = new JTextArea(5,25);

        taResultado.setLineWrap(true);
        taResultado.setWrapStyleWord(true);

        this.add(new JLabel("Ingrese la cadena a evaluar: "));
        this.add(tfCadena);
        this.add(btnIngresar,"growx");
        this.add(new JLabel("Resultado"));
        this.add(new JScrollPane(taResultado),"");

        this.pack();
        this.setLocationRelativeTo(null);
    }
}
