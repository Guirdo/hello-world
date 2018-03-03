
package windows;

public class Ventana {
    protected int posX,posY,ancho,alto;

    public Ventana(int posX, int posY, int ancho, int alto) {
        this.posX = posX;
        this.posY = posY;
        this.ancho = ancho;
        this.alto = alto;
    }
    
   public void mostrar(){
       System.out.println("Posición X: "+posX+", Y: "+posY);
       System.out.println("Dimensiones ancho: "+ancho+", alto: "+alto);
   }
   
   public void cambiarDimensiones(int ancho, int alto){
       this.ancho=ancho;
       this.alto=alto;
   }
}
