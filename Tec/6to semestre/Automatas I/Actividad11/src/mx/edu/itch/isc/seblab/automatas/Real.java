package mx.edu.itch.isc.seblab.automatas;

public class Real {

    private int estado;

    public Real(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void transicion(String c){
        if(c.matches("[+-]") && estado==1){
            estado=2;
        }else if(c.matches("\\d")&& estado==2){
            estado=3;
        }else if(c.matches("\\d")&& estado==3){
            estado=3;
        }else if(c.matches("[.]") && estado==3){
            estado=4;
        }else if(c.matches("\\d")&& (estado==4 || estado==5)){
            estado=5;
        }
    }
}
