import java.util.Scanner;

public class Exam1{
  public static void main(String[] args) {

    int a,b,aTemp,div,cont,i=1,mod=0,bTemp=0;
    double sum = 0,prom=0;
    Scanner sc = new Scanner(System.in);

    try {
      //Entrada de datos
      System.out.print("Introduzca un valor entero: ");
      a = sc.nextInt();
      System.out.print("Introduzca otro valor entero: ");
      b = sc.nextInt();

      if (a != b && a > 0 && b > 0) {
        if (a > b) {
          aTemp = b;
          b = a;
          bTemp = b;
          a = aTemp;
        }
        while (b >= a) {
          mod = b % 2;
          if (mod == 1) {
            sum += b;
          }
          b--;
          i++;
        }

        prom = sum/i;
        System.out.println("Promedio de los numeros impares entre "+a+ " y "+bTemp+": "+prom);
      }
      else {
        System.out.print("Datos no validos...");
      }
    }
    catch (Exception e) {
      System.out.print("Error...");
    }
  }
}
