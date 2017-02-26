package empresa1;

import java.util.ArrayList;

public class Calculos {

    //Metodo que da el promedio de los hombres
    public double darPromHom(ArrayList<Empleado> lista) {
        double prome = 0, suma = 0, ind = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getSexo().equals("Masculino")) {
                suma += lista.get(i).getEdad();
                ind++;
            }
        }

        prome = suma / ind;
        return prome;
    }

    //Metodo que da el promedio de las mujeres
    public double darPromMuj(ArrayList<Empleado> lista) {
        double prome = 0, suma = 0, ind = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getSexo().equals("Femenino")) {
                suma += lista.get(i).getEdad();
                ind++;
            }
        }

        prome = suma / ind;
        return prome;
    }

    //Metodo que da el promedio de tiempo trabajando para la empresa
    public double darPromAnosTra(ArrayList<Empleado> lista) {
        double prome = 0, suma = 0, ind = 0;

        for (int i = 0; i < lista.size(); i++) {
            suma += lista.get(i).getTiemTraba();
        }

        prome = suma / lista.size();
        return prome;
    }

    //Metodo que busca al empleado con mayor trayectoria en la empresa
    public int darEmple(ArrayList<Empleado> lista) {
        int pos = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (pos <= lista.get(i).getTiemTraba()) {
                pos = i;
            }
        }

        return pos;
    }

    //Seria de metodos que sacan el porcentaje de empleados en cada departamento
    //Compras
    public double darPorCom(ArrayList<Empleado> lista) {
        double porc = 0, suma = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDepartamento().equals("Compras")) {
                suma++;
            }
        }

        porc = (suma / lista.size()) * 100;

        return porc;
    }

    public double darPorCon(ArrayList<Empleado> lista) {
        double porc = 0, suma = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDepartamento().equals("Contabilidad")) {
                suma++;
            }
        }

        porc = (suma / lista.size()) * 100;

        return porc;
    }

    public double darPorConCa(ArrayList<Empleado> lista) {
        double porc = 0, suma = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDepartamento().equals("Control de calidad")) {
                suma++;
            }
        }

        porc = (suma / lista.size()) * 100;

        return porc;
    }

    public double darPorInge(ArrayList<Empleado> lista) {
        double porc = 0, suma = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDepartamento().equals("Ingenieria")) {
                suma++;
            }
        }

        porc = (suma / lista.size()) * 100;

        return porc;
    }

}
