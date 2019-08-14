package mx.edu.itch.isc.seblab.automatas;

public class EnteroSigno {
    private int estado;

    public EnteroSigno(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void transicion(String c){
        if(c.matches("[+-]")){
            estado=2;
        }else if(c.matches("\\d")){
            estado=3;
        }
    }
}
