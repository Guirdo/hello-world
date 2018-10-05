package gatoraton;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boton extends JButton {

    //Atributos
    private final String RATON = "src\\imagenes\\raton.jpg";
    private final String GATO = "src\\imagenes\\gato.jpg";
    private boolean esClickeado,gato;

    public Boton() {
        this.setBackground(Color.white);
        esClickeado=false;
    }

    public void setAnimal(boolean animal) {
        if (animal) {//Gato
            this.setIcon(new ImageIcon(GATO));
        } else {//Raton
            this.setIcon(new ImageIcon(RATON));
        }
        gato=animal;
    }
    
    public boolean getEsClickeado(){
        return esClickeado;
    }
    
    public void setEsClickeado(boolean estado){
        this.esClickeado=estado;
    }
    
    public String getAnimal(){
        return this.getIcon().toString();
    }
}
