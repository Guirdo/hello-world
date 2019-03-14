package ejemplofiguras;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;

public class Circulo extends JLabel implements MouseMotionListener{

    public Circulo(){
        setBounds(0,0,100,100);
    }
    
    public void paint(Graphics g){
        g.drawOval(this.getWidth()/2,this.getHeight()/2, 50, 50);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}
