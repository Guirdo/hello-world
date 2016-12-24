import java.io.*;

public class Prog3_1{
  public static void main(String[] args) {
    double euros,pesos,yen,cambioP,cambioY;
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    try {
      System.out.print("Introduzca la cantidad de euros: ");
      euros = Double.parseDouble(sc.readLine());
      System.out.print("Introduzca el tipo de cambio para el peso: ");
      cambioP = Double.parseDouble(sc.readLine());
      System.out.print("Introduzca el tipo de cambio para el Yen: ");
      cambioY = Double.parseDouble(sc.readLine());

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
