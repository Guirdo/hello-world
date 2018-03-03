/*
 * Hola!
 */
package clases;

import java.io.IOException;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Clases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatosLibro datosLibro = null;

        try {
            datosLibro = new DatosLibro("libros.dat");
            Libro libro1 = new Libro("Aprenda Java ya", 2006, 515.00);
            Libro libro2 = new Libro("POO utilizando Java", 2004, 250.00);

            datosLibro.escribeLibro(0, libro1);
            datosLibro.escribeLibro(1, libro2);

            Libro objLibro1 = datosLibro.getLibro(0);
            Libro objLibro2 = datosLibro.getLibro(1);

            System.out.println(objLibro1.visualizaDatos());
            System.out.println(objLibro2.visualizaDatos());
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (datosLibro != null) {
                try {
                    datosLibro.cerrar();
                } catch (IOException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
    }

}
