import java.io.*;

public class Prog5_1{
  public static void main(String[] args) {
    double cat1,cat2,hipo,peri,area;
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    try {
      //Entrada de datos
      System.out.print("Introduzca la medida del primer cateto: ");
      cat1 = Double.parseDouble(sc.readLine());
      System.out.print("Introduzca la medida del segundo cateto: ");
      cat2 = Double.parseDouble(sc.readLine());

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
