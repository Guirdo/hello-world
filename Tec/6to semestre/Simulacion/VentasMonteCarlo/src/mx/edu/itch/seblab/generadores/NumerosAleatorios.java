package mx.edu.itch.seblab.generadores;

public class NumerosAleatorios {

    private double xn,a,c;
    private double m;
    private int iteraciones;
    private double[] array;

    public NumerosAleatorios(double xn, double a, double c, double m,int iteraciones){
        this.xn = xn;
        this.a=a;
        this.c=c;
        this.m=m;

        this.iteraciones=iteraciones;
        this.generar();
    }

    private void generar(){
        this.array = new double[this.iteraciones];
        double xn1;

        for(int i=0;i<iteraciones;i++){
            xn1=(a*xn+c)%m;
            array[i]=xn1/m;
            xn=xn1;
        }
    }

    public double[] getArray() {
        return array;
    }
}
