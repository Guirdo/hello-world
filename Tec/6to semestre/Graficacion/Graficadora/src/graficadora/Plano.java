package graficadora;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Plano extends JPanel{
    
    private int ancho,alto;
    private Punto origen;
    
    public Plano(int x, int y, int ancho, int alto){
        this.setBounds(x, y, ancho, alto);
        this.ancho=ancho;
        this.alto=alto;
        
        this.origen= new Punto(ancho/2, alto/2);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawLine(ancho/2, 0,ancho/2, alto);
        g.drawLine(0, alto/2, ancho, alto/2);
    }
    
    public void graficar(int a, int b, int x1, int x2){
        Graphics lienzo = this.getGraphics();
        lienzo.setColor(Color.red);
        int y1,y2;
        
        y1 = a * x1 +b;
        lienzo.drawOval(x1+origen.getX(), alto-(y1+origen.getY()), 2, 2);
        
        y2 = a * x2 +b;
        lienzo.drawOval(x2+origen.getX(), alto-(y2+origen.getY()), 2, 2);
        
        lienzo.drawLine(x1+origen.getX(), alto-(y1+origen.getY()),x2+origen.getX(), alto-(y2+origen.getY()));
    }

}
