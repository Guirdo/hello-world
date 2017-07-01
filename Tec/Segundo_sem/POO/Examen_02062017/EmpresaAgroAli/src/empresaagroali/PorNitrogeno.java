package empresaagroali;

import java.io.Serializable;

public class PorNitrogeno extends Congelado implements Serializable{
    private String metodoCongelacion;
    private int segundos;

    public PorNitrogeno(String metodoCongelacion, int segundos, String fechaEnvasado, String paisOrigen, double temperatura, String fechaCaducidad, String numeroLote, String nombre) {
        super(fechaEnvasado, paisOrigen, temperatura, fechaCaducidad, numeroLote, nombre);
        this.metodoCongelacion = metodoCongelacion;
        this.segundos = segundos;
    }
    
    

    public String getMetodoCongelacion() {
        return metodoCongelacion;
    }

    public void setMetodoCongelacion(String metodoCongelacion) {
        this.metodoCongelacion = metodoCongelacion;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public String toString() {
        return super.toString()+"\nMetodo de congelacion empleado: "+metodoCongelacion+"\nTiempo de exposicion al nitrogeno: "+segundos+" segundos\n";
    }
    
    
}
