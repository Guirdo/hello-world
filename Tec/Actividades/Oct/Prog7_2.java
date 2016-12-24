import java.util.*;

public class Prog7_2{
  public static void main(String[] args) {
    double radio,peri,area;
    final double PI = 3.1415926536;
    Scanner sc = new Scanner(System.in);

    try {
      //Entrada de datos
      System.out.print("Introduzca la longitud del radio: ");
      radio = sc.nextDouble();

      //Operaciones
      peri = 2*PI*radio;
      area = PI*Math.pow(radio,2);

      //Salida de datos
      System.out.println("\nPerimetro: "+peri+"\nArea: "+area);
    }
    catch (Exception e) {
      System.out.println("Error, introduzca valroes numericos...");
    }
  }
}
