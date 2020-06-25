package mx.edu.itch.seblab.principal;

import mx.edu.itch.seblab.clases.Campo;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Campo campo;

    public Ventana(){
        this.setTitle("Boucing Balls");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new MigLayout());

        campo = new Campo();

        this.add(campo,"h 500,w 500");

        this.pack();
        this.setLocationRelativeTo(null);
    }
}
