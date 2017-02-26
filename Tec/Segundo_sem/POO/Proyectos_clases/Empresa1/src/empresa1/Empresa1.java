package empresa1;

import javax.swing.*;
import java.util.*;

public class Empresa1 {

    public static void main(String[] args) {
        String nombre, departamento, sexo, sal = "";
        String depas[] = {"Compras", "Contabilidad", "Control de calidad", "Ingenieria"};
        String opcSexo[] = {"Masculino", "Femenino"};
        String opcs[] = {"Si", "No"};
        int edad = 0, tiemTraba = 0, resp = 0;;
        //Instancia de la clase Empleado
        Calculos mets = new Calculos();
        //Declaracion del arreglo dinamico
        ArrayList<Empleado> arreEmpleados = new ArrayList<>();

        //Entrada de datos
        while (resp == 0) {
            //Nombre
            do {
                nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
                if (nombre.equals("")) {
                    JOptionPane.showMessageDialog(null, "Error, debe de introducir por lo menos un caracter", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                }
            } while (nombre.equals(""));

            //Sexo
            Object sex = JOptionPane.showInputDialog(null, "Seleccione el sexo del empleado", "Entrada de datos", JOptionPane.QUESTION_MESSAGE, null, opcSexo, null);
            sexo = sex.toString();

            //Edad
            do {
                try {
                    edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad del empleado", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                    if (edad < 18 || edad > 50) {
                        JOptionPane.showMessageDialog(null, "Error, la edad no esta dentro del rango admitido", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error, el dato debe ser numerico", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                }
            } while (edad < 18 || edad > 50);

            //Departamento
            Object dep = JOptionPane.showInputDialog(null, "Seleccione el departamento del empleado", "Entrada de datos", JOptionPane.QUESTION_MESSAGE, null, depas, null);
            departamento = dep.toString();

            //Tiempo trabajando en la empresa
            do {
                try {
                    tiemTraba = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tiempo trabajando en la empresa del empleado", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                    if (tiemTraba <= 0) {
                        JOptionPane.showMessageDialog(null, "Error, el tiempo de trabajo no esta dentro del rango admitido", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error, el dato debe ser numerico", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                }
            } while (tiemTraba <= 0);

            //Creacion del objeto empleado
            Empleado empleado = new Empleado(nombre, sexo, departamento, edad, tiemTraba);

            //Guardado del objeto en el arraglo dinamico
            arreEmpleados.add(empleado);

            resp = JOptionPane.showOptionDialog(null, "¿Desea introducir a otro empleado?", "Continuar (?)", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcs, null);
        }

        int pos = mets.darEmple(arreEmpleados);

        JOptionPane.showMessageDialog(null, "- Promedio de edad de las mujeres es de: " + mets.darPromMuj(arreEmpleados) + "\n"
                + "- Promedio de edad de los hombres es de: " + mets.darPromHom(arreEmpleados) + "\n"
                + "- Promedio de años trabjados en la empresa: " + mets.darPromAnosTra(arreEmpleados) + "\n\n"
                + "Empleado con mayor trayectoria:\n"
                + "\t- Nombre: " + arreEmpleados.get(pos).getNombre() + "\n"
                + "\t- Edad: " + arreEmpleados.get(pos).getEdad() + "\n\n"
                + "Porcentaje de empleados en cada departamento: \n"
                + "\t- Compras: " + mets.darPorCom(arreEmpleados) + "%\n"
                + "\t- Contabilidad: " + mets.darPorCon(arreEmpleados) + "%\n"
                + "\t- Control de calidad: " + mets.darPorConCa(arreEmpleados) + "%\n"
                + "\t- Ingenieria: " + mets.darPorInge(arreEmpleados) + "%", "Salida de datos", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }

}
