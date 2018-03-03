
package caja;

public class Movimiento {
    private final String fecMov,tipoMov;
    private final double cantidad;

    public Movimiento(String fecMov, String tipoMov, double cantidad) {
        this.fecMov = fecMov;
        this.tipoMov = tipoMov;
        this.cantidad = cantidad;
    }
    
    public Movimiento(Movimiento mov){
       this(mov.getFecMov(), mov.getTipoMov(), mov.getCantidad()); 
    }

    public String getFecMov() {
        return fecMov;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public double getCantidad() {
        return cantidad;
    }
    
    @Override
    public String toString(){
        return "\nFecha: "+fecMov+"\nTipo: "+tipoMov+"\nCantidad: "+cantidad+"\n\n";
    }
    
    
}
