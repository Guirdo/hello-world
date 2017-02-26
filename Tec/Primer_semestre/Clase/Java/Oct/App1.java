import java.util.*;

public class App1{
  public static void main(String[] args) {
    double x,y;
    Scanner sc = new Scanner(System.in);

    try {
      //Entrada de datos
      System.out.print("Introduzca un numero: ");
      x = sc.nextInt();

      //If
      if (x>=0) {
        y = Math.pow(x,2)+6;
      }else{
        y = 3*x+6;
      }

      //Salida de datos
      System.out.println("El valor de X es de: "+x);
      System.out.println("El valor de y es de: "+y);
    }
    catch (Exception e) {
      System.out.println("Error: introduzca valores numericos...");
    }
  }
}
