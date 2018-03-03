import java.io.*;

public class Prog4_1{
  public static void main(String[] args) {
    double preH,suelB,suelNe;
    int hrs;
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    try {
      //Entrada de datos
      System.out.print("Introduzca numero de horas trabajadas: ");
      hrs = Integer.parseInt(sc.readLine());
      System.out.print("Introduzca el precio por hora trabajada: ");
      preH = Double.parseDouble(sc.readLine());

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
