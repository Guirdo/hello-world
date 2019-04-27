package mx.edu.itch.sistemas.seblab.clases;

import javax.swing.*;
import java.util.ArrayList;

public class MetodoCongruencialMixto {

    private double xn,a,c;
    private double m;

    public MetodoCongruencialMixto(double xn, double a, double c, double m){
        this.xn = xn;
        this.a=a;
        this.c=c;
        this.m=m;
    }

    public void generarNumerosAleatorios(int iteraciones, DefaultListModel modelo){
        double xn1;
        modelo.clear();

        for(int i=0;i<iteraciones;i++){
            xn1=(a*xn+c)%m;

            modelo.addElement(xn1/m);

            xn=xn1;
        }
    }

}
