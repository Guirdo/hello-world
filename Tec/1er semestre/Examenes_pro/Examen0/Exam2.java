import java.util.Scanner;

public class Exam2{
  public static void main(String[] args) {

    int cal,i=1,num,sum=0,prom;
    double rep =0.0,apro=0.0,porcApro,porcRep,nume;
    Scanner sc = new Scanner(System.in);

    try {
      //Entrada de datos
      System.out.print("Introduzca el numero de alumnos: ");
      num = sc.nextInt();
      nume = num;
      do {
        System.out.print("Ingrese la calificacion del alumno["+i+"]: ");
        cal = sc.nextInt();
        if (cal >= 0 && cal <= 100) {
          i++;
          if (cal >= 0 && cal <=69) {
            rep++;
          }
          if (cal >= 70) {
            apro++;
          }
        }
        else {
          System.out.println("Error, calificacion no valida...");
        }
      } while (i<=num);
      porcApro = (apro / nume) * 100;
      porcRep = (rep / nume) * 100;

      System.out.println("Porcentaje de aprobados: "+porcApro+"%");
      System.out.println("Porcentaje de reprobados: "+porcRep+"%");
    }
    catch (Exception e) {
      System.out.println("Error al introducir datos...");
    }
    System.exit(0);
  }
}
