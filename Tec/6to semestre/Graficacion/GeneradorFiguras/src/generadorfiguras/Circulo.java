package generadorfiguras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class Circulo extends Figura implements Serializable {
    private int radio;

    public Circulo(Color color, int radio) {
        super(color);
        this.radio=radio;
        this.setBounds(10, 10, radio+5, radio+5);
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(this.getColor());
        g.fillOval(0, 0, radio, radio);
    }

    public int getRadio() {
        return radio;
    }

    public void cambiarTamano(int radio) {
        this.radio=radio;
        this.setBounds(this.getX(),this.getY(),radio+5, radio+5);
    }
}
