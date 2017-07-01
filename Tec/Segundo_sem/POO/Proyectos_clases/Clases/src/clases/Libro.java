package clases;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Libro {

    private String titulo;
    private final int publicado;
    private final double precio;

    public static final int maxCaracteresTitulo = 100;
    public static final int tamañoEnBytes = 212;

    public Libro(String titulo, int publicado, double precio) {
        if (titulo.length() > maxCaracteresTitulo) {
            this.titulo = titulo.substring(0, maxCaracteresTitulo);
        } else {
            for (int i = titulo.length(); i < maxCaracteresTitulo; i++) {
                titulo += " ";
            }
            this.titulo = titulo;
        }
        this.publicado = publicado;
        this.precio = precio;
    }

    public static Libro leerArchivo(RandomAccessFile archivo) throws IOException {
        int fechaPub = archivo.readInt();
        double costo = archivo.readDouble();
        String titLibro = archivo.readLine();
        return new Libro(titLibro, fechaPub, costo);
    }

    public void escribeArchivo(RandomAccessFile archivo) throws IOException {
        archivo.writeInt(publicado);
        archivo.writeDouble(precio);
        archivo.writeBytes(titulo);
    }

    public String visualizaDatos() {
        return "Titulo: " + titulo + "\nFecha de publicacion: " + publicado + "\nPrecio: $" + precio + "\n";
    }

}
