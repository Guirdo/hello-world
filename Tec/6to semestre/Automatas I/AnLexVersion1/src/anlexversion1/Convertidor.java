package anlexversion1;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Convertidor {

    Stack<Character> pila;
    String infija;
    final String PATRON_NUMERICO = "\\d+([.]\\d+)?";
    ArrayList<String> tokenizado;

    public Convertidor(String cadena) {
        this.pila = new Stack();
        this.infija = cadena;
        this.tokenizado=this.tokenizarCadena();
    }

    public String darPrefija() {
        String resultado = "";
        int cont = 0;

        for (int i = 0; i < infija.length(); i++) {
            char c = infija.charAt(i);

            if (c == '(') {
                pila.push(c);
            } else if (this.esOperador(c)) {
                if (!pila.empty()) {
                    if (checarPrecedencia(c, pila.peek())) {
                        resultado += pila.pop();
                        pila.push(c);
                    } else {
                        pila.push(c);
                    }
                } else {
                    pila.push(c);
                }
            } else if (c == ')') {
                while (true) {
                    if (!pila.empty()) {
                        if (pila.peek() != '(') {
                            resultado += pila.pop();
                        } else {
                            while (!pila.empty() && pila.peek() == '(') {
                                pila.pop();
                            }
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else if (Character.isDigit(c)) {
                resultado += c;
            }
        }

        while (!pila.empty()) {
            resultado += pila.pop();
        }

        return resultado;
    }

    public boolean checarPrecedencia(char op, char top) {

        return darPreExp(op) < darPrePila(top);

    }

    private int darPreExp(char c) {

        switch (c) {
            case '^':
                return 4;
            case '/':
            case '*':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    private int darPrePila(char c) {
        switch (c) {
            case '^':
                return 3;
            case '/':
            case '*':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    public boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '/' || c == '*' || c == '%' || c == '^';
    }

    private ArrayList<String> tokenizarCadena() {
        ArrayList<String> resultado = new ArrayList<>();
        String patron = "(?<token>[\\(]|"+PATRON_NUMERICO+"|[-*^/+%]|[\\)])";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(this.infija);
        
        while(matcher.find()){
            String token = matcher.group("token");
            System.out.println(token);
            resultado.add(token);
        }
        
        return resultado;
    }
    
    public ArrayList<String> getTokenizado(){
        return this.tokenizado;
    }

}
