import java.util.*;

public class EntSal02{
  public static void main(String[] args) {
    float canMi;
    Scanner sc = new Scanner(System.in);

    try {
      System.out.println("\nConversion de millas a kilometros: \n");
      System.out.print("Introduce una cantidad en millas: ");
      canMi = sc.nextFloat();
      System.out.println("\n"+canMi+" millas equivale a "+canMi*1.60934+" kilometros.");
    }
    catch (Exception e) {
      System.out.println("Error...");
    }
  }
}
