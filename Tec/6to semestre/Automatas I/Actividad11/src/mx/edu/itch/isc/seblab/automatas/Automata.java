package mx.edu.itch.isc.seblab.automatas;

public class Automata {

    private int contador;
    private String cadena;
    private String resultado;

    public Automata(String cadena) {
        this.cadena = cadena;
        this.contador=-1;
        this.resultado="";
    }

    public String estadoIII(){
        resultado += " I I I \n";
        contador++;

        if(contador<cadena.length()){
            if(cadena.charAt(contador)=='A'){
                this.estadoDII();
            }else if(cadena.charAt(contador)=='B'){
                this.estadoIDD();
            }
        }

        return resultado;
    }

    private void estadoIDD() {
        resultado+=" I D D \n";
        contador++;

        if(contador<cadena.length()){
            if(cadena.charAt(contador)=='A'){
                this.estadoDDD();
            }else if(cadena.charAt(contador)=='B'){
                this.estadoIID();
            }
        }
    }

    private void estadoDII() {
        resultado+=" D I I \n";
        contador++;

        if(contador<cadena.length()){
            if(cadena.charAt(contador)=='A'){
                this.estadoIID();
            }else if(cadena.charAt(contador)=='B'){
                this.estadoDDD();
            }
        }
    }

    private void estadoDDD() {
        resultado+=" D D D \n";
        contador++;

        if(contador<cadena.length()){
            if(cadena.charAt(contador)=='A'){
                this.estadoIDI();
            }else if(cadena.charAt(contador)=='B'){
                this.estadoDID();
            }
        }
    }

    private void estadoIID() {
        resultado+=" I I D \n";
        contador++;

        if(contador<cadena.length()){
            if(cadena.charAt(contador)=='A'){
                this.estadoDID();
            }else if(cadena.charAt(contador)=='B'){
                this.estadoIDI();
            }
        }
    }

    private void estadoDID() {
        resultado+=" D I D \n";
        contador++;

        if(contador<cadena.length()){
            if(cadena.charAt(contador)=='A'){
                this.estadoIII();
            }else if(cadena.charAt(contador)=='B'){
                this.estadoDDI();
            }
        }
    }

    private void estadoIDI() {
        resultado+=" I D I \n";
        contador++;

        if(contador<cadena.length()){
            if(cadena.charAt(contador)=='A'){
                this.estadoDDI();
            }else if(cadena.charAt(contador)=='B'){
                this.estadoIII();
            }
        }
    }

    private void estadoDDI() {
        resultado+=" D D I \n";
        contador++;

        if(contador<cadena.length()){
            if(cadena.charAt(contador)=='A'){
                this.estadoIDD();
            }else if(cadena.charAt(contador)=='B'){
                this.estadoDII();
            }
        }
    }
}
