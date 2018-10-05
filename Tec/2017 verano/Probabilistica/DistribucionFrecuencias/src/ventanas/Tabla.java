package ventanas;

import java.io.Serializable;
import java.util.ArrayList;

public class Tabla implements Serializable {

    private static ArrayList<Integer> lista;
    private static int numClases, n;
    private static int amplitud, menor, mayor;
    private static double media, varianza, desMed, desEst, claseMed, mediana,moda;
    private static Object[][] tab;

    public Tabla() {
        lista = null;
        numClases = 0;
        n = 0;
        amplitud = 0;
        menor = 0;
        mayor = 0;
        media = 0;
        varianza = 0;
        desMed = 0;
        desEst = 0;
        claseMed = 0;
        mediana = 0;
        moda=0;
        tab = null;
    }

    public Tabla(ArrayList<Integer> lista) {
        this.lista = ordenar(lista);
        this.n = this.lista.size();
        this.menor = this.lista.get(0);
        this.mayor = this.lista.get(lista.size() - 1);
        this.numClases = darClases(n);
        this.amplitud = (mayor - menor) / numClases;
        this.claseMed = (double) n / 2.0;
        this.media = darMediaAritmetica();
        this.mediana = darMediana();
        this.varianza = darVarianza();
        this.desMed = darDesMed();
        this.desEst = Math.rint(Math.sqrt(this.varianza) * 100) / 100;
        this.tab = crearTabla();
        this.moda=darModa();
    }

    public double darMediana() {
        double resultado, freAcumAn = 0.0, freMed;
        int litInf = menor;

        //Ciclo que da la frecuencia de la clase anterior inmediata a la clase mediana
        do{
            freAcumAn = darFreAbso(litInf);
            
            litInf+=amplitud+1;
        }while((freAcumAn+darFreAbso(litInf))<claseMed);
        System.out.println(litInf);

        //Da la fecuencia de la clase mediana
        freMed = darFreAbso(litInf);

        resultado = litInf + ((((n/2) - freAcumAn) / freMed) * amplitud);
        resultado = Math.rint(resultado*100)/100;

        return resultado;
    }

    public double darModa() {
        double resultado, freAn = 0, freSi = 0;
        int litInf = menor, pos = 0;
        double l = 0;
        double[] fres = new double[numClases];
        double freMay = darFreAbso(litInf);

        //Ciclo que da la frecuencia absoluta mas alta
        for (int i = 0; i < numClases; i++) {
            if (darFreAbso(litInf) > freMay) {
                freMay = darFreAbso(litInf);
                pos = i;
                l = litInf;
            }
            fres[i] = darFreAbso(litInf);
            litInf += amplitud + 1;
        }

        //If que asegura que exista una clase anterior
        if (pos-1 != -1) {
            freAn = fres[pos - 1];
        }

        if (!(pos + 1 > fres.length - 1)) {
            freSi = fres[pos + 1];
        }

        double d1 = freMay - freAn;
        double d2 = freMay - freSi;

        resultado = l + ((d1 / (d1 + d2)) * amplitud);
        resultado = Math.rint(resultado*100)/100;

        return resultado;
    }

    public int[] darArreglo() {
        int[] arreglo = new int[lista.size()];

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = lista.get(i);
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
        resultado = Math.rint(resultado*100)/100;

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
            vMedio = Math.rint(vMedio * 100) / 100;
            suma += darFreAbso(litInf) * Math.pow(vMedio, 2);

            litInf = litInf + amplitud + 1;
        }

        resultado = (suma / n) - Math.pow(media, 2);
        resultado = Math.rint(resultado*100)/100;

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
                    "Clases", "Valor medio", "Frecuencia abso", "Frecuencia relativa", "F.A. acumulada", "F.R. acumulada"
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
    
    public String darOrdenados() {
        String salida = "";

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
        salida += "-Numero de elementos: " + n + "\n-Limite inferior: " + menor + "\n-Limite superior: " + mayor + "\n\n";

        salida += "Datos agrupados\n------------------------";
        salida += "\n-Clases: " + numClases + "\n-Amplitud de las clases: " + amplitud+"\n\n";
        
        salida += "Medidas de tendencia central";
        salida += "\n-Media aritmetica: " + media+"\n-Mediana: "+mediana+"\n-Moda: "+moda+"\n\n";
        
        salida += "Medidas de disperción";
        salida += "\n-Desviación media: " + desMed;
        salida += "\n-Varianza: " + varianza;
        salida += "\n-Desviación estandar: " + desEst;

        return salida;
    }

}
