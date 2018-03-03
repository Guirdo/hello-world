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
public class Libro extends Publicacion implements Prestamo {
    private boolean prestado;

    public Libro(boolean prestado, String titulo, String codigo, int año) {
        super(titulo, codigo, año);
        this.prestado = prestado;
    }

    public Libro(String titulo, String codigo, int año) {
        super(titulo, codigo, año);
    }
    
    public void prestar(){
        prestado = true;
    }
    
    public void devolver(){
        prestado = false;
    }
    
    public boolean prestado(){
        return prestado;
    }

    @Override
    public String toString() {
        
        if(prestado()){
            return super.toString() + "Estado del libro: prestado\n";
        }else
            return super.toString() + "Estado del libro: no prestado\n";
        
    }
    
    
}
