package mx.edu.itch.sistemas.seblab.objetos;

import mx.edu.itch.sistemas.seblab.excepciones.FormatoEquivocadoException;
import mx.edu.itch.sistemas.seblab.excepciones.ParentesisException;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertidorInfijaPolaca {
    private ArrayList<String> operacion;
    private ArrayList<String> numeros;
    private ArrayList<String> prefija;
    private Stack<String> pila;
    private Pattern pattern;
    private String cadena;
    private final String PATRON = "([01]+([.][01]+)?[B]|[0-9]+([.][0-9]+)?[D]" +
            "|[0-7]+([.][0-7]+)?[O]|[0-9A-F]+([.][0-9A-F]+)?[X]|[eE][rR])";

    public ConvertidorInfijaPolaca(String cadena) throws FormatoEquivocadoException {
        if(!cadena.matches(".[;:]")){
            this.cadena=cadena;
            String patronNum= "([01]+([.][01]+)?[B]|[0-9]+([.][0-9]+)?" +
                    "|[0-7]+([.][0-7]+)?[O]|[0-9A-F]+([.][0-9A-F]+)?[X]|[eE][rR])";
            this.operacion = tokenizar(cadena,"(?<token>[\\(]|"+patronNum+"|[-+*/^%u]|[\\)])");
            this.numeros= new ArrayList<>();
            this.pila = new Stack<>();
            this.pattern = Pattern.compile(PATRON, Pattern.CASE_INSENSITIVE);
            this.prefija=new ArrayList<>();
        }else{
            throw new FormatoEquivocadoException("Formato de operación erroneo.");
        }
    }

    private ArrayList<String> tokenizar(String cadena, String patron){
        ArrayList<String> array = new ArrayList<>();
        Pattern pattern = Pattern.compile(patron,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cadena);

        while (matcher.find()){
            String tok = matcher.group("token");
            if(tok.matches("\\d+([.]\\d+)?")){
                tok+="d";
            }
            array.add(tok);
        }

        return array;
    }

    public ArrayList<String> darPrefija() throws ParentesisException {
        ArrayList<String> resultado = new ArrayList<>();
        Matcher matcher;
        String token;
        int cont=0;

        for (int i = 0; i < operacion.size(); i++) {
            token = operacion.get(i);
            matcher = pattern.matcher(token);

            if (token.equals("(")) {
                pila.push(token);
                cont++;
            } else if (this.esOperador(token)) {
                if (!pila.empty()) {
                    if (checarPrecedencia(token, pila.peek())) {
                        resultado.add(pila.pop());
                        pila.push(token);
                    } else {

                        pila.push(token);
                    }
                } else {
                    pila.push(token);
                }
            } else if (token.equals(")")) {
                cont--;
                if(!pila.empty()){
                    while (true) {
                        if (!pila.empty()) {
                            if (!pila.peek().equals("(")) {
                                resultado.add(pila.pop());
                            } else {
                                pila.pop();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }else{
                    throw new ParentesisException("Error de paréntesis: Paréntesis de cierre sobrante.");
                }
            } else if (matcher.matches()) {
                if(token.equalsIgnoreCase("er")){
                    token=""+Math.E+"d";
                }
                resultado.add(token);
            }

            if(cont<0){
                throw new ParentesisException("Error de paréntesis: Paréntesis de cierre sobrante. Contador "+cont);
            }

        }

        while (!pila.empty()) {
            if(!pila.peek().equals("(")){
                resultado.add(pila.pop());
            }else{
                throw new ParentesisException("Error de paréntesis: Paréntesis de abertura sobrante. Pila con parentesis");
            }
        }

        this.prefija=resultado;

        return resultado;
    }

    private boolean checarPrecedencia(String op, String top) {

        return darPreExp(op) <= darPrePila(top);

    }

    private int darPreExp(String c) {
        //TODO ¿Tiene la misma precedencia U y ^?
        switch (c) {
            case "^":
            case "u":case "U":
                return 4;
            case "/":
            case "*":
            case "%":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }
    }

    private int darPrePila(String c) {
        switch (c) {
            case "^":
            case "u":case "U":
                return 3;
            case "/":
            case "*":
            case "%":
                return 2;
            case "+":
            case "-":

                return 1;
            default:
                return 0;
        }
    }

    private boolean esOperador(String c) {
        return c.equals("+") || c.equals("-") || c.equals("/") || c.equals("*") || c.equals("%") || c.equals("^")
                || c.equalsIgnoreCase("U");
    }


    public ArrayList<String> darNumeros() throws FormatoEquivocadoException {
        String patronNum= "([01]+([.][01]+)?[B]|[0-9]+([.][0-9]+)?" +
                "|[0-7]+([.][0-7]+)?[O]|[0-9A-F]+([.][0-9A-F]+)?[X]|[eE][rR])";
        //TODO agregar er al patron
        //Pattern pattern=Pattern.compile(,Pattern.CASE_INSENSITIVE);
        //Matcher matcher;

        ArrayList<String> array = tokenizar(this.cadena,"(?<token>[u]?("+patronNum+"))");

        /**
         *  Todo por si acaso: para agarrar un numero de euler (er) junto con su exponente
         *  se me ocurre esta idea [eE][rR][^]\\d+ y que solo acepte decimales
         */

        for(int i=0;i<array.size();i++){
            String num = array.get(i);
            if(num.matches("[eE][rR]")){
                num="e";
            }
            if(num.charAt(0)=='U' || num.charAt(0)=='u'){
                num = "-"+num.substring(1);
            }
            if(num.matches("[-]?\\d+([.]\\d+)?")){
                num+="d";
            }
            numeros.add(num);
        }

        return this.numeros;
    }

}
