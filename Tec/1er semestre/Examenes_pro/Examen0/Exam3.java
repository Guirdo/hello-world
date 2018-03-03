import java.util.Scanner;

public class Exam3{
  public static void main(String[] args) {

    int num,i=1;
    double suelMen,monVen,comi=0,nsueldo=0;
    Scanner sc = new Scanner(System.in);

    try {
      //Entrada de datos
      System.out.print("Ingrese el numero de vendedores: ");
      num = sc.nextInt();

      do {
        System.out.println("\n - Datos del empleado["+i+"] - " );
        System.out.print("Ingrese el sueldo mensual: ");
        suelMen = sc.nextDouble();
        System.out.print("Ingrese monto de venta: ");
        monVen = sc.nextDouble();
        if (suelMen > 0 && monVen > 0) {
          i++;
          if (monVen > 10000) {
            comi = monVen * 0.15;
            nsueldo= suelMen+comi;
            System.out.println("\nResultados para el empleado["+i+"]\n");
            System.out.println("\t -Comision del 15%: "+comi);
            System.out.println("\t -Nuevo Sueldo: "+nsueldo);
          }
          if (monVen >= 5000 && monVen <= 10000) {
            comi = monVen * 0.05;
            nsueldo= suelMen+comi;
            System.out.println("\nResultados para el empleado["+i+"]\n");
            System.out.println("\n -Comision del 5%: "+comi);
            System.out.println("\n -Nuevo Sueldo: "+nsueldo);
          }
          if (monVen < 5000) {
            System.out.println("\nResultados para el empleado["+i+"]\n");
            System.out.println("\n -No se aplica comision por venta menor a $5000.");
            System.out.println("\n -Sueldo mensual actual: "+suelMen);
          }
        }
        else {
          System.out.print("Error, algun dato no es valido, vuelva a ingresarlo...");
        }

      } while (i <= num);
    }
    catch (Exception e) {
      System.out.println("\nError al introducir datos...");
    }
    System.exit(0);
  }
}
