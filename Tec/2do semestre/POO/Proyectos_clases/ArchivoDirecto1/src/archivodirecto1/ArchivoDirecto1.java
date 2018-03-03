/*
 * Hola!
 */
package archivodirecto1;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class ArchivoDirecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        RandomAccessFile archivo = null;
        int num,pos=0;

        try {
            archivo = new RandomAccessFile("enteros.dat", "rw");
            
            do{
                System.out.print("Posicion del registro a almacenar (>= 1): ");
                pos = sc.nextInt();
            }while(pos < 1);
            
            pos--;
            
            archivo.seek(pos*4);
            
            System.out.print("Introduzca un numero entero: ");
            num = sc.nextInt();
            archivo.writeInt(num);
            archivo.seek(archivo.length());
            mostrarArchivo(archivo);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (archivo != null) {
                    archivo.close();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void mostrarArchivo(RandomAccessFile archivo) {
        int n = 0;
        try{
            archivo.seek(0);
            while(true){
                n = archivo.readInt();
                System.out.println(n);
            }
        } catch (IOException e) {
            //System.out.println("Error: fin del ciclo" + e.getMessage());
        }
        
    }

}
