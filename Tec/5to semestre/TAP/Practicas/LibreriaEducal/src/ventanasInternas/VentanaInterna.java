package ventanasInternas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

public class VentanaInterna extends JInternalFrame{
    
    public VentanaInterna(String titulo){
        BorderLayout layout = new BorderLayout();
        
        this.setLayout(layout);
        this.setClosable(true);
        this.setSize(720,590);
        this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        this.setTitle(titulo);
        
        Image img = new ImageIcon(getClass().getResource("/imagenes/iconos/"+titulo.toLowerCase()+"16.png")).getImage();
        this.setFrameIcon(new ImageIcon(img));
    }
}
