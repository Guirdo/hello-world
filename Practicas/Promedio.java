import java.util.Scanner;

public class Promedio{

  public static void main(String[] args){

    int i;
    double num,sum,prom,cal;
    Scanner entDatos = new Scanner(System.in);

    try{
      //Entrada de datos
      System.out.print("\nIntroduce cuantas materias tienes: ");
      num = entDatos.nextDouble();

      //Contador y suma
      i = 1;
      sum = 0;

      //Entrada de datos
      do{
        System.out.print(i + "° calificacion: ");
        cal = entDatos.nextDouble();
        i++;
        sum = sum + cal;
      }while(i <= num);

      //operaciones
      prom = sum / num;

      System.out.println("\nRESULTADOS\n");
      System.out.println("Tu calificacion es de " + prom);

      //Los IF's
      if(prom >= 8.1 && prom <= 10)
        System.out.println("¡Felicidades, sigue asi!\n");
      if(prom >= 6 && prom <= 8)
        System.out.println("Sigue esforzandote...\n");
      if(prom <= 5.9)
        System.out.println("Mejor suerte para la proxima\n");
    }//try
    catch(Exception e){
      System.out.println("Error al introducir datos...\n");
    }
    System.exit(0);


  }//main

}//public class
