package graficatabla;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;

public class Etiqueta extends JLabel{

    private Color color;
    private String nombre;

    public Etiqueta(Color color, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }
    
    public Etiqueta(){
        this.setText("Hola aqui estoy");
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(0, 0, 10, 10);
        
        g.setColor(Color.BLACK);
        g.drawString(nombre, 0,10);
    }
    
    
    
}
