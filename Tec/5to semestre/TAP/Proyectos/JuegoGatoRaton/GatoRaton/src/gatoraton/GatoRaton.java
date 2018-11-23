/*
 * Hola!
 */
package gatoraton;

import java.net.Socket;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class GatoRaton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Tablero t = new Tablero();
        t.setVisible(true);
        t.conectarServidor();
        t.escucharServidor();
    }
    
}
