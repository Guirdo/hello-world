package caja;

public class Cancelacion {

    private final String nombre, fecCan;
    private final int numCuen;

    public Cancelacion(String nombre, String fecCan, int numCuen) {
        this.nombre = nombre;
        this.fecCan = fecCan;
        this.numCuen = numCuen;
    }

    public Cancelacion(Cancelacion can) {
        this(can.getNombre(), can.getFecCan(), can.getNumCuen());
    }
    
    public void realizarCancelacion(Cancelacion can){
        ListaCuentas lista = new ListaCuentas();
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecCan() {
        return fecCan;
    }

    public int getNumCuen() {
        return numCuen;
    }

}
