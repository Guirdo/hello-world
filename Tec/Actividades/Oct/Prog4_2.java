import java.util.*;

public class Prog4_2{
  public static void main(String[] args) {
    double preH,suelB,suelNe;
    int hrs;
    Scanner sc = new Scanner(System.in);

    try {
      //Entrada de datos
      System.out.print("Introduzca numero de horas trabajadas: ");
      hrs = sc.nextInt();
      System.out.print("Introduzca el precio por hora trabajada: ");
      preH = sc.nextDouble();

      suelB = hrs*preH;
      suelNe = suelB*80/100;

      //Salida de datos
      System.out.println("\nSueldo neto del trabajador: "+suelNe);
    }
    catch (Exception e) {
      System.out.println("Error: introduzca valores numericos...");
    }
  }
}
