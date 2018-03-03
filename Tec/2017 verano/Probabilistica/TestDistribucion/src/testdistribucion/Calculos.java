package testdistribucion;

import java.util.ArrayList;

public class Calculos {

    ArrayList<Double> lista;
    int numClases, num;
    double menor, mayor,amplitud;

    public Calculos(ArrayList<Double> datos) {
        this.lista = ordenar(datos);
        this.num = lista.size();
        this.menor = lista.get(0);
        this.mayor = lista.get(lista.size() - 1);
        this.numClases = darClases(num);
        this.amplitud = (mayor - menor) / numClases;
    }

    //Ciclo para ordenar los elementos
    public ArrayList<Double> ordenar(ArrayList<Double> lista) {
        double aux;
        for (int i = 0; i < (lista.size() - 1); i++) {
            for (int x = i + 1; x < lista.size(); x++) {
                if (lista.get(x) < lista.get(i)) {
                    aux = lista.get(i);
                    lista.set(i, lista.get(x));
                    lista.set(x, aux);
                }
            }
        }
        return lista;
    }

    public int darClases(int num) {
        int aux = 0, cont = 0;

        while (aux <= num) {
            cont++;
            aux = (int) Math.pow(2, cont);
        }

        return cont;
    }

    private int darFreAbso(double litInf) {
        int fre = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) >= litInf && lista.get(i) <= litInf + amplitud) {
                fre++;
            }
        }

        return fre;
    }

    @Override
    public String toString() {
        String salida = "\n";
        double litInf = menor;
        int acum = 0;
        double acumRel = 0.0, freRel,freAbso,vMedio;

        //Sacar datos en forma de nx5
        for (int i = 0; i < lista.size(); i++) {
            salida += lista.get(i) + " ";
            if ((i + 1) % 5 == 0) {
                salida += "\n";
            }
        }

        salida += "\nClases: " + numClases + "\nAmplitud: " + amplitud + "\nMenor: " + menor + "\nMayor: " + mayor + "\n\n";

        for (int i = 0; i < numClases; i++) {

            freAbso = (double) darFreAbso(litInf);
            freRel = Math.rint((freAbso / num) * 100) / 100;
            acum += freAbso;
            acumRel += freRel;
            vMedio = ((double)litInf + ((double)litInf + (double)amplitud)) / 2;

            salida += "Intervalo : " + litInf + " - " + (litInf + amplitud) + "\n"
                    + "Valor medio: " + vMedio + "\n"
                    + "Frecuencia absoluta: " + freAbso + "\n"
                    + "Frecuencia relativa: " + freRel + "\n"
                    + "Frecuancia absoluta acumulada: " + acum + "\n"
                    + "Frecuencua relativa acumulada: " + acumRel + "\n\n";

            litInf = litInf + amplitud + 1;
        }

        return salida;
    }

}
