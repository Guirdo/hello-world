package mision1;

import java.awt.Color;
import java.awt.Graphics;

public class Triangulo extends Figura{
    private int base;
    private int altura;

    public Triangulo(Color color, int base, int altura) {
        super(color);
        this.base=base;
        this.altura=altura;
        
        this.setBounds(10, 10, base+3, altura+3);
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(color);
        g.drawLine(0, this.getAltura(), this.getBase()/2,0);
        g.drawLine(this.getBase()/2, 0, this.getBase(), this.getAltura());
        g.drawLine(this.getBase(), this.getAltura(),0, this.getAltura());
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

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public void cambiarTam(int base,int altura){
        this.base=base;
        this.altura=altura;
        this.setBounds(this.getX(), this.getY(), base+3, altura+3);
    }
    
}
