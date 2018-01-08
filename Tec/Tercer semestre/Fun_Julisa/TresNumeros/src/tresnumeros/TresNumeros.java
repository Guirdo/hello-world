/*
 * Hola!
 */
package tresnumeros;

import java.util.Scanner;

public class TresNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num1,num2,num3;
        Scanner sc = new Scanner(System.in);
        String pares = "",impares="";
        String mensaje = "",ordenados = "";
        String mensaje1="",mensaje2="";
        
        System.out.print("Introduzca el primer numero:  ");
        num1=sc.nextInt();
        
        System.out.print("Introduzca el segundo numero:  ");
        num2=sc.nextInt();
        
        System.out.print("Introduzca el tercero numero:  ");
        num3=sc.nextInt();
        
        //If que identifica pares e impares
        if(num1 %2 == 0){
            pares+=num1+", ";
        }else{
            impares+=num1+", ";
        }
        if(num2 %2 == 0){
            pares+=num2+", ";
        }else{
            impares+=num2+", ";
        }
        if(num3 %2 == 0){
            pares+=num3+", ";
        }else{
            impares+=num3+", ";
        }
        
        //If's que los acomoda
        if(num1 < num2 && num1 < num3){
            ordenados += num1+", ";
            if(num2 < num3){
                mensaje = "Los numeros estan ordenados de menor a mayor";
                ordenados += num2+", "+num3;
            }else{
                mensaje = "Los numeros estan desordenados...";
                ordenados += num3+", "+num2;
            }
        }else{
            mensaje = "Los numeros estan desordenados...";
            if(num2 < num1 && num2 < num3){
                ordenados += num2+", ";
                if(num1 < num3){
                    ordenados += num1+", "+num3;
                }else{
                    ordenados+= num3+", "+num1;
                }
            }else{
                ordenados += num3+", ";
                if(num1 < num2){
                    ordenados += num1+", "+num2;
                }else{
                    ordenados += num2+", "+num1;
                }
            }
        }
        
        //If que comprueba que num3 == num1+num2
        if(num3 == num1+num2){
            mensaje1="El tercer numero es igual a la suma de los dos primeros\n"+num1+"+"+num2+" = "+num3;
        }else{
            mensaje1="El tercer numero no es igual a la suma de los dos primeros...\n"+num1+"+"+num2+" != "+num3;
        }
        
        //if que comprueba cuales son los numeros mayores a 10
        if(num1 > 10 ){
            mensaje2+=num1+", ";
        }if(num2 > 10){
            mensaje2+=num2+", ";
        }if(num3 > 10){
            mensaje2+=num3+", ";
        }if(mensaje2.isEmpty()){
            mensaje2=" ninguno...";
        }
        
        System.out.println("\t--Resultados--\n");
        
        System.out.println("Los numeros pares son: "+pares);
        System.out.println("Los numeros impares son: "+impares);
        System.out.println("\t-"+mensaje);
        if(!mensaje.equals("Los numeros estan ordenados de menor a mayor")){
            System.out.println("Los numeros ordenados: "+ordenados);
        }
        System.out.println(mensaje1);
        System.out.println("Los numeros mayores a 10 son: "+mensaje2);
    }
    
}
