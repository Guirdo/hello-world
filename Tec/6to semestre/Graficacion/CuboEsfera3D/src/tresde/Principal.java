package tresde;

import java.awt.Frame;
import org.scijava.java3d.utils.applet.MainFrame;

public class Principal {

    public static void main(String[] args) {
        Frame frame = new MainFrame(new Cubo(), 256, 256); //Tamaño ventana de 256x256 pixeles.
        //frame.setVisible(true);
    }
    
}
