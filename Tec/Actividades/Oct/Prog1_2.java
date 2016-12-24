import java.util.*;

public class Prog1_2{
  public static void main(String[] args) {
    double b,h;
    Scanner sc = new Scanner(System.in);

    try {
      //Entrada de datos
      System.out.print("Introduzca la base:  ");
      b = sc.nextDouble();
      System.out.print("Introduzca la altura: ");
      h = sc.nextDouble();

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
