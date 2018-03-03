package empresaagroali;

import java.io.Serializable;

public class Producto implements Serializable{

    private String fechaCaducidad, numeroLote,nombre;

    public Producto(String fechaCaducidad, String numeroLote, String nombre) {
        this.fechaCaducidad = fechaCaducidad;
        this.numeroLote = numeroLote;
        this.nombre = nombre;
    }

    public Producto(Producto pro) {
        this.fechaCaducidad = pro.getFechaCaducidad();
        this.numeroLote = pro.getNumeroLote();
        this.nombre = pro.getNombre();
    }

    Producto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+"\nFecha de caducidad: "+fechaCaducidad+"\nN° de lote: "+numeroLote;
    }

}
