/*
 * Hola!
 */
package leerdatos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class LeerDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String nombre = "", telefono = "", eMail = "", edoCivil = "";
        int edad = 0, pos = 0;
        long tamReg = 176;
        long cantReg = 0;
        String salida = "Datos alamcenados en el archivo \n\n";

        try {
            RandomAccessFile archivo = new RandomAccessFile("datos.dat", "r");

            cantReg = archivo.length() / tamReg;
            
            System.out.print(cantReg);

            do {
                pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Posicion a leer", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                pos--;
            } while (pos < 0 || pos > cantReg);

            archivo.seek(0);
            archivo.seek(pos * tamReg);

            for (int i = 0; i < 35; i++) {
                nombre += archivo.readChar();
            }

            for (int i = 0; i < 10; i++) {
                telefono += archivo.readChar();
            }

            for (int i = 0; i < 30; i++) {
                eMail += archivo.readChar();
            }

            for (int i = 0; i < 11; i++) {
                edoCivil += archivo.readChar();
            }

            edad = archivo.readInt();

            if (edad > 0) {
                salida = "Nombre: " + nombre + "\nTelefono: " + telefono + "\neMail: " + eMail + "\nEdoCivil: " + edoCivil + "\nEdad: " + edad + "\n\n";
            }

            nombre = "";
            telefono = edoCivil = eMail = nombre;

            JOptionPane.showMessageDialog(null, salida, "Salida de datos", JOptionPane.INFORMATION_MESSAGE);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Mensaje de error", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Mensaje de error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
