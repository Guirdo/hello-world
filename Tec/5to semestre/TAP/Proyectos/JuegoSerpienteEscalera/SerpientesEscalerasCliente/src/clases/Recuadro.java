package clases;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Recuadro extends JLabel {

    private int serpEsca;
    private int jugadores;

    public Recuadro(String ruta, int serpEsca) {
        Image im = new ImageIcon(getClass().getResource(ruta)).getImage();
        this.setIcon(new ImageIcon(im));
        this.serpEsca=serpEsca;
        jugadores=0;
    }

    public int getSerpEsca() {
        return serpEsca;
    }
    
    public int darPosicionX(){
        jugadores++;
        return this.getX()+(jugadores*5);
    }
    
    public int darPosicionY(){
        return this.getY()+(jugadores*5);
    }
   
}
