import java.io.*;

public class EntSal01{
  public static void main(String[] args) {
    //Declaracion de variables
    String nombre;
    int añoNac, añoAct;

    //Declaracion de objeto
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    try {
      System.out.print("Nombre: ");
      nombre = sc.readLine();
      System.out.print("Año de nacimiento: ");
      añoNac = Integer.parseInt(sc.readLine());
      System.out.print("Año actual: ");
      añoAct = Integer.parseInt(sc.readLine());

      //Salida de datos
      System.out.println("\n"+nombre+
                          " actualmente haz cumplido o vas a cumplir "+
                          (añoAct-añoNac)+" años, felicidades!");
    }
    catch (Exception e) {
      System.out.println("Error, introduzca los valores correctos...");
    }
  }
}
