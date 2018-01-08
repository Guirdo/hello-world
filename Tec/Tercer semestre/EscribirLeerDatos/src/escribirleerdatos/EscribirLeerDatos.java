/*
 * Hola!
 */
package escribirleerdatos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class EscribirLeerDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //Variables primitivas
        String nombre;
        int edad, menuPrincipal;
        //Variables complejas
        ListPersonas lista;
        //Objetos tecnicos
        DataOutputStream dos=null;
        DataInputStream dis=null;

        try {
            dos = new DataOutputStream(new FileOutputStream("datos.dat", true));
            dis = new DataInputStream(new FileInputStream("datos.dat"));
            lista = new ListPersonas();

            try {
                while (true) {
                    nombre = dis.readUTF();
                    edad = dis.readInt();

                    lista.agregar(new Persona(nombre, edad));
                }
            } catch (Exception e) {
                if (lista.tamano() < 1) {
                    System.out.println("Error: aún no se ha guardado nada en el archivo...");
                } else {
                    System.out.println("Se ha cargado el archivo con exito");
                }
            }

            do {
                menuPrincipal = JOptionPane.showOptionDialog(null, "", "Menú principal", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Agregar", "Vizualizar", "Salir"}, null);
                switch (menuPrincipal) {
                    case 0:
                        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
                        edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));

                        lista.agregar(new Persona(nombre, edad));
                        break;
                    case 1:
                        if (lista.tamano() < 1) {
                            JOptionPane.showMessageDialog(null, "No se ha ingresado ningun dato al archivo", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, lista.imprimir(), "Salida de datos", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                }
            } while(menuPrincipal!=2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            if(dos != null){
                dos.close();
            }
            if(dis != null){
                dis.close();
            }
        }

    }

}
