/*
 * Hola!
 */
package escarchivobinario;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class EscArchivoBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataOutputStream dos = null;

        try {
            dos = new DataOutputStream(new FileOutputStream("C:\\Users\\aldom\\Documents\\Código\\hello-world\\datos.dat"));
            dos.writeInt(57);
            dos.writeUTF("ITCH");
            dos.writeInt(2017);
        } catch (Exception e) {
            System.out.println("Error E/S");
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            }catch(IOException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }

}
