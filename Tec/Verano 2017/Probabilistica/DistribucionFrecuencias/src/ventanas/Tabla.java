package ventanas;

import java.io.Serializable;
import java.util.ArrayList;

public class Tabla implements Serializable{

    private static ArrayList<Integer> lista;
    private static int numClases, n;
    private static int amplitud, menor, mayor;
    private static double media, varianza, desMed, desEst;
    private static ArrayList<Integer> lista1;

    public Tabla() {
        lista = null;
        lista1=null;
        numClases = 0;
        n = 0;
        amplitud = 0;
        menor = 0;
        mayor = 0;
        media = 0;
        varianza = 0;
        desMed = 0;
        desEst = 0;
    }

    public Tabla(ArrayList<Integer> lista) {
        this.lista = ordenar(lista);
        this.n = this.lista.size();
        this.menor = this.lista.get(0);
        this.mayor = this.lista.get(lista.size() - 1);
        this.numClases = darClases(n);
        this.amplitud = (mayor - menor) / numClases;
        this.media = darMediaAritmetica();
        this.varianza = darVarianza();
        this.desMed = darDesMed();
        this.desEst = Math.rint(Math.sqrt(this.varianza)*100)/100;
        this.lista1=this.lista;
    }

    public int[] darArreglo(){
        int [] arreglo = new int[lista.size()];
        
        for(int i=0;i<arreglo.length;i++){
            arreglo[i]=lista.get(i);
        }
        
        return arreglo;
    }

    public double darDesMed() {
        double suma = 0.0, vMedio, resultado;
        int litInf = menor;

        for (int i = 0; i < numClases; i++) {
            vMedio = ((double) litInf + ((double) litInf + (double) amplitud)) / 2;
            suma += darFreAbso(litInf) * Math.abs(vMedio - media);

            litInf = litInf + amplitud + 1;
        }
        resultado = suma / n;

        return resultado;
    }

    public double darMediaAritmetica() {
        double suma = 0, media;
        double vMedio = 0.0;
        double freAbso;
        int litInf = menor;

        for (int i = 0; i < numClases; i++) {
            vMedio = ((double) litInf + ((double) litInf + (double) amplitud)) / 2;
            freAbso = (double) darFreAbso(litInf);

            suma += vMedio * freAbso;

            litInf = litInf + amplitud + 1;
        }

        media = suma / n;

        return media;
    }

    public double darVarianza() {
        double resultado;
        double vMedio, suma = 0;
        int litInf = menor;

        for (int i = 0; i < numClases; i++) {
            vMedio = ((double) litInf + ((double) litInf + (double) amplitud)) / 2.0;
            vMedio = Math.rint(vMedio*100)/100;
            suma += darFreAbso(litInf) * Math.pow(vMedio, 2);

            litInf = litInf + amplitud + 1;
        }

        resultado = (suma / n) - Math.pow(media, 2);

        return resultado;
    }

    //Ciclo para ordenar los elementos
    public ArrayList<Integer> ordenar(ArrayList<Integer> lista) {
        int aux;
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

    private int darFreAbso(int litInf) {
        int fre = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) >= litInf && lista.get(i) <= litInf + amplitud) {
                fre++;
            }
        }

        return fre;
    }

    public Object[][] crearTabla() {
        Object[][] salida = new Object[numClases][6];
        int litInf = menor;
        int acum = 0;
        double acumRel = 0.0, freRel, freAbso, vMedio;
        String intervalo = "";

        for (int i = 0; i < numClases; i++) {
            freAbso = (double) darFreAbso(litInf);
            freRel = Math.rint((freAbso / n) * 100) / 100;
            acum += freAbso;
            acumRel += freRel;
            vMedio = ((double) litInf + ((double) litInf + (double) amplitud)) / 2;
            intervalo = litInf + " - " + (litInf + amplitud);

            salida[i][0] = intervalo;
            salida[i][1] = vMedio;
            salida[i][2] = freAbso;
            salida[i][3] = freRel;
            salida[i][4] = acum;
            salida[i][5] = acumRel;

            litInf = litInf + amplitud + 1;
        }

        return salida;
    }

    public javax.swing.table.DefaultTableModel darTabla() {

        javax.swing.table.DefaultTableModel tab = new javax.swing.table.DefaultTableModel(
                crearTabla(),
                new String[]{
                    "Clases", "Valor medio", "Frecuencia absoluta", "Frecuencia relativa", "F.A. acumulada", "F.R. acumulada"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        return tab;
    }

    public String imprimir() {
        String salida = "";

        for (int i = 0; i < lista.size(); i++) {
            salida += lista.get(i) + " ";
            if ((i + 1) % 5 == 0) {
                salida += "\n";
            }
        }

        return salida;
    }

    public String informacion() {
        String salida = "";

        salida += "General\n------------------------\n";
        salida += "Numero de elementos: " + n + "\nLimite inferior: " + menor + "\nLimite superior: " + mayor + "\n\n";

        salida += "Datoa agrupados\n------------------------";
        salida += "\nClases: " + numClases + "\nAmplitud de las clases: " + amplitud;
        salida += "\nMedia aritmetica: " + media;
        salida += "\nDesviación media: " + desMed;
        salida += "\nVarianza: " + varianza;
        salida += "\nDesviación estandar: " + desEst;

        return salida;
    }

}
