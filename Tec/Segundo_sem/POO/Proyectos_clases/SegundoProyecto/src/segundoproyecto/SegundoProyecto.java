package segundoproyecto;

import java.util.Scanner;

public class SegundoProyecto {
    
    public static void main(String[] args) {
        double radio;
        Circulo circulito = new Circulo();
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("Dato de entrada: ");
            System.out.print("\t-Radio: ");
            radio = sc.nextDouble();
            circulito.asignaValores(radio);
            
            System.out.println("\nDato de salida: ");
            System.out.println("\t-Perimetro: " + circulito.calculoPerimetro());
            System.out.println("\t-Area: " + circulito.calculaArea());
        } catch (Exception e) {
            System.out.println("Error, el dato debe de ser numerico...");
        }
        System.exit(0);
    }
    
}
