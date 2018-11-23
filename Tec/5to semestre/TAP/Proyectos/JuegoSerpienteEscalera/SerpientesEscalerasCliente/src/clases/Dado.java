package clases;

import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dado extends JLabel {

    public Dado(String ruta) {
        Image im = new ImageIcon(getClass().getResource(ruta)) .getImage();
        this.setIcon(new ImageIcon(im));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

    public void setCara(String ruta) {

        Image im = new ImageIcon(getClass().getResource(ruta)).getImage();
        this.setIcon(new ImageIcon(im));
    }
}
