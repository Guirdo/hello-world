package mx.edu.itch.seblab.clases;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Campo extends JComponent {

    private ArrayList<Bola> bolas;

    public Campo() {
        this.setLayout(null);
    }

    public void setBolas(ArrayList<Bola> bolas) {
        this.bolas = bolas;
    }

    @Override
    public void paint(Graphics g) {
        for (Bola b : bolas) b.dibujar(g);
    }
}
