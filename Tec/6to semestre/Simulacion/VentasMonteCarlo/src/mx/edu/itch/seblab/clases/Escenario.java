package mx.edu.itch.seblab.clases;

import mx.edu.itch.seblab.generadores.NumerosAleatorios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Escenario {

    private Negocio negocio;
    private double maximoBeneficio;
    private double minimoBeneficio;
    private double mediaMuestral;
    private ArrayList<Double> ventas;


    public Escenario(Negocio negocio) {
        this.negocio=negocio;
        this.maximoBeneficio = 0;
        this.minimoBeneficio=0;
    }

    public double[][] darTablaEscenario(){
        int filas = negocio.getPeriodo();
        double sumatoriaMuestral=0;
        Random rn = new Random();
        double[][] limites = negocio.getLimites();
        double[][] tabla = new double[filas][5];
        this.ventas = new ArrayList<>();

        double[] pseudos = new NumerosAleatorios(31+rn.nextInt(23),57+rn.nextInt(29),
                29+rn.nextInt(23),107+rn.nextInt(31),filas).getArray();


        double ganancia = negocio.getPrecioVentaUnidad()-negocio.getCostoProduccionUnidad();

        for(int i=0;i<filas;i++){
            //Dia
            tabla[i][0] = i+1;
            //Numero pseudoaleatorio
            tabla[i][1] = pseudos[i];
            //Ventas
            tabla[i][2] = this.darVentas(pseudos[i],limites);
            ventas.add(tabla[i][2]);
            sumatoriaMuestral+=tabla[i][2];
            //Ganancia por producto diario
            tabla[i][3] = ganancia*tabla[i][2];
            //Ganancia neta
            tabla[i][4] = tabla[i][3]-negocio.getGastoProDiario();

            if(i==0){
                minimoBeneficio = tabla[i][4];
                maximoBeneficio= tabla[i][4];
            }else{
                if(tabla[i][4]<minimoBeneficio){
                    minimoBeneficio=tabla[i][4];
                }

                if(maximoBeneficio<=tabla[i][4]){
                    maximoBeneficio=tabla[i][4];
                }
            }
        }

        mediaMuestral= sumatoriaMuestral/(double)filas;

        return tabla;
    }

    public double getModa(){
        this.ordenarArray();
        double aux = ventas.get(0);
        int cont = 1;
        int contMax = 0;
        int pos = 0;

        for (int i=1;i<ventas.size();i++){
            if(aux == ventas.get(i)){
                cont++;
            }else{
                aux=ventas.get(i);
                if(cont>contMax){
                    contMax=cont;
                    pos=i-1;
                }else if(cont==contMax){
                    pos=-1;
                }
                cont=1;
            }
        }

        return pos<0 ? 0: ventas.get(pos);
    }

    private double darVentas(double p, double[][] limites) {
        double venta=0;
        for(double[] lim : limites){
            if(lim[1]<= p && p<lim[2]){
                venta = lim[0];
            }
        }

        return venta;
    }

    public double getMaximoBeneficio() {
        return maximoBeneficio;
    }

    public double getMinimoBeneficio() {
        return minimoBeneficio;
    }

    public double getMediaMuestral() {
        return mediaMuestral;
    }

    private void ordenarArray(){
        for (int x = 0; x < ventas.size(); x++) {
            for (int i = 0; i < ventas.size()-x-1; i++) {
                if(ventas.get(i) < ventas.get(i+1)){
                    double tmp = ventas.get(i+1);
                    ventas.set(i+1,ventas.get(i));
                    ventas.set(i,tmp);
                }
            }
        }
    }
}
