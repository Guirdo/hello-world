package recursividad;

import java.util.Scanner;

/** ITCH
 *Instituto Tecnologico de Chilpangingo
 * @author David Salas Chino
 */
public class Recursividad {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int decimal;
        System.out.println("Introduzca un numero de base decimal real: ");
        decimal =sc.nextInt();
        if(decimal>=0){
            System.out.println();
            System.out.println("El equivalente  en binario es de: "+decimal+"es:- ");
            conversion(decimal);
             
        }
        else{
            decimal=decimal/-1;
            System.out.println("el equivalente en binario es"+decimal+"es:-");
            conversion(decimal);
        //se divide entre menos uno, aplicando el concepto de valor absoluto y de esta forma
        //ejecutan el mismo metodo recursivo
        }
    }   
    public static void  conversion(int decimal){
        if (decimal < 2){
            System.out.println(decimal);
            return;}
        else{
            conversion(decimal/2);
            System.out.println(decimal%2);
            return;
        }
    }
}
