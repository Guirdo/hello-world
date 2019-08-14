package mx.edu.itch.isc.seblab.automatas;

import mx.edu.itch.isc.seblab.manejadores.ManejoCadenas;

public class AutomataVariable {

    private int estado;
    private int[] estadosFinales;

    public AutomataVariable(int estado, int... estadosFinales) {
        this.estado = estado;
        this.estadosFinales = estadosFinales;
    }

    public void transicion(char simbolo){
        ManejoCadenas manejoCadenas = new ManejoCadenas();
        switch (estado){
            case 1:
                if(manejoCadenas.esLetra(simbolo)){
                    estado=3;
                }else{
                    estado = 2;
                }
                break;
            case 2:
                estado=-1;
                break;
            case 3:
                if(manejoCadenas.esLetra(simbolo)){
                    estado=3;
                }else if(manejoCadenas.esDigito(simbolo)){
                    estado=3;
                }else{
                    estado=-1;
                }
                break;
        }
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean esEstadoFinal(int estadoActual){
        for(int estado : estadosFinales){
            if(estado == estadoActual){
                return true;
            }
        }

        return false;
    }
}
