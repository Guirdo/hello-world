/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

/**
 *
 * @author aldom
 */
public class VentanaTitulo extends Ventana{
    protected String titulo;

    public VentanaTitulo(String titulo, int posX, int posY, int ancho, int alto) {
        super(posX, posY, ancho, alto);
        this.titulo = titulo;
    }
    
    public void mostrar(){
        System.out.println("Título: "+titulo);
        super.mostrar();
    }
    
    public void desplazar(int posX,int posY){
        super.posX=posX;
        super.posY=posY;
    }
}
