package mx.edu.itch.isc.seblab.automatas;

public class AutomataSentencia {

    private int [][] tablaTransiciones = {
            {1,0,-1,-1,-1,-1,-1,-1,-1,-1},//
            {-1,1,2,-1,-1,-1,-1,-1,-1,-1},
            {-1,2,-1,3,-1,3,-1,-1,-1,-1},
            {-1,3,-1,-1,4,-1,-1,-1,-1,-1},//
            {-1,4,-1,5,-1,5,-1,-1,-1,-1},
            {-1,5,-1,-1,-1,-1,6,-1,-1,-1},
            {-1,6,-1,-1,-1,-1,-1,7,-1,-1},
            {-1,8,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,8,-1,9,-1,-1,-1,-1,-1,-1},
            {-1,9,-1,-1,-1,-1,-1,-1,10,-1},
            {-1,10,-1,11,-1,11,-1,-1,-1,-1},
            {-1,11,-1,-1,-1,-1,-1,-1,-1,12}
    };

    private int [] estadosFinales;

    private String[] catalogoErrores={
            "1. Una sentencia debe empezar con la palabra clave if.",
            "1. Una sentencia debe empezar con la palabra clave if.",
            "2. Hace falta un parentesis de apertura.",
            "3. Incorrecta forma de nombrar variable.",
            "4. Hace falta operar lógico.",
            "5. Hace falta numero o variable",
            "6. Hace falta paréntesis de cierre.",
            "7. Hace falta la palabra clave then.",
            "8. Incorrecta forma de nombrar variable.",
            "8. Incorrecta forma de nombrar variable.",
            "9. Hace falta signo de asignacion.",
            "10. Hace falta numero o varibale"
    };

    public AutomataSentencia(int... estadosFinalesIniciales) {
        this.estadosFinales = estadosFinalesIniciales;
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
