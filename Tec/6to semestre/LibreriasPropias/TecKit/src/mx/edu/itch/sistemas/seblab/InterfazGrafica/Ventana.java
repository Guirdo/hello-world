package mx.edu.itch.sistemas.seblab.InterfazGrafica;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JFrame;

public class Ventana extends JFrame {

    /**
     * Crea una {@code Ventana} con titulo y con {@code MigLayout} como
     * manejador de layout.
     *
     * @param titulo titulo de la ventana.
     * @param layoutManager Menjador de layout
     */
    public Ventana(String titulo, LayoutManager layoutManager) {
        this.setTitle(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(layoutManager);
    }
    
    public void ponerBackground(Color bg){
        this.getContentPane().setBackground(bg);
    }

    /**
     * Crea una {@code Ventana} sin manejador de layout y una medida exacta de
     * base y altura.
     *
     * @param titulo titulo de la ventana
     * @param ancho ancho de la ventana
     * @param alto altura de la ventana
     */
    public Ventana(String titulo, int ancho, int alto) {
        this.setTitle(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(ancho, alto);
        this.setLocationRelativeTo(null);
    }
}
