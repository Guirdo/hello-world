/*
 * Hola, mortal. Saludos desde el más paca, o sease, desde el pasado.
 * Sabes, me canse escribriendo (la verdad no, pero me gusta el drama),
 * asi que usalo bien, ponte a estudiar cabron/a.
 */
package escribirarchivo;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class EscribirArchivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        FileOutputStream fs = null;
        byte[] buffer = new byte[1024];
        int nCar;

        try {
            System.out.println("Escriba el texto que desea almacenar en el archivo:\n");
            System.out.print("=> ");
            nCar = System.in.read(buffer);

            fs = new FileOutputStream("C:\\Users\\aldom\\Documents\\Código\\hello-world\\bytes.txt");
            fs.write(buffer, 0, nCar);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } finally {
            try {
                if (fs != null) {
                    fs.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        System.exit(0);
    }

}
