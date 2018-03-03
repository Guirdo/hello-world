package democadenas;

import java.util.*;

public class DemoCadenas {

    public static void main(String[] args) {
        String cad1, cad2;
        boolean res;

        Scanner sc = new Scanner(System.in);
        Cadenas cadenitas = new Cadenas();
        
        try{
            //Entrada de datos
            System.out.print("Ingrese la primera cadena: ");
            cad1=sc.nextLine();
            System.out.print("Ingrese la segunda cadena: ");
            cad2=sc.nextLine();
            
            cadenitas.asginaValor(cad1, cad2);
            
            System.out.println("Valores de los atributos del objeto:\n\n");
            cadenitas.imprimeCad();
            
            if(res=cadenitas.comparaCad(cad1, cad2))
                System.out.println("Cadendas exactamente iguales...");
            else
                System.out.println("Cadendas no son exactamente iguales...");
            
        }catch(Exception e){
            System.out.println("Error, el dato debe ser numerico...");
        }
    }

}
