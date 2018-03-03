package clases;

import java.io.IOException;
import java.io.RandomAccessFile;

public class DatosLibro {

    private final RandomAccessFile archivo;

    public DatosLibro(String nombreArchivo) throws IOException {
        archivo = new RandomAccessFile(nombreArchivo, "rw");
    }

    public Libro getLibro(int posicion) throws IOException {
        long pos = posicion * Libro.tamañoEnBytes;
        archivo.seek(pos);
        return Libro.leerArchivo(archivo);
    }

    public void escribeLibro(int posicion, Libro libro) throws IOException {
        long pos = posicion * Libro.tamañoEnBytes;
        archivo.seek(pos);
        libro.escribeArchivo(archivo);
    }

    public void cerrar() throws IOException {
        archivo.close();
    }

}
