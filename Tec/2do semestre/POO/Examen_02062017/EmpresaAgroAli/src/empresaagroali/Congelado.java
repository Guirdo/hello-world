package empresaagroali;

import java.io.Serializable;

public class Congelado extends Producto implements Serializable {
    private String fechaEnvasado,paisOrigen;
    private double temperatura;

    public Congelado(String fechaEnvasado, String paisOrigen, double temperatura, String fechaCaducidad, String numeroLote, String nombre) {
        super(fechaCaducidad, numeroLote, nombre);
        this.fechaEnvasado = fechaEnvasado;
        this.paisOrigen = paisOrigen;
        this.temperatura = temperatura;
    }

    
    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(String fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return super.toString()+"\nFecha envasado: "+fechaEnvasado+"\nTemperatura recomendada: "+temperatura;
    }
    
    
}
