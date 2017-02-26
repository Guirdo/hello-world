package democliente;

import java.util.*;

public class DemoCliente {

    public static void main(String[] args) {
        String nombre, nomEmp;
        int edad;

        Cliente cli1 = new Cliente();
        Cliente cli2 = new Cliente("Juan", "Empresa Bahena", 22);
        Cliente cli3 = new Cliente("Guadalupe", "Empresa Chavez");

        System.out.println("Datos de salida:\n");
        nombre = cli2.nombre;
        nomEmp = cli2.nomEmp;
        edad = cli2.edad;
        System.out.println("\t -" + nombre + ",  de la " + nomEmp + ", tiene " + edad + " años.");

        nombre = cli1.nombre;
        nomEmp = cli1.nomEmp;
        edad = cli1.edad;
        System.out.println("\t -" + nombre + ",  de la " + nomEmp + ", tiene " + edad + " años.");

        nombre = cli3.nombre;
        nomEmp = cli3.nomEmp;
        edad = cli3.edad;
        System.out.println("\t -" + nombre + ",  de la " + nomEmp + ", tiene " + edad + " años.");
    }

}
