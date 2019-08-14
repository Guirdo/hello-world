package mx.edu.itch.isc.seblab.figuras;

import mx.edu.itch.isc.seblab.relleno.Relleno;
import mx.edu.itch.sistemas.seblab.Imagen.Imagen;
import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Cuadrado extends Figura {

    private int lado;

    public Cuadrado(JPanel pnl,Relleno relleno, int lado) {
        super(pnl,relleno);
        this.lado = lado;
        this.setBounds(50,50,lado+3,lado+3);
    }

    public Cuadrado(JPanel pnl,int tipoTramado, int lado) {
        super(pnl,new Relleno(tipoTramado));
        this.lado = lado;
        this.setBounds(50,50,lado+3,lado+3);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gg = (Graphics2D) g;

        BufferedImage img = relleno.getRelleno();
        gg.setPaint(new TexturePaint(img,new Rectangle(lado,lado)));
        gg.fill(new Rectangle(lado,lado));
    }

    public void cambiarTamano(int lado){
        this.lado = lado;
        this.setBounds(50,50,lado+3,lado+3);

        super.lienzo.repaint();
    }
}
