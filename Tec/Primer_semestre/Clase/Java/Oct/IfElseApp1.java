import java.util.*;

public class IfElseApp1{
  public static void main(String[] args) {
    int num1,num2,num3,res=0;
    Scanner sc = new Scanner(System.in);

    try {
      System.out.print("Introduce el primer valor: ");
      num1 = sc.nextInt();
      System.out.print("Introduce el segundo valor: ");
      num2 = sc.nextInt();
      System.out.print("Introduce el tercer valor: ");
      num3 = sc.nextInt();

      if (num1<num3) {
        res = num1+num2+num3;
        System.out.println("La suma de los tres numero es: "+res);
      }
      else {
        res = num1*num2*num3;
        System.out.println("El producto de los tres numeros es: "+res);
      }
    }
    catch (Exception e) {
      System.out.println("Error: Introduzca valores numericos....");
    }
    System.exit(0);
  }
}
