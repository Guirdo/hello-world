package mx.edu.itch.sistemas.seblab.Graficas;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public abstract class Grafica extends JPanel{
    
    /**
     * Constructor por defecto.
     */
    public Grafica(){
        this.setLayout(null);
    }
    
    /**
     * Crea una imagen a partir de lo dibujado en el panel.
     * @return la imagen obtenida.
     */
    public BufferedImage crearImagen() {
        BufferedImage bi = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        this.paint(g);
        g.dispose();
        return bi;
    }

}
