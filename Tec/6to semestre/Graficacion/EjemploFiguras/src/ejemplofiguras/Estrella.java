package ejemplofiguras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Estrella extends JLabel implements MouseMotionListener{
    
    private int ancho,alto;
    
    public Estrella(int ancho,int alto){
        this.ancho=ancho;
        this.alto=alto;
        this.setBounds(0,0,ancho,alto);
        this.addMouseMotionListener(this);
        System.out.println(this.getHeight());
        System.out.println(this.getWidth());
    }

    
    public void paint(Graphics g) {
        int incremento=0;
        
        for (int i = 0; i < 249; i+=10) {
            g.drawLine(ancho/2, 10+i, 250-i, alto/2);
            g.drawLine(ancho/2, 10+i, 250+i, alto/2);
            g.drawLine(ancho/2, 490-i, 250-i, alto/2);
            g.drawLine(ancho/2, 490-i, 250+i, alto/2);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.setLocation(e.getX()+this.getX()-(this.getWidth()/2), e.getY()+this.getY()-(this.getHeight()/2));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}
