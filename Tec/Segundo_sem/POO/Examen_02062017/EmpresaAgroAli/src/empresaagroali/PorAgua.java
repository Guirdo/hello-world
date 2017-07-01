package empresaagroali;

import java.io.Serializable;

public class PorAgua extends Congelado implements Serializable{
    private double salinidad;

    public PorAgua(double salinidad, String fechaEnvasado, String paisOrigen, double temperatura, String fechaCaducidad, String numeroLote, String nombre) {
        super(fechaEnvasado, paisOrigen, temperatura, fechaCaducidad, numeroLote, nombre);
        this.salinidad = salinidad;
    }

    

    public double getSalinidad() {
        return salinidad;
    }

    public void setSalinidad(double salinidad) {
        this.salinidad = salinidad;
    }

    @Override
    public String toString() {
        return super.toString()+"\nSalinidad del agua: "+salinidad+"gramos/litro\n";
    }
    
    
}
