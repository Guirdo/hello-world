import java.util.*;

public class Principal{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    NIF nif = new NIF();
    int dni;
    String dniC;

    do {
      System.out.print("Introduzca los ochos digitos de su DNI: ");
      dni = sc.nextInt();

      if (dni < 10000000 || dni > 99999999) {
        System.out.println("Error: introduzca un dni con ocho caracteres.");
      }

    } while (dni < 10000000 || dni > 99999999);

    nif.setDNI(dni);

    System.out.println("El DNI es: "+nif.toString());


  }
}
