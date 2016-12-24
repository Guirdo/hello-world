import java.util.*;

public class Empresa{
  public static void main(String[] args) {
    Empleado ems = new Empleado();
    Scanner sc = new Scanner(System.in);
    String nif,nombre;
    int numEm;

    do {
      System.out.print("Ingrese el numero de empleados: ");
      numEm = sc.nextInt();

      if (numEm<=0 || numEm>20) {
        System.out.println("Error: el numero de empleados debe ser mayor a 0\ny menor a 20");
      }
    } while (numEm<=0 || numEm>20);

    System.out.print("Ingrese NIF: ");
    nif = sc.nextLine();
    


  }
}
