package depsocial;

import java.util.*;
import javax.swing.JOptionPane;

public class DepSocial {

    public static void main(String[] args) {
        String nombre;
        int edad;
        double salario;

        Empleado empleado = new Empleado();
        Scanner sc = new Scanner(System.in);

        try {
            nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
            edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad del empleado", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
            salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el salario del empleado", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));

            empleado.asignarDatos(nombre, edad, salario);

            if (empleado.incrementarDatos()) {
                String msg;
                msg = "El salario se le incremento en un 20%";
                //Salida de datos
                JOptionPane.showMessageDialog(null, "Datos del empleado: \n" + empleado.vizualizarDatos() + "\n" + msg, "Salida de datos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Datos del empleado: \n" + empleado.vizualizarDatos(), "Salida de datos", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {

        }
        System.exit(0);
    }

}
