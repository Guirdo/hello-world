/*
 * Hola!
 */
package leerarchivobinario;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class LeerArchivoBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataInputStream dis = null;
        String salida = "";

        try {
            dis = new DataInputStream(new FileInputStream("C:\\Users\\aldom\\Documents\\Código\\hello-world\\datos.dat"));

            salida += dis.readInt() + "\n" + dis.readUTF() + "\n" + dis.readInt() + "\n";
            
            System.out.print(salida);
        } catch (EOFException e) {
            System.out.println("Error1: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error2: " + e.getMessage());
        } finally {
            try {
                dis.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
