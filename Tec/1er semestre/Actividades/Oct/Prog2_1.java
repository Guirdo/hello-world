import java.io.*;

public class Prog2_1{
  public static void main(String[] args) {
    int seg;
    double hrs,min;
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    try {
      //Entrada de datos
      System.out.print("Introduzca el numero de segundo: ");
      seg = Integer.parseInt(sc.readLine());

      hrs = (1.0/3600.0)*seg;
      min = (1.0/60.0)*seg;

      //Salida de datos
      System.out.print("");
      System.out.println(seg+" a horas: "+hrs);
      System.out.println(seg+" a minutos: "+min);
      System.out.println(seg+" a segundo: "+seg);
    }
    catch (Exception e) {
      System.out.println("Error: introduzca valores numericos...");
    }
  }
}
