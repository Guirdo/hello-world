package mision1;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangulo extends Figura{
    
    private int base;
    private int altura;

    public Rectangulo(Color color, int base, int altura) {
        super(color);
        this.base=base;
        this.altura=altura;
        
        this.setBounds(10, 10, base+3, altura+3);
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.drawRect(2, 2, base, altura);
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
