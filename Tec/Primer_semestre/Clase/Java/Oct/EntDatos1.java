import java.io.*;

public class EntDatos1{
  public static void main(String[] args) {

    //Declaracion de variables
    String nombre,sexo;
    int edad;
    double sueldo;

    //No me gusta BufferedReader
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    try {
      //Entrada de datos
      System.out.print("Nombre: ");
      nombre = sc.readLine();
      System.out.print("Sexo: ");
      sexo = sc.readLine();
      System.out.print("Edad: ");
      edad = Integer.parseInt(sc.readLine());
      System.out.print("Sueldo: ");
      sueldo = Double.parseDouble(sc.readLine());

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
