package generadorfiguras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class Rectangulo extends Figura implements Serializable{
    
    private int base;
    private int altura;

    public Rectangulo(Color color, int base, int altura) {
        super(color);
        this.altura=altura;
        this.base=base;
        this.setBounds(10, 10, base+5, altura+5);
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(this.getColor());
        g.fillRect(0, 0, base, altura);
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
    
    public void cambiarTamano(int base,int altura){
        this.altura=altura;
        this.base=base;
        this.setBounds(this.getX(), this.getY(), base+5, altura+5);
    }

}
