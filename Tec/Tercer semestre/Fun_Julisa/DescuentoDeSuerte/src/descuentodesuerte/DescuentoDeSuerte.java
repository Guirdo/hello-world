/*
 * Hola!
 */
package descuentodesuerte;

import java.util.Random;
import java.util.Scanner;

public class DescuentoDeSuerte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random alea = new Random();
        Scanner sc = new Scanner(System.in);
        double compra,descuento;
        int numAleatorio;
        String continuar,porcentaje="";
        
        System.out.print("Ingrese el monto de su compra: $");
        compra = sc.nextDouble();
        
        System.out.println("Se esta seleccionado su numero de la suerte. ¡Mucha suerte!");
        
        numAleatorio = (int) Math.floor(alea.nextDouble()*(100-1+1)-1);
        System.out.println("Su número de la suerte es: "+numAleatorio);
        
        if(numAleatorio < 70){
            descuento = compra * 0.15;
            porcentaje = "15%";
        }else{
            descuento = compra * 0.2;
            porcentaje = "20%";
        }
        
        System.out.println("Su descuento es de "+porcentaje+" que equivale a $"+descuento);
        
    }
    
}
