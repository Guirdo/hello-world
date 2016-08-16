import java.util.Scanner;

public  class CalcSif{
  public static void main(String[] args) {

    double puntosB,puntosbru,puntosTo;
    int numC,com,rankP;
    char dif;

    Scanner sc = new Scanner(System.in);

    try {
      //Entrada de datos
      System.out.println("\n - Selecciona dificultad - ");
      System.out.print("Easy(1), Normal(2), Hard(3) o Expert(4): ");
      dif = sc.next().charAt(0);
      System.out.println("\n - Numero de canciones - ");
      System.out.print("¿Cuantas canciones juegas? (1 - 3): ");
      numC = sc.nextInt();
      System.out.println("\n - Combo - ");
      System.out.print("S(1), A(2), B(3), C(4) o No combo(0): ");
      com = sc.nextInt();
      System.out.println("\n - Rank - ");
      System.out.print("S(1), A(2), B(3), C(4) o No rank(0): ");
      rankP = sc.nextInt();

      //Inicializar
      puntosB = 0;
      puntosbru = 0;
      puntosTo = 0;

      if (dif == '1' && numC == 1) {
        puntosB = 31;
      }
      else {
        if (dif == '1' && numC == 2) {
          puntosB = 64;
        }
        else {
          if (dif == '1' && numC == 3){
          puntosB = 99;
          }
        }
      }

      if (dif == '2' && numC == 1) {
        puntosB = 72;
      }
      else {
        if (dif == '2' && numC == 2) {
          puntosB = 150;
        }
        else {
          if (dif == '2' && numC == 3){
          puntosB = 234;
          }
        }
      }

      if (dif == '3' && numC == 1) {
        puntosB = 126;
      }
      else {
        if (dif == '3' && numC == 2) {
          puntosB = 262;
        }
        else {
          if (dif == '3' && numC == 3){
          puntosB = 408;
          }
        }
      }

      if (dif == '4' && numC == 1) {
        puntosB = 241;
      }
      else {
        if (dif == '4' && numC == 2) {
          puntosB = 500;
        }
        else {
          if (dif == '4' && numC == 3){
          puntosB = 777;
          }
        }
      }

      switch (com) {
        case 1:
          puntosbru = puntosB * 1.08;
          break;
        case 2:
          puntosbru = puntosB * 1.06;
          break;
        case 3:
          puntosbru = puntosB * 1.04;
          break;
        case 4:
          puntosbru = puntosB * 1.02;
          break;
        case 0:
          puntosbru = puntosB * 1;
          break;
      }

      switch (rankP) {
        case 1:
          puntosTo = puntosbru * 1.2;
          break;
        case 2:
          puntosTo = puntosbru * 1.15;
          break;
        case 3:
          puntosTo = puntosbru * 1.1;
          break;
        case 4:
          puntosTo = puntosbru * 1.05;
          break;
        case 0:
          puntosTo = puntosbru * 1;
          break;
      }

      System.out.println("\n RESULTADOS \n");
      System.out.println("Los puntos que obtendras son: "+puntosTo);

    }//try
    catch (Exception e) {
      System.out.print("Error...");
    }
    System.exit(1);
  }
}
