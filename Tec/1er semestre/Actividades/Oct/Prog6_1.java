import java.io.*;

public class Prog6_1{
  public static void main(String[] args) {
    double est,peso,imc;
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    try {
      //ENtrada de datos
      System.out.print("Introduzca su altura en metros: ");
      est = Double.parseDouble(sc.readLine());
      System.out.print("Introduzca su peso en kg: ");
      peso = Double.parseDouble(sc.readLine());

      //Operaciones
      imc = peso/Math.pow(est,2);

      //Salida de datos
      System.out.println("Su IMC es de: "+imc);
    }
    catch (Exception e) {
      System.out.println("Error: introduzca valores numericos...");
    }
  }
}
