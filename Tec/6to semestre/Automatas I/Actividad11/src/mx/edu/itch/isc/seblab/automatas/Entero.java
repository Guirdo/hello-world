package mx.edu.itch.isc.seblab.automatas;

public class Entero {

    private int estado;

    public Entero(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void transicion(String c){
        if(c.matches("\\d")){
            estado=2;
        }
    }
}
