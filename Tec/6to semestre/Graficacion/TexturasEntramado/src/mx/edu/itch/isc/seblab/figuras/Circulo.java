package mx.edu.itch.isc.seblab.figuras;

import mx.edu.itch.isc.seblab.relleno.Relleno;
import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class Circulo extends Figura {

    private int radio;

    public Circulo(JPanel pnl,Relleno relleno, int rad) {
        super(pnl,relleno);
        this.radio = rad;

        this.setBounds(100,75,radio*2+3,radio*2+3);
    }

    public Circulo(JPanel pnl,int tipoTramado, int rad) {
        super(pnl,new Relleno(tipoTramado));
        this.radio = rad;

        this.setBounds(100,75,radio*2+3,radio*2+3);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gg = (Graphics2D) g;

        BufferedImage img = relleno.getRelleno();
        gg.setPaint(new TexturePaint(img,new Rectangle(radio*2,radio*2)));
        gg.fill(new Ellipse2D.Double(1,1,radio*2,radio*2));
    }

    public void cambiarTamano(int rad){
        this.radio = rad;
        this.setBounds(150,120,radio*2+3,radio*2+3);

        this.lienzo.repaint();
    }
}
