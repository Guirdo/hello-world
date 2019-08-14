package principal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import mx.edu.itch.sistemas.seblab.Imagen.Imagen;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Ventana;

public class Principal extends Ventana implements KeyListener {

    JLabel sprite;
    int x, y;
    boolean pasoIzq;

    public Principal() {
        super("Spiderman", 500, 500);
        this.addKeyListener(this);

        sprite = new JLabel();
        sprite.setIcon(Imagen.obtenerImagen(this, "/imagenes/s5.png"));
        sprite.setBounds(100, 100, 100, 100);

        x = 100;
        y = 100;
        pasoIzq=true;

        this.add(sprite);

        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Principal().setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            switch (e.getKeyCode()) {

                case KeyEvent.VK_RIGHT:
                    
                    if(pasoIzq){
                        sprite.setIcon(Imagen.obtenerImagen(this, "/imagenes/s2.png"));
                    }else{
                        sprite.setIcon(Imagen.obtenerImagen(this, "/imagenes/s4.png"));
                    }
                    
                    x += 5;
                    sprite.setLocation(x, y);
                    pasoIzq=!pasoIzq;
                    Thread.sleep(15);
                    break;

            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Se libero");
    }

}
