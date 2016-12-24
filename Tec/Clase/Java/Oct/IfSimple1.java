import java.util.*;

public class IfSimple1{
  public static void main(String[] args) {
    int num,mil=0,cen=0,dec=0,uni=0,num2;
    Scanner sc = new Scanner(System.in);

    try {
      System.out.print("Introduzca un numero entero: ");
      num = sc.nextInt();

      num2 = num;

      if (num != 0) {

        if (num < 0) {
          num = -num;
        }

        if (num >= 1000) {
          mil = num/1000;
          num = num-(mil*1000);
        }
        if (num >= 100) {
          cen = num/100;
          num = num-(cen*100);
        }
        if (num >= 10) {
          dec = num/10;
          num = num-(dec*10);
        }
        if (num > 0) {
          uni = num;
        }

        System.out.println("El numero "+num2+" contiene "+mil+" millares, "+cen+" centenas, "+dec+" decenas y "+uni+" unidades.");

      }
      if (num2 == 0) {
        System.out.println("El numero "+num2+" tiene cero unidades.");
      }
    }
    catch (Exception e) {
      System.out.println("Error: introduzca valores numericos...");
    }
  }
}
