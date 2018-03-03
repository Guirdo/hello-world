/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartelera;
import java.util.*;
/**
 *
 * @author guirdo
 */
public class Cartelera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String titulo, tipo;
        
        Scanner sc = new Scanner(System.in);
        
        Pelicula peli= new Pelicula();
        Pelicula peli1 = new Pelicula("Medico Extraño");
        Pelicula peli2 = new Pelicula("Pi: el orden del caos","Thriller");
        
        System.out.println("Datos de entrada:\n");
        System.out.print("Titulo de la pelicula: ");
        titulo = sc.nextLine();
        
        System.out.print("Tipo de la pelicula: ");
        tipo = sc.nextLine();
        
        Pelicula peli3 = new Pelicula(titulo,tipo);
        
        System.out.println("Datos de salida:\n");
        
        System.out.print("\t-TItulo peli: "+peli.getTitulo()+", Tipo: "+peli.getTipo());
        System.out.print("\t-TItulo peli1: "+peli1.getTitulo()+", Tipo: "+peli1.getTipo());
        System.out.print("\t-TItulo peli2: "+peli2.getTitulo()+", Tipo: "+peli2.getTipo());
        System.out.print("\t-TItulo peli3: "+peli3.getTitulo()+", Tipo: "+peli3.getTipo());
    }
    
}
