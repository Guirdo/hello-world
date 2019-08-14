package mx.edu.itch.isc.seblab.automatas;

public class AutomataNumeroReal {

    private int [][] tablaTransiciones = {
            {1,2,-1,-1,-1},
            {-1,2,-1,-1,2},
            {-1,2,3,-1,-1},
            {-1,4,-1,-1,-1},
            {-1,4,-1,5,4},
            {6,7,-1,-1,-1},
            {-1,7,-1,-1,-1},
            {-1,7,-1,-1,7}
    };

    private String[] catalogoErrores = {

    };

    private int[] estadosFinales;

    public AutomataNumeroReal(int... estadosFinales) {
        this.estadosFinales = estadosFinales;
    }

    public int getEstado(int estadoActual,int entrada){
        return tablaTransiciones[estadoActual][entrada];
    }

    public String getMensajeError(int estadoActual){
        return catalogoErrores[estadoActual];
    }

    public boolean esEstadoFinal(int estadoActual){
        for(int estado: estadosFinales){
            if(estado==estadoActual){
                return true;
            }
        }

        return false;
    }
}
