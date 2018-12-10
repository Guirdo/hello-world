package assets;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class Escritorio extends JDesktopPane{
    public Escritorio(){
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        Image img = new ImageIcon(getClass().getResource("/imagenes/fondos/library.jpg")).getImage();
        g.drawImage(img, 0, 0, null);
    }
}
