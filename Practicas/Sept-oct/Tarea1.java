import java.util.*;

public class Tarea1{

  public static void main(String[] args) {

    int opc,num,i;
    double raiz,seno,cua;
    String tipo=null;

    //Llama a la funcion Random para generar los numeros aleatorios
    Random alea = new Random();
    //Esto es como el scanf
    Scanner sc = new Scanner(System.in);

    //Esto equivale a printf
    System.out.print("1 - Empezar.\n2 - Salir.\nR= ");
    //Esto equivale a usar scanf
    opc = sc.nextInt();

    //Pues el switch
    switch (opc) {
      case 1:

        //Columnas de la Pseudotabla
        System.out.println("Numeracion\tNumero\tTipo\tCuadrado\tRaiz\t \t \tSeno");

        //Ciclo que genera todos los resultados necesarios
        for (i=1;i<=10 ;i++ ) {
          //Genera el numero aleatorio
          num = (int)Math.floor(alea.nextDouble()*(41-1+1)-1);

          //Comprueba si es par o impar
          if (num % 2 == 0) {
            tipo = "Par";
          }else {
            tipo = "Impar";
          }

          //Cuadrado, raiz cuadrada y seno, respectivamente
          cua = Math.pow(num,2);
          raiz = Math.sqrt(num);
          seno = Math.sin(num);

          //Equivalente a printf, imprime los resultados del numero aleatorio generado
          System.out.println(i+"\t \t"+num+"\t"+tipo+"\t"+cua+"\t \t"+raiz+"\t \t"+seno);

          //Devuelve un valor nuestro a num para la siguiente repeticion
          num = 0;
        }

      break;

      case 2:
        System.out.println("Hasta luego");
      break;
    }

  }

}
