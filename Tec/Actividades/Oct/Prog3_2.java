import java.util.*;

public class Prog3_2{
  public static void main(String[] args) {
    double euros,pesos,yen,cambioP,cambioY;
    Scanner sc = new Scanner(System.in);

    try {
      System.out.print("Introduzca la cantidad de euros: ");
      euros = sc.nextDouble();
      System.out.print("Introduzca el tipo de cambio para el peso: ");
      cambioP = sc.nextDouble();
      System.out.print("Introduzca el tipo de cambio para el Yen: ");
      cambioY = sc.nextDouble();

      pesos = euros*cambioP;
      yen = euros*cambioY;

      System.out.print("\t - Resultados -\n");
      System.out.println(euros+" euros en pesos: "+pesos);
      System.out.println(euros+" euros en Yenes: "+yen);
    }
    catch (Exception e) {
      System.out.println("Error...");
    }
  }
}
