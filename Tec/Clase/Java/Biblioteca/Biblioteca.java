import java.util.*;

public class Biblioteca{
  public static void main(String[] args) {

    String titulo,autor,edicion;
    int ejemplares,prestados;
    Scanner sc = new Scanner(System.in);
    //Usando constructor con parametros
    Libro libro1 = new Libro("Los dias de ayer",3,"Francisco","Primera");
    //Usando constructor por defecto
    Libro libro2 = new Libro();

    //Entrada de datos para el libro2
    System.out.print("Ingrese titulo: ");
    titulo = sc.nextLine();
    System.out.print("Ingrese autor: ");
    autor = sc.nextLine();
    System.out.print("Ingrese edicion: ");
    edicion = sc.nextLine();
    System.out.print("Ingrese la cantidad de ejemplares: ");
    ejemplares = sc.nextInt();

    //Mandando los datos recibidos
    libro2.setTitulo(titulo);
    libro2.setAutor(autor);
    libro2.setEjemplares(ejemplares);
    libro2.setEdicion(edicion);

    //Muestra los datos del libro1
    System.out.println("\nLibro 1: "+
                      "\nTitulo: "+libro1.getTitulo()+
                      "\nAutor: "+libro1.getAutor()+
                      "\nEdicion: "+libro1.getEdicion()+
                      "\nejemplares: "+libro1.getEjemplares());

    //Muestra los datos del libro2
    System.out.println("\nLibro 2:"+
                        "\nTitulo: "+libro2.getTitulo()+
                        "\nAutor: "+libro2.getAutor()+
                        "\nEdicion: "+libro2.getEdicion()+
                        "\nEjemplares: "+libro2.getEjemplares());


  }
}
