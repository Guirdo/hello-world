import java.io.*;

public class Prog1_1{
  public static void main(String[] args) {
    double b,h;
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    try {
      //Entrada de datos
      System.out.print("Introduzca la base:  ");
      b = Double.parseDouble(sc.readLine());
      System.out.print("Introduzca la altura: ");
      h = Double.parseDouble(sc.readLine());

      //Salida de datos
      System.out.println("\t - Resultados -");
      System.out.println("Area: "+b*h
                        +"\nPerimetro: "+((b*2)+(h*2)));
    }
    catch (Exception e) {
      System.out.println("Error: introduzca valores numericos...");
    }
  }
}
