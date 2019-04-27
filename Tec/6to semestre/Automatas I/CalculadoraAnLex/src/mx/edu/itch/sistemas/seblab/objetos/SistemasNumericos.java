package mx.edu.itch.sistemas.seblab.objetos;

import mx.edu.itch.sistemas.seblab.excepciones.FormatoEquivocadoException;

import java.util.Stack;

public class SistemasNumericos {

    private String numeroConvertido;
    private Stack<String> pila;

    public double convertirADecimal(String numero,String sistema)throws FormatoEquivocadoException {
        double resultado=0;

        String[] array = numero.split("[.]");

        resultado= convertirEntero(array[0],sistema);

        if(array.length>1){
            resultado+=convertirFlotante(array[1],sistema);
        }

        return resultado;
    }

    private double convertirEntero(String numero,String sistema) throws FormatoEquivocadoException {
        double resultado=0;
        double num;
        int cont=0;
        int sis = darSistema(sistema);
        for(int i=numero.length()-1; i >= 0;i--){
            char c=numero.charAt(i);
            if(Character.isDigit(c)){
                num= Double.parseDouble(numero.charAt(i)+"");
            }else if(Character.isAlphabetic(c) && sis > 10){
                num = darEquivalente(c);
            }else{
                throw new FormatoEquivocadoException("¡Numero mal ingresado!");
            }

            resultado+=Math.pow(sis,cont)*num;
            cont++;
        }
        return resultado;
    }

    private double convertirFlotante(String numero, String sistema) throws FormatoEquivocadoException {
        double resultado=0;
        double num;
        int cont=1;
        int sis = darSistema(sistema);

        for(int i=0;i<numero.length();i++){
            char c = numero.charAt(i);

            if(Character.isDigit(c)){
                num = Double.parseDouble(c+"");
            }else if(Character.isAlphabetic(c) &&  sis > 10){
                num = darEquivalente(c);
            }else{
                throw new FormatoEquivocadoException("¡Numero mal ingresado!");
            }

            resultado+=num/Math.pow(sis,cont);
            cont++;
        }

        return resultado;
    }

    private double darEquivalente(char c){
        return 10 -Character.compare('A',Character.toUpperCase(c));
    }

    private int darSistema(String s){
        s=s.toUpperCase();
        switch (s){
            case "B": return 2;
            case "O": return 8;
            case "X": return 16;
            case "D": return 10;
            default:return-1;
        }
    }

    /**
     * Metodo que convierte un numero en sistema decimal a cualquier
     * otro, incluyendo o no el punto flotante.
     * @param numero Numero a convertir
     * @param sis Sistema al que se quiere convertir
     * @param precision Numeros después del punto
     * @return Numero convertido al sistema seleccionado
     */
    public String convertirASistema(double numero, String sis, int precision){
        int entero=(int) Math.floor(numero);
        int sistema=darSistema(sis);
        numeroConvertido ="";
        pila=new Stack<>();

        if(entero>0){
            convertirEntero(entero,sistema);
        }else{
            numeroConvertido+="0";
        }

        while(!pila.empty()){
            numeroConvertido +=pila.pop();
        }

        if(precision>0){
            numeroConvertido +=".";
            double numFlotante = numero-entero;
            convertirFlotante(numFlotante,sistema,precision);
        }

        return numeroConvertido;
    }

    private void convertirEntero(int numero, int sistema){
        if(numero!=0){
            int residuo=numero%sistema;
            if(sistema<10 || residuo<10){
                pila.push(""+residuo);
            }else{
                pila.push(""+darEquivalente(numero%sistema));
            }
            convertirEntero(numero/sistema,sistema);
        }
    }

    private void convertirFlotante(double flot, int sistema, int presicion){
        if(presicion>0){
            flot*=sistema;
            int entero=(int) Math.floor(flot);
            if(sistema<10 || entero<10){
                numeroConvertido +=entero;
            }else{
                numeroConvertido+= darEquivalente(entero);
            }

            convertirFlotante(flot-entero,sistema,presicion-1);
        }
    }

    private char darEquivalente(int num){
        return (char) (65+(num - 10));
    }

}
