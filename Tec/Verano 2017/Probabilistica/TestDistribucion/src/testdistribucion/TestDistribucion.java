/*
 * Hola!
 */
package testdistribucion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class TestDistribucion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numEle;
        double num;
        ArrayList<Double> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Calculos c;

        System.out.print("Ingrese el numero de datos a ingresar: ");
        numEle = sc.nextInt();

        for (int i = 0; i < numEle; i++) {
            System.out.print("Ingrese el numero a ingresar ["+(i+1)+"]: ");
            num = sc.nextDouble();
            lista.add(num);
        }

        //Creacion del objeto
        c = new Calculos(lista);

        System.out.println(c.toString());

    }

}
