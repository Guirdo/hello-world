import java.util.*;

public class App2{
  public static void main(String[] args) {
    int tras;
    double precio,total=0,des=0;
    Scanner sc = new Scanner(System.in);

    try {
      //Entrada de datos
      System.out.print("Introduzca el precio de los trajes: ");
      precio = sc.nextDouble();
      System.out.print("Introduzca el valor de cada traje: ");
      tras = sc.nextInt();

      //Operaciones

      if (tras > 0) {
        if (tras > 3) {
          total = (tras*precio)*0.35;
          des = 0.65;
        }else if (tras == 3) {
          total = (tras*precio)*0.40;
          des = 0.6;
        }else if (tras == 2) {
          total = (tras*precio)*0.45;
          des = 0.55;
        }else{
          total = (tras*precio)*0.50;
          des = 0.5;
        }

        //Salida de datos
        System.out.println("El descuento aplicado a la compra es de: $"+(tras*precio)*des);
        System.out.println("El total de compra es de: "+total);

      }else{
        System.out.println("Error: introduzca numero de trajes mayor a cero...");
      }
    }
    catch (Exception e) {
      System.out.println("Error: introduzca valores numericos...");
    }
  }
}
