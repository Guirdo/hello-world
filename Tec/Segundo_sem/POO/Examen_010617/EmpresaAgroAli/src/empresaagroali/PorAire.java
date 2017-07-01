package empresaagroali;

import java.io.Serializable;

public class PorAire extends Congelado implements Serializable{
    private double nitrogeno,oxigeno,diOxicarbono;

    public PorAire(double nitrogeno, double oxigeno, double diOxicarbono, String fechaEnvasado, String paisOrigen, double temperatura, String fechaCaducidad, String numeroLote, String nombre) {
        super(fechaEnvasado, paisOrigen, temperatura, fechaCaducidad, numeroLote, nombre);
        this.nitrogeno = nitrogeno;
        this.oxigeno = oxigeno;
        this.diOxicarbono = diOxicarbono;
    }

    

    public double getNitrogeno() {
        return nitrogeno;
    }

    public void setNitrogeno(double nitrogeno) {
        this.nitrogeno = nitrogeno;
    }

    public double getOxigeno() {
        return oxigeno;
    }

    public void setOxigeno(double oxigeno) {
        this.oxigeno = oxigeno;
    }

    public double getDiOxicarbono() {
        return diOxicarbono;
    }

    public void setDiOxicarbono(double diOxicarbono) {
        this.diOxicarbono = diOxicarbono;
    }

    @Override
    public String toString() {
        return super.toString()+"\nNitrogeno: "+nitrogeno+"%\nOxigeno: "+oxigeno+"%\nDioxido de carbono: "+diOxicarbono+"%\n";
    }
    
    
}
