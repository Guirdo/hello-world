/*
 * Hola!
 */
package lectorhora;

import java.util.Scanner;

public class LectorHora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int hrs,min,seg;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca las horas: ");
        hrs = sc.nextInt();
        
        System.out.print("Introduzca los minutos: ");
        min = sc.nextInt();
        
        System.out.print("Introduzca los segundos: ");
        seg = sc.nextInt();
        
        System.out.println("\n "+hrs+":"+min+":"+seg);
        
        seg+=1;
        
        if(seg == 60){
            min+=1;
            seg=0;
        }
        
        if(min==60){
            hrs+=1;
            min=0;
        }
        
        System.out.println("El tiempo más 1 segundo es: \n"
                            + ""+hrs+":"+min+":"+seg);
        
    }
    
}
