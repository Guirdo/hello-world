package deformarfiguras;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Vertice extends JButton implements MouseMotionListener{
    
    private int x;
    private int y;
    private JPanel lienzo;

    public Vertice(int x, int y, JPanel pnl){
//        this.x=x;
//        this.y=y;
        this.lienzo=pnl;
        
        this.setBounds(x, y, 10, 10);
        this.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.setLocation(this.getX()+e.getX()-(this.getWidth()/2), this.getY()+e.getY()-(this.getHeight()/2));
        lienzo.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}
