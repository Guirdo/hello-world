/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author diann
 */
public class Triangulo extends JLabel implements MouseMotionListener{
    
    private Vertice v1, v2, v3;
    private JPanel lienzo;
    
    
    public Triangulo(int x1, int y1, int x2, int y2, int x3, int y3, JPanel lienzo){
        
        this.lienzo=lienzo;
        this.addMouseMotionListener(this);
        
        setBounds(0, 0,this.lienzo.getWidth(),this.lienzo.getHeight());
        v1= new Vertice(x1,y1, lienzo);
        v2= new Vertice(x2,y2, lienzo);
        v3= new Vertice(x3,y3, lienzo);
        
        //v1.addMouseMotionListener(v1);
        //v2.addMouseMotionListener(v2);
        //v3.addMouseMotionListener(v3);
        this.lienzo.add(v1);
        this.lienzo.add(v2);
        this.lienzo.add(v3);
    }
    
    @Override
    public void paint(Graphics g){
        
        int x[]={v1.getX()+v1.getWidth()/2, v2.getX()+v2.getWidth()/2, v3.getX()+v2.getWidth()/2};
        int y[]={v1.getY()+v1.getHeight()/2, v2.getY()+v2.getHeight()/2, v3.getY()+v3.getHeight()/2};
        //g.setColor();
        g.fillPolygon(x,y,3);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.setLocation(this.getX()+e.getX()-(this.getWidth()/2), this.getY()+e.getY()-(this.getHeight()/2));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}
