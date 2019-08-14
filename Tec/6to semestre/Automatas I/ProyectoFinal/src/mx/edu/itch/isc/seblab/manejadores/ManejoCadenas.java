package mx.edu.itch.isc.seblab.manejadores;

import mx.edu.itch.isc.seblab.automatas.AutomataNumeroReal;
import mx.edu.itch.isc.seblab.automatas.AutomataVariable;

public class ManejoCadenas {

    public boolean esPalabraIF(String token){
        return token.equalsIgnoreCase("if");
    }

    public boolean esEspacio(String token){
        return token.equals(" ");
    }

    public boolean esParentesisApertura(String token){
        return token.equals("(");
    }

    public boolean esParentesisCierre(String token){
        return token.equals(")");
    }

    public boolean esPalabraTHEN(String token){
        return token.equalsIgnoreCase("then");
    }

    public boolean esSignoIgual(String token){
        return token.equals("=");
    }

    public boolean esOperadorLogico(String token){
        return token.equals("==") || token.equals(">") || token.equals("<") || token.equals(">=")
                || token.equals("<=") || token.equals("!=");
    }

    public boolean esFinalCadena(String token){
        return token.equals("\r") || token.equals("\n");
    }

    public boolean esLetra(char c){
        return Character.isAlphabetic(c);
    }

    public boolean esDigito(char c){
        return Character.isDigit(c);
    }

    public boolean esVariable(String token) {
        AutomataVariable variable = new AutomataVariable(1,3);
        int indice = 0;

        while(variable.getEstado()!= 2){
            try{
                variable.transicion(token.charAt(indice++));
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }

        if(variable.esEstadoFinal(variable.getEstado())){
            return true;
        }else{
            return false;
        }


    }

    public boolean esSigno(char c){
        return c == '+' || c == '-';
    }

    public boolean esPunto(char c){
        return c == '.';
    }

    public boolean esExponencial(char c){
        return c == 'e' || c == 'E';
    }

    public boolean esNumeroReal(String token) {
        AutomataNumeroReal numeroReal = new AutomataNumeroReal(2,4,7);
        int indice = 0;
        int estado = 0;
        int entrada;
        char caracterActual;

        do {
            try{
                caracterActual = token.charAt(indice++);
                if(esSigno(caracterActual)){
                    entrada = 0;
                }else if(esDigito(caracterActual)){
                    entrada=1;
                }else if(esPunto(caracterActual)){
                    entrada=2;
                }else if(esExponencial(caracterActual)){
                    entrada = 3;
                }else if(esFinalCadena(caracterActual+"")){
                    entrada=4;
                }else{
                    entrada=-1;
                }
            }catch (StringIndexOutOfBoundsException ex){
                entrada = 4;
            }

            int nuevoEstado = entrada!=-1 ? numeroReal.getEstado(estado,entrada) : -1;

            if(nuevoEstado == -1){
                break;
            }else{
                estado = nuevoEstado;
            }

        }while (!numeroReal.esEstadoFinal(estado));

        return numeroReal.esEstadoFinal(estado);
    }
}
