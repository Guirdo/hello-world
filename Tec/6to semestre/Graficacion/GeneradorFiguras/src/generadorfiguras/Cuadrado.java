package generadorfiguras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class Cuadrado extends Figura implements Serializable{
    
    private int lado;

    public Cuadrado(Color color, int lado) {
        super(color);
        this.lado = lado;
        this.setBounds(10, 10, lado+5, lado+5);
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(this.getColor());
        g.fillRect(0, 0, lado,lado);
    }

    public int getLado() {
        return lado;
    }

    public void cambiarTamano(int lado) {
        this.lado = lado;
        this.setBounds(this.getX(), this.getY(), lado+5, lado+5);
        
    }
    
    
}
