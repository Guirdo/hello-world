package empresaagroali;

import java.io.Serializable;

public class Fresco extends Producto implements Serializable{
    private String fechEnvasado,paisOrigen;

    public Fresco(String fechEnvasado, String paisOrigen, String fechaCaducidad, String numeroLote, String nombre) {
        super(fechaCaducidad, numeroLote, nombre);
        this.fechEnvasado = fechEnvasado;
        this.paisOrigen = paisOrigen;
    }

    public Fresco(Fresco f) {
        super(f.getFechaCaducidad(),f.getNumeroLote(),f.getNombre());
        
        this.fechEnvasado = f.getFechEnvasado();
        this.paisOrigen=f.getPaisOrigen(); 
    }
    
    public String getFechEnvasado() {
        return fechEnvasado;
    }

    public void setFechEnvasado(String fechEnvasado) {
        this.fechEnvasado = fechEnvasado;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String toString() {
        return super.toString()+"\nFecha de envasado: "+fechEnvasado+"\nPais de origen: "+paisOrigen;
    }
    
    
}
