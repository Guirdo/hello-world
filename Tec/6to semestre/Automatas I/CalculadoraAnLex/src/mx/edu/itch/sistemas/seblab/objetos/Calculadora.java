package mx.edu.itch.sistemas.seblab.objetos;

import mx.edu.itch.sistemas.seblab.excepciones.FormatoEquivocadoException;

import java.util.ArrayList;
import java.util.Stack;

public class Calculadora {

    private ArrayList<String> polaca;
    private Stack<String> pila;
    private SistemasNumericos sn;

    public Calculadora(ArrayList<String> polaca) throws FormatoEquivocadoException {
        this.polaca=polaca;
        this.pila= new Stack<>();
        this.sn= new SistemasNumericos();

        this.convertirNumeros();
    }

    private void convertirNumeros() throws FormatoEquivocadoException {
        String tok;
        for (int i=0;i<polaca.size();i++){
            tok=polaca.get(i);
            if(!esOperador(tok)){
                polaca.set(i,""+sn.convertirADecimal(
                        tok.substring(0,tok.length()-1),tok.charAt(tok.length()-1)+""));

            }
        }
    }

    public double calcular() throws FormatoEquivocadoException {
        String token,right,left;
        for(int i=0;i<polaca.size();i++){
            token = polaca.get(i);
            if(esOperador(token)){
                if(token.equalsIgnoreCase("u")){
                    String num = ""+(Double.parseDouble(pila.pop())*-1);
                    pila.push(num);
                }else{
                    if(!pila.empty()){
                        right = pila.pop();
                        if(pila.empty()){
                            throw new FormatoEquivocadoException("¡Formato de numero erroneo!");
                        }
                        left = pila.pop();
                        pila.push(""+operar(left,token,right));
                    }
                }
            }else{
                pila.push(token);
            }
        }

        return Double.parseDouble(pila.peek());
    }

    private double operar(String left, String op, String right){
        double a = Double.parseDouble(left);
        double b = Double.parseDouble(right);

        switch (op){
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
            case "/": return a/b;
            case "%": return a%b;
            case "^": return Math.pow(a,b);
            default:return -1;
        }
    }

    private boolean esOperador(String c) {
        return c.equals("+") || c.equals("-") || c.equals("/") || c.equals("*") || c.equals("%") || c.equals("^")
                || c.equalsIgnoreCase("u");
    }

}
