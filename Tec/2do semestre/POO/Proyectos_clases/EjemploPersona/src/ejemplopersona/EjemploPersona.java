package ejemplopersona;

import java.util.*;

public class EjemploPersona {

    public static void main(String[] args) {
        int edad;
        String nombre;

        Scanner sc = new Scanner(System.in);
        Persona personita = new Persona();

        System.out.println("Datos del objeto personita: \n");
        personita.mostrar();

        Persona personita1 = new Persona("Consuelo", 26);
        System.out.println("Datos del objeto personita1: \n");
        personita1.mostrar();

        try {
            System.out.println("\nDatos de entrada para el objeto persona1:\n");
            System.out.print("\t-Nombre: ");
            nombre = sc.nextLine();
            System.out.print("\t-Edad: ");
            edad = sc.nextInt();

            Persona persona1 = new Persona(nombre, edad);

            System.out.println("Datos del objeto persona: \n");
            persona1.mostrar();

        } catch (Exception e) {
            System.out.println("Error, el dato de ser numerico...");
        }
        System.exit(0);
    }

}
