package mx.edu.itch.sistemas.seblab.Imagen;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Imagen{
    
    /**
     * Proxima implementación para la comprobacion de rutas de imagenes.
     */
    private final String RUTA_REGEX = "";
    
    /**
     * Metodo que crear una imagen con la ruta absoluta del proyecto,
     * para que la imagen no tenga problemas en ser abierta en otro equipo.
     * @param parent Objeto punto de referencia.
     * @param ruta Ruta de la imagen.
     * @return Un {@code ImageIcon} de la imagen.
     */
    public static ImageIcon obtenerImagen(Component parent, String ruta){
        Image img;
        img = new ImageIcon(parent.getClass().getResource(ruta)).getImage();
        return new ImageIcon(img);
    }

}
