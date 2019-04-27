package mx.edu.itch.sistemas.ui;

import mx.edu.itch.sistemas.Graficos.Componente;
import mx.edu.itch.sistemas.Graficos.Ruleta;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Boton;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Ventana;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Principal extends Ventana {

    private JPanel panel;

    public Principal() {
        super("Animaciones", new MigLayout("wrap 2"));
        this.getContentPane().setBackground(PaletaColores.LIGHT_STEEL_BLUE_2);

        Ruleta ruleta;
        Boton btnIniciar = new Boton("Iniciar",PaletaColores.LINX_WHITE,null);
        Boton btnPausar = new Boton("Pausar",PaletaColores.LINX_WHITE,null);
        panel = new JPanel();
        ruleta = new Ruleta(panel);

        panel.setLayout(null);
        panel.add(ruleta);

        btnIniciar.addActionListener((ActionEvent)->{
            ruleta.mover();
        });

        btnPausar.addActionListener((ActionEvent)->{
            ruleta.reiniciar();
        });

        this.add(btnIniciar);
        this.add(btnPausar);
        this.add(panel,"w 500, h 500,span 2");

        this.pack();
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Principal().setVisible(true);
    }
}
