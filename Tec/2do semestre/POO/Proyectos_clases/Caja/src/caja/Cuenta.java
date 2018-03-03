package caja;

import java.util.ArrayList;

public class Cuenta {

    private final int numCuenta;
    private final String tipoCuenta, fecAper;
    private double sueldo;
    private ArrayList<ListMovimientos> lista;

    public Cuenta(int numCuenta, String tipoCuenta, String fecAper) {
        this.numCuenta = numCuenta;
        this.tipoCuenta = tipoCuenta;
        this.fecAper = fecAper;
        lista = new ArrayList <>();
        sueldo = 0.0;
    }

    public Cuenta(Cuenta cuenta) {
        numCuenta = cuenta.getNumCuenta();
        tipoCuenta = cuenta.getTipoCuenta();
        fecAper = cuenta.getFecAper();
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public String getFecAper() {
        return fecAper;
    }

    public double getSueldo() {
        return sueldo;
    }

    @Override
    public String toString() {
        return "\nNo. de cuenta: " + numCuenta + "\tTipo de cuenta: " + tipoCuenta + "\nFecha de apertura: " + fecAper + "\n\t-Sueldo: $" + sueldo + "\n\n";
    }

}
