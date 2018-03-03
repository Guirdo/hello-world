/*
 * Hola!
 */
package archivo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

class NoEncontrado extends Exception {

    public NoEncontrado(String msg) {
        super(msg);
    }
}

class ArchivoVacio extends Exception {

    public ArchivoVacio(String msg) {
        super(msg);
    }
}

public class Archivo1 {

    static File arch;
    static FileWriter archivo = null;
    static PrintWriter pw = null;
    static FileReader fr = null;
    static BufferedReader entrada = null;
    static int conte = 0;

    static int busqueda(String nom) throws NoEncontrado, IOException {
        int posicion = 0, i = 0;
        String cadena;

        while ((cadena = entrada.readLine()) != null) {
            if (cadena.equals(nom)) {
                posicion = i;
            }
            i++;
        }

        if (posicion == -1) {
            throw new NoEncontrado("Error, el elemento no se encuentra en el archivo");
        }

        return posicion;
    }

    public static void main(String[] args) {

        String nombre;
        int seleccionMenu, num = 0;
        String[] menu = {"Agregar", "Consultar", "Eliminar", "Vizualizar", "Salir"};

        try {
            arch = new File("archivo.txt");
            archivo = new FileWriter(arch);
            pw = new PrintWriter(archivo);

            do {
                fr = new FileReader(arch);
                entrada = new BufferedReader(fr);

                seleccionMenu = JOptionPane.showOptionDialog(null, null, "Menú principal", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu, null);

                try {
                    switch (seleccionMenu) {
                        //Agregar
                        case 0:
                            int continuar = 0;

                            while (continuar != 1) {
                                nombre = JOptionPane.showInputDialog(null, "Ingrese un nombre", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
                                pw.println(nombre);

                                continuar = JOptionPane.showConfirmDialog(null, "¿Desea ingresar otro nombre?", "Continuar?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            }

                            break;

                        //Consultar
                        case 1:
                            String nom = JOptionPane.showInputDialog(null, "Ingrese el nombre a buscar", "Busqueda", JOptionPane.QUESTION_MESSAGE);
                            JOptionPane.showMessageDialog(null, "El nombre " + nom + " se encuentra en la posicion " + busqueda(nom) + " del archivo.", "Salida de datos", JOptionPane.INFORMATION_MESSAGE);
                            break;

                        //Eliminar
                        case 2:

                            String eliminar = JOptionPane.showInputDialog(null, "Ingrese el nombre a eliminar", "Eliminar", JOptionPane.QUESTION_MESSAGE);
                            int error = busqueda(eliminar);
                            eliminar(eliminar);
                            break;

                        //Vizualizar
                        case 3:

                            JOptionPane.showMessageDialog(null, vizualizar(), "Sali", JOptionPane.INFORMATION_MESSAGE);

                            break;
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

                pw.flush();//Hace un vaciado de los datos que puede ver en el buffer de salida
            } while (seleccionMenu != 4);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {

            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }

            pw.close();//cierre del archivo
        }
    }

    static String vizualizar() throws ArchivoVacio, IOException {
        String cadena, contenido = "";

        while ((cadena = entrada.readLine()) != null) {
            contenido += cadena + "\n";

        }

        if (contenido.isEmpty()) {
            throw new ArchivoVacio("Error, el archivo esta vacio");
        }

        return contenido;
    }

    static void eliminar(String nom) throws IOException {
        ArrayList<String> temp = new ArrayList<>();
        String nombre="";
        conte++;
        
        while ((nombre = entrada.readLine()) != null) {
            if (!nombre.equals(nom)) {
                temp.add(nombre);
            }
        }
        
        for(int r=0; r<temp.size();r++){
            System.out.println(temp.get(r));
        }

        if (arch.delete()) {
            arch = new File("archivo"+conte+".txt");
            archivo = new FileWriter(arch);
            pw = new PrintWriter(archivo);
            

            for (int j = 0; j < temp.size(); j++) {
                pw.print(temp.get(j));
            }

        }
    }
}
