package mision1;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;

public class Circulo extends Figura{
    private int radio;

    public Circulo(Color color, int radio) {
        super(color);
        this.radio=radio;
        
        this.setBounds(10, 10, radio, radio);
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(color);
        g.drawOval(0, 0, radio, radio);
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
    
    public void cambiarTam(int radio){
        this.radio=radio;
        this.setBounds(this.getX(), this.getY(), radio, radio);
    }

}
