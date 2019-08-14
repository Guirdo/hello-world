package mx.edu.itch.isc.seblab.automatas;

public class Nodo {

    private int estado;

    public Nodo(int estadoInicial) {
        this.estado = estadoInicial;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void transicion(char c){
        if(c=='A'){
            switch (estado){
                case 0:
                    estado=4;
                    break;
                case 1:
                    estado=5;
                    break;
                case 2:
                    estado=6;
                    break;
                case 3:
                    estado=7;
                    break;
                case 4:
                    estado=1;
                    break;
                case 5:
                    estado=0;
                    break;
                case 6:
                    estado=3;
                    break;
                case 7:
                    estado=2;
                    break;
            }
        }else{
            switch (estado){
                case 0:
                    estado=3;
                    break;
                case 1:
                    estado=2;
                    break;
                case 2:
                    estado=0;
                    break;
                case 3:
                    estado=1;
                    break;
                case 4:
                    estado=7;
                    break;
                case 5:
                    estado=6;
                    break;
                case 6:
                    estado=4;
                    break;
                case 7:
                    estado=5;
                    break;
            }
        }
    }
}
