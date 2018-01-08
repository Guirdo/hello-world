/*
 * Hola!
 */
package cuantossegundos;

import java.util.Scanner;

public class CuantosSegundos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int hrs,min,seg,segundos;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca las horas: ");
        hrs = sc.nextInt();
        
        System.out.print("Introduzca los minutos: ");
        min = sc.nextInt();
        
        System.out.print("Introduzca los segundos: ");
        seg = sc.nextInt();
        
        segundos = (3600*hrs)+(60*min)+seg;
        
        System.out.println(""+hrs+":"+min+":"+seg+" equivale a "+segundos+" segundos.");
    }
    
}
