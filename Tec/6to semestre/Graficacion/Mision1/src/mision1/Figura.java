package mision1;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Figura extends JLabel implements MouseMotionListener,Serializable{

    Color color;
    
    public Figura(Color color){
        this.color=color;
        this.addMouseMotionListener(this);
    }
    
    public void bordear(boolean borde){
        if(borde){
            this.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else{
            this.setBorder(null);
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.setLocation(this.getX()+e.getX()-(this.getWidth()/2), this.getY()+e.getY()-(this.getHeight()/2));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
