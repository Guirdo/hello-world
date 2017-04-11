/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca;

/**
 *
 * @author aldom
 */
public class AppBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Libro lib = new Libro("Clemencia","1302-F",1864);
        
        Revista rev = new Revista(12,"El Zanate","111-r",2011);
        
        System.out.println("Libros: ");
        System.out.println(lib.toString());
        System.out.println("Revistas: ");
        System.out.println(rev.toString());
    }
    
}
