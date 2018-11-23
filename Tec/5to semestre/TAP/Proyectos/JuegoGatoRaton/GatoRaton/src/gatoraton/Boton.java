package gatoraton;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boton extends JButton {

    //Atributos
    private String animal;
    private boolean esClickeado;
    private int posI,posJ;

    public Boton(int posI,int posJ) {
        this.posI=posI;
        this.posJ=posJ;
        this.setBackground(Color.white);
        esClickeado=false;
        animal = "INDEFINIDO";
    }

    public void setAnimal(boolean gato) {
        if (gato) {//Gato
            this.animal="gato";
        } else {//Raton
            this.animal="raton";
        }
        
        Image im = new ImageIcon(getClass().getResource("/imagenes/"+animal+".jpg")).getImage();
        
        this.setIcon(new ImageIcon(im));
     
    }
    
    public boolean getEsClickeado(){
        return esClickeado;
    }
    
    public void setEsClickeado(boolean estado){
        this.esClickeado=estado;
    }
    
    public String getAnimal(){
        return animal;
    }

    public int getPosI() {
        return posI;
    }

    public int getPosJ() {
        return posJ;
    }
}
