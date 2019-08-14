package mx.edu.itch.isc.seblab.principal;

import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Presentacion;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Ventana;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class Pantalla extends Ventana {

    public JTextField tfCadena;
    public JTextArea taResultado;
    public JButton btnInsertar;

    public Pantalla() {
        super("Automata 1", new MigLayout("wrap"
                ,"[]","[]10[]10[]15[]10[]"));

        this.getContentPane().setBackground(PaletaColores.LINX_WHITE);

        JLabel lblInsertar = new JLabel("Inserte cadena: ");
        JLabel lblResultado = new JLabel("Resultado");
        lblResultado.setFont(new Font("Arial",1,14));

        tfCadena = new JTextField(17);
        taResultado = new JTextArea(10,17);
        btnInsertar = new JButton("Insertar");

        btnInsertar.setBackground(PaletaColores.IRISH_BLUE);
        btnInsertar.setForeground(PaletaColores.LINX_WHITE);

        this.add(lblInsertar);
        this.add(tfCadena);
        this.add(btnInsertar,"growx");
        this.add(lblResultado);
        this.add(new JScrollPane(taResultado));

        this.pack();
        this.setLocationRelativeTo(null);

        new Presentacion("Actividad 11","Programa que ",new MigLayout(Presentacion.RESTRICCION,Presentacion.RESTRICCION_COLS,Presentacion.RESTRICCION_FILAS)).setVisible(true);
    }
}
