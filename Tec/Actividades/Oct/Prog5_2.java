import java.util.*;

public class Prog5_2{
  public static void main(String[] args) {
    double cat1,cat2,hipo,peri,area;
    Scanner sc = new Scanner(System.in);

    try {
      //Entrada de datos
      System.out.print("Introduzca la medida del primer cateto: ");
      cat1 = sc.nextDouble();
      System.out.print("Introduzca la medida del segundo cateto: ");
      cat2 = sc.nextDouble();

      //Operaciones
      hipo = Math.sqrt(Math.pow(cat1,2)+Math.pow(cat2,2));
      area = cat1*cat2/2;
      peri = cat1+cat2+hipo;

      //Salida de datos
      System.out.println("\nHipotenusa: "+hipo
                          +"\nArea: "+area
                          +"\nPerimetro: "+peri);
    }
    catch (Exception e) {
      System.out.println("Error: introduzca valores numericos...");
    }
  }
}
