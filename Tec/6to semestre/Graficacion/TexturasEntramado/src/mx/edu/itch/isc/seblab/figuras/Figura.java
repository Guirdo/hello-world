package mx.edu.itch.isc.seblab.figuras;

import mx.edu.itch.isc.seblab.relleno.Relleno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Figura extends JLabel implements MouseMotionListener {

    protected JPanel lienzo;
    protected Relleno relleno;

    public Figura(JPanel pnl,Relleno relleno){
        this.lienzo=pnl;
        this.relleno=relleno;
        this.addMouseMotionListener(this);
    }

    public void cambiarRelleno(Relleno rellenoNuevo){
        this.relleno=rellenoNuevo;

        lienzo.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.setLocation(this.getX()+e.getX()-(this.getWidth()/2), this.getY()+e.getY()-(this.getHeight()/2));
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
