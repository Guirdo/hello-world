package mx.edu.itch.sistemas.seblab.InterfazGrafica;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boton extends JButton{
    
    /**
     * Crea un botón con texto.
     * @param texto el texto en el boton.
     */
    public Boton(String texto){
        super(texto);
    }
    
    /**
     * Crea un boton con texto, color de fondo y color de letras.
     * @param texto el texto en el boton.
     * @param bgColor color de fondo
     * @param fgColor color de letra
     */
    public Boton(String texto,Color bgColor,Color fgColor){
        super(texto);
        this.setBackground(bgColor);
        this.setForeground(fgColor);
    }
    
    /**
     * Crea un boton con texto, un icono, color de fondo y color de letras.
     * @param texto el texto en el boton.
     * @param img icono del boton
     * @param bgColor color de fondo
     * @param fgColor color de letra
     */
    public Boton(String texto,ImageIcon img,Color bgColor,Color fgColor){
        super(texto,img);
        this.setIcon(img);
        this.setBackground(bgColor);
        this.setForeground(fgColor);
    }

}
