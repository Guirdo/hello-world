/*
 * Hola!
 */
package modificarrchivodirecto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class ModificarrchivoDirecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        RandomAccessFile archivo = null;
        int pos, num;
        long size;

        try {
            archivo = new RandomAccessFile("enteros.dat", "rw");
            size = archivo.length() / 4;
            System.out.print("El archivo tiene " + size + " regitros\n");
            do {
                System.out.print("Posicion del registro a modificar (>=1 y <=" + size + "):");
                pos = sc.nextInt();
            } while (pos < 1 || pos > size);

            pos--;

            archivo.seek(pos * 4);
            System.out.println("Valos actual: " + archivo.readInt());
            System.out.print("Introduce el nuevo valor: ");
            num = sc.nextInt();

            archivo.seek(pos * 4);
            archivo.writeInt(num);

            mostrarArchivo(archivo);

        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (archivo != null) {
                    archivo.close();
                }
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    private static void mostrarArchivo(RandomAccessFile archivo) {
        int n = 0;
        try {
            archivo.seek(0);
            while (true) {
                n = archivo.readInt();
                System.out.println(n);
            }
        } catch (IOException e) {
            //System.out.println("Error: fin del ciclo" + e.getMessage());
        }

    }

}
