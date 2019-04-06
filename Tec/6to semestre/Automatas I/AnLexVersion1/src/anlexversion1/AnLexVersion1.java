/*
 * Hola!
 */
package anlexversion1;

import java.util.Scanner;

/**
 * Programa obtendra una operacion escrita en la forma infija y pasarla a la forma prefija (notacion polaca)
 * Operacion = (4+7)-(4-2)*4
 * Recorrer la operacion de derecha a izquierda
 * @author Sebastián Méndez <ITCH>
 */
public class AnLexVersion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduzca la operacion: ");
        System.out.print("-> ");
        String operacion =sc.nextLine();
        
        Convertidor con = new Convertidor(operacion);
        System.out.println(con.darPrefija());
        
        
        
        
    }
    
    

}
