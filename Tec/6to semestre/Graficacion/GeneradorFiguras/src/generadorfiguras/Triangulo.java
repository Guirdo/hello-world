package generadorfiguras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class Triangulo extends Figura implements Serializable{
    
    private int base;
    private int altura;

    public Triangulo(Color color, int base,int altura) {
        super(color);
        this.base=base;
        this.altura=altura;
        this.setBounds(10, 10, base+2, altura+2);
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(this.getColor());
        
        g.fillPolygon(new int[]{base/2,base,0}, new int[]{0,altura,altura},3);
        
        
//        g.drawLine(base/2, 0, base, altura);
//        g.drawLine(0, altura, base, altura);
//        g.drawLine(base/2, 0, 0, altura);
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void cambiatTamano(int base, int altura){
        this.base=base;
        this.altura=altura;
        this.setBounds(this.getX(), this.getY(), base+5, altura+5);
    }
    
    public void cambiarTamano(int base,int altura){
        this.altura=altura;
        this.base=base;
        this.setBounds(this.getX(), this.getY(), base+5, altura+5);
    }
}
