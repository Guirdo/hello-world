package mision1;

import java.awt.Color;
import java.awt.Graphics;

public class Cuadrado extends Figura{
    private int lado;
    
    public Cuadrado(Color color,int lado) {
        super(color);
        this.lado=lado;
        
        this.setBounds(10, 10, lado+3, lado+3);
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(color);
        g.drawRect(2, 2, lado, lado);
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
    
    public void cambiarTam(int lado){
        this.lado=lado;
        this.setBounds(this.getX(), this.getY(), lado+3, lado+3);
    }

}
