import java.util.*;

public class Prog6_2{
  public static void main(String[] args) {
    double est,peso,imc;
    Scanner sc = new Scanner(System.in);

    try {
      //ENtrada de datos
      System.out.print("Introduzca su altura en metros: ");
      est = sc.nextDouble();
      System.out.print("Introduzca su peso en kg: ");
      peso = sc.nextDouble();

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
