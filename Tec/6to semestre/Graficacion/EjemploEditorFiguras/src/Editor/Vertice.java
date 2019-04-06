/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author diann
 */
public class Vertice extends JButton implements MouseMotionListener{
    
    private int x, y;
    private JPanel lienzo;
    public Vertice(int x, int y,JPanel lienzo){
       this.lienzo=lienzo;
       this.setBounds(x,y,10,10);
       this.addMouseMotionListener(this);
    }

    public JPanel getLienzo() {
        return lienzo;
    }

    public void setLienzo(JPanel lienzo) {
        this.lienzo = lienzo;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        //this.setLocation((e.getX()+this.getX())-this.getWidth()/2,(e.getY()+this.getY())-this.getHeight()/2);
        this.setLocation(this.getX()+e.getX()-(this.getWidth()/2), this.getY()+e.getY()-(this.getHeight()/2));
        lienzo.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
