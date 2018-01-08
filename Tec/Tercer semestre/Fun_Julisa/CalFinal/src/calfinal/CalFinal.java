/*
 * Hola!
 */
package calfinal;

import java.util.Scanner;

public class CalFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double cal,suma=0,promedio=0;
        Scanner sc = new Scanner(System.in);
        
        for(int i=0;i<4;i++){
            System.out.print("Ingrese la calificacion del parcial #"+(i+1)+": ");
            cal = sc.nextDouble();
            suma+=cal;
        }
        
        promedio=suma/4;
        
        System.out.println("La calificacion final es de: "+promedio);
    }
    
}
