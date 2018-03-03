/*
 * Hola!
 */
package escarchivosec;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class EscArchivoSec {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        FileOutputStream fos = null;
        DataOutputStream salida = null;

        String articulo;
        int cantidad, continuar = 0;
        double costo;

        try {
            fos = new FileOutputStream("ferreteria.dat", true);
            salida = new DataOutputStream(fos);

            while (continuar != 1) {
                articulo = JOptionPane.showInputDialog(null, "Articulo: ", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
                if (articulo.length() != 0) {
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                    costo = Double.parseDouble(JOptionPane.showInputDialog(null, "Costo: ", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));

                    salida.writeUTF(articulo);
                    salida.writeInt(cantidad);
                    salida.writeDouble(costo);
                    salida.flush();

                    continuar = JOptionPane.showOptionDialog(null, "Desea ingresar otro articulo?", "Continuar?",JOptionPane.YES_NO_OPTION ,JOptionPane.QUESTION_MESSAGE,null,null,null);
                } else {
                    JOptionPane.showMessageDialog(null, "Error, introduzca más de un caracter por lo menos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}
