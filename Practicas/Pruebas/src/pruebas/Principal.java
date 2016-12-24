/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;
import java.util.*;
/**
 *
 * @author guirdo
 */
public class Principal {
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

    System.out.println(nif.toString());


  }
}
