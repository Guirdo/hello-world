/*
 * Hola, mortal. Saludos desde el más paca, o sease, desde el pasado.
 * Sabes, me canse escribiendo (la verdad no, pero me gusta el drama),
 * asi que usalo bien, ¡ponte a estudiar cabron/a!
 */
package demofigura2;

public class DemoFigura2 {

    public static void main(String[] args) {
        Figura uno;
        
        uno = new Cuadrado("Normal",3);
        System.out.println("Tipo de cuadrado: "+uno.getTipo()+"\nArea: "+uno.area());
        
        uno = new Triangulo("Rectangulo",4,5);
        System.out.println("Tipo de tringulo: "+uno.getTipo()+"\nArea: "+uno.area());
    }
    
}
