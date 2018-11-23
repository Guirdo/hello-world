package arrastrarsoltar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;

public class Tarjeta extends JLabel implements MouseMotionListener,MouseListener {
    
    private int posX,posY;
    private boolean enSuLugar,jugable;

    public Tarjeta() {
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }
    
    public Tarjeta(int x,int y){
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.setSize(50, 50);
        this.posX=x;
        this.posY=y;
        enSuLugar=false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.setLocation(this.getX()+e.getX()-(this.getWidth()/2), this.getY()+e.getY()-(this.getHeight()/2));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(this.getX()>= posX && this.getX()<=posX+20
                && this.getY()>=posY && this.getY()<=posY+20){
            boolean gano = true;
            enSuLugar=true;
            
            for (int i = 0; i < ArrastrarSoltar.getTarjetas().size(); i++) {
                if(!ArrastrarSoltar.getTarjetas().get(i).enSuLugar){
                    gano=false;
                    break;
                }
            }
            
            if (gano) {
                ArrastrarSoltar.gano();
            }
        }else{
            enSuLugar=false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    public boolean isEnSuLugar() {
        return enSuLugar;
    }

    public void setEnSuLugar(boolean enSuLugar) {
        this.enSuLugar = enSuLugar;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
