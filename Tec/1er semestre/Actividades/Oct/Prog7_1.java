import java.io.*;

public class Prog7_1{
  public static void main(String[] args) {
    double radio,peri,area;
    final double PI = 3.1415926536;
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    try {
      //Entrada de datos
      System.out.print("Introduzca la longitud del radio: ");
      radio = Double.parseDouble(sc.readLine());

      //Operaciones
      peri = 2*PI*radio;
      area = PI*Math.pow(radio,2);

      //Salida de datos
      System.out.print("\nPerimetro: "+peri+"\nArea: "+area);
    }
    catch (Exception e) {
      System.out.println("Error, introduzca valroes numericos...");
    }
  }
}
