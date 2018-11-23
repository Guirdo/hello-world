/*
 * Hola!
 */
package escribirarchivotexto;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class EscribirArchivoTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        FileWriter archivo = null;
        PrintWriter pw = null;

        String cadena;
        char resp = 'S';
        int seleccion;

        Object[] opcion = {"Si", "No"};
        try {
            archivo = new FileWriter("bytes.txt");
            pw = new PrintWriter(archivo);

            while (resp == 'S') {
                cadena = JOptionPane.showInputDialog(null, "Introducir la cadena de caracteres", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
                pw.println(cadena);

                seleccion = JOptionPane.showOptionDialog(null, "Desea ingresar otra cadena?", "Continuar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcion, null);
                switch (seleccion) {
                    case 0:
                        resp = 'S';
                        break;
                    case 1:
                        resp = 'N';
                        break;
                    case -1:
                        JOptionPane.showMessageDialog(null, "Error, usted no escogio ni si ni no", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        System.exit(1);
                    default:
                        break;
                }
            }

            pw.flush();//Hace un vaciado de los datos que puede ver en el buffer de salida

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        } finally {
            pw.close();//cierre del archivo
        }
    }

}
