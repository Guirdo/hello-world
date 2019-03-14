package generadorfiguras;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public abstract class Figura extends JLabel implements MouseMotionListener, Serializable{
    private Color color;
    
    public Figura(Color color){
        this.color=color;
        this.addMouseMotionListener(this);
    }
    
    public Color getColor(){
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public void setBorder(boolean borde){
        if(borde){
            this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        }else{
            this.setBorder(null);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.setLocation(this.getX()+e.getX()-(this.getWidth()/2), this.getY()+e.getY()-(this.getHeight()/2));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

}
