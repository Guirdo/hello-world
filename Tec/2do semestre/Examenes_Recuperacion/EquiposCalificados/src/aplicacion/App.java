package aplicacion;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String nombres[], nombre = "";
        double tiempos[][];
        int numero_Equipos = 0;
        double suma_200m = 0, suma_1500m = 0, tiempo = 0, aux, comparaPromedioGeneral;
        final double min200m = 21, max200m = 42;
        final double min1500m = 5, max1500m = 7;
        String descalificados = "", calificados = "";
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Ingrese el numero de equipos que participaron: ");
            numero_Equipos = sc.nextInt();
            if (numero_Equipos <= 0) {
                System.out.println("Error: el numero de equipos debe ser mayor a cero...");
            }
        } while (numero_Equipos <= 0);

        nombres = new String[numero_Equipos];
        tiempos = new double[numero_Equipos][7];

        //Ciclo que guarda todos los datos y saca los promedios
        for (int i = 0; i < numero_Equipos; i++) {
            
            //Ciclo para comprobar que no introduce una cadena vacia
            do {
                System.out.print("Ingrese el nombre del equipo #" + (i + 1) + ": ");
                nombre = sc.nextLine();
            } while (nombre.isEmpty());
            nombres[i]=nombre;

            //Ciclo para la categoria 200m
            for (int j = 0; j < 2; j++) {
                do {
                    System.out.print("Tiempo del jugador #" + (j + 1) + " en la categoria de 200m: ");
                    tiempo = sc.nextDouble();
                } while (tiempo <= 0);
                suma_200m += tiempo;
                tiempos[i][j] = tiempo;
            }

            //Ciclo para la categoria 1500m
            for (int j = 3; j < 5; j++) {
                do {
                    System.out.print("Tiempo del jugador #" + (j - 2) + " en la categoria de 1500m: ");
                    tiempo = sc.nextDouble();
                } while (tiempo <= 0);
                suma_1500m += tiempo;
                tiempos[i][j] = tiempo;
            }

            //Promedios
            tiempos[i][2] = suma_200m / 2;
            tiempos[i][5] = suma_1500m / 2;

            //Promedio general
            aux = tiempos[i][5] * 60;
            aux += tiempos[i][2];
            tiempos[i][6] = aux / 60;

            //Se limpian los acumuladores
            suma_200m = 0;
            suma_1500m = 0;
        }

        //Ciclo para sacar el mejor promedio general y que todos sus tiempos estan dentro de la categoria amateur
        //Se inicializa en cero, porque primero se checara que sus tiempos esten en regla
        comparaPromedioGeneral = 0;
        for (int i = 0; i < numero_Equipos; i++) {
            if (tiempos[i][2] >= min200m && tiempos[i][2] <= max200m && tiempos[i][5] >= min1500m && tiempos[i][5] <= max1500m) {

                //If, que ya checados los tiempos en regla, asignara el promedio general del primer equipo que haya cumplido con
                //las condiciones del if de arriba
                if (comparaPromedioGeneral == 0) {
                    comparaPromedioGeneral = tiempos[i][6];
                }

                //If que va sacando el mejor tiempo
                if (tiempos[i][6] <= comparaPromedioGeneral) {
                    comparaPromedioGeneral = tiempos[i][6];
                }

            } else {//Aca se enlistan a los equipos que se han salido de los tiempos promedios de la categoria amateur
                descalificados += nombres[i] + "\n";
            }
        }

        //Ciclo que busca a al/los equipos con el mejor promedio general
        for (int i = 0; i < numero_Equipos; i++) {
            if (comparaPromedioGeneral == tiempos[i][6]) {
                calificados += nombres[i] + "\n";
            }
        }

        if (!descalificados.isEmpty()) {//Checa que la lista de descalificados, tenga por lo menos un equipo
            System.out.println("\nLos equipos descalificados son: \n" + descalificados);
        }
        if (!calificados.isEmpty()) {//Checa que la lista de calificados, tenga por lo menos un equipo
            System.out.println("Los equipos calificados son: \n" + calificados);
        }

        System.exit(0);
    }
}
