import java.util.*;

public class EntDatos2{
  public static void main(String[] args) {

    //Declaracion de variables
    String nombre,sexo;
    int edad;
    double sueldo;

    //Es mejor Scanner
    Scanner sc = new Scanner(System.in);

    try {
      //Entrada de datos
      System.out.print("Nombre: ");
      nombre = sc.nextLine();
      System.out.print("Sexo: ");
      sexo = sc.nextLine();
      System.out.print("Edad: ");
      edad = sc.nextInt();
      System.out.print("Sueldo: ");
      sueldo = sc.nextDouble();

      //Salida de datos
      System.out.println("\nNombre: "+nombre);
      System.out.println("Sexo: "+sexo);
      System.out.println("Edad: "+edad);
      System.out.println("Sueldo: "+sueldo);
    }
    catch (Exception e) {
      System.out.println("Error al introducir datos");
    }
  }
}
