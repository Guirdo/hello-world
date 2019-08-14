package principal;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import java.awt.Frame;
import javax.swing.JFrame;

public class Principal {

    GLProfile pro = GLProfile.get(GLProfile.GL2);
    GLCapabilities cap = new GLCapabilities(pro);
    final GLCanvas glCanvas = new GLCanvas(cap);

    public Principal() {
        Ventana venta = new Ventana();
        glCanvas.addGLEventListener(venta);
        glCanvas.setSize(400,400);
        
       JFrame frame = new JFrame("Basic frame");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.add(glCanvas);
       frame.setSize(400,400);
       frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Principal();
    }
    
    
}
