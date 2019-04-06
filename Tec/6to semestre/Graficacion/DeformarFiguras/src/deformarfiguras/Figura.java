package deformarfiguras;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Figura extends JLabel {

    public final static int TRIANGULO = 3;
    public final static int CUADRADO = 4;
    public final static int ESTRELLA = 10;

    private JPanel lienzo;
    private Color color;
    private int lados;

    private Vertice[] vertices;

    public Figura(int[] x, int[] y, int lados, Color clr, JPanel pnl) {
        this.lienzo = pnl;
        this.color = clr;
        this.lados = lados;
        this.vertices = new Vertice[lados];

        this.setBounds(0, 0, this.lienzo.getWidth(), this.lienzo.getHeight());

        for (int i = 0; i < lados; i++) {
            vertices[i] = new Vertice(x[i], y[i], this.lienzo);
            this.lienzo.add(vertices[i]);
        }
        //this.lienzo.repaint();
    }

    @Override
    public void paint(Graphics g) {

        int[] x = new int[lados];
        int[] y = new int[lados];

        for (int i = 0; i < lados; i++) {
            x[i]=vertices[i].getX()+vertices[i].getWidth()/2;
            y[i]=vertices[i].getY()+vertices[i].getHeight()/2;
        }

        g.setColor(color);
        g.fillPolygon(x, y, lados);
    }

}
