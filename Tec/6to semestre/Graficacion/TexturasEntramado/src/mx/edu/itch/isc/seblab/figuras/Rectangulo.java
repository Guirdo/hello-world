package mx.edu.itch.isc.seblab.figuras;

import mx.edu.itch.isc.seblab.relleno.Relleno;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;
import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Rectangulo extends Figura {

    private int ancho,alto;

    public Rectangulo(JPanel pnl,Relleno relleno, int anc, int al) {
        super(pnl,relleno);
        this.ancho = anc;
        this.alto = al;

        this.setBounds(100,100,ancho+3,alto+3);
    }

    public Rectangulo(JPanel pnl,int tipoTramado, int anc, int al) {
        super(pnl,new Relleno(tipoTramado));
        this.ancho = anc;
        this.alto = al;

        this.setBounds(100,100,ancho+3,alto+3);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gg = (Graphics2D) g;

        BufferedImage img = relleno.getRelleno();
        gg.setPaint(new TexturePaint(img,new Rectangle(ancho,alto)));
        gg.fill(new Rectangle(ancho,alto));
    }

    public void cambiarTamano(int anc,int al){
        this.ancho = anc;
        this.alto = al;

        this.setBounds(110,110,ancho+3,alto+3);

        this.lienzo.repaint();
    }
}
