/*
 * Hola, mortal. Saludos desde el más paca, o sease, desde el pasado.
 * Sabes, me canse escribriendo (la verdad no, pero me gusta el drama),
 * asi que usalo bien, ponte a estudiar cabron/a.
 */
package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
class EdadException extends Exception {

    public EdadException(String texto) {
        super(texto);
    }
}

class ExcepcionDivision extends Exception {

    public ExcepcionDivision(String msg) {
        super(msg);
    }
}

class Persona {

    int edad;

    public void setEdad(int edad) throws EdadException {
        if (edad <= 0 || edad > 120) {
            throw new EdadException("Error el dato esta fuera del rago permitido (1 - 120)");
        }
        this.edad = edad;
    }
}

public class Excepciones {

    static int divisionEnt(int dividendo, int divisor) throws ExcepcionDivision {
        if (divisor == 0) {
            throw new ExcepcionDivision("Error division entre cero...");
        }
        return dividendo / divisor;
    }

    public static void main(String[] args) {
        Persona persona = new Persona();
        int edad, divisor, dividendo;
        String respuesta="";
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Edad (1 - 120): ");
            edad = sc.nextInt();
            persona.setEdad(edad);
            System.out.println("El atributo se asigno correctamente!");

            try {
                System.out.print("Ingrese el dividendo: ");
                dividendo = sc.nextInt();
                System.out.print("Ingrese el divisor: ");
                divisor = sc.nextInt();
                respuesta = "El resultado es: " + divisionEnt(dividendo, divisor);
            }catch(InputMismatchException e){
                respuesta = "Error, el dato no es del tipo correecto...";
            }catch (ExcepcionDivision e) {
                respuesta = e.getMessage();
            }

            System.out.println(respuesta);

        }catch (EdadException e) {
            System.out.println(e.getMessage());
        }
    }

}
