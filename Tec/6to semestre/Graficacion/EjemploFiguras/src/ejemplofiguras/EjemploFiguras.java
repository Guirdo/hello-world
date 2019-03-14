/*
 * Hola!
 */
package ejemplofiguras;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class EjemploFiguras extends JFrame{
    
    public EjemploFiguras(){
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Circulo cir = new Circulo();
        
        this.add(new Estrella(500,500));
        
        /**
         * Estudiar Graphics2D
         */
        
        //this.add(cir);
        
    }
    
    public void paint(Graphics g) {
        int ancho=500;
        int alto=500;
        int incremento=0;
        
        for (int i = 0; i < 249; i+=10) {
            g.setColor(Color.red);
            g.drawLine(ancho/2, 10+i, 250-i, alto/2);
            
            g.setColor(Color.blue);
            g.drawLine(ancho/2, 10+i, 250+i, alto/2);
            
            g.setColor(Color.GREEN);
            g.drawLine(ancho/2, 490-i, 250-i, alto/2);
            
            g.setColor(Color.BLACK);
            g.drawLine(ancho/2, 490-i, 249+i, alto/2);
            try{
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                Logger.getLogger(EjemploFiguras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new EjemploFiguras().setVisible(true);
    }
    
}
