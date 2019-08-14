package automata_1;

public class ManejoCadenas {
    
    public static boolean esDigito(char c){
        return Character.isDigit(c);
    }
    
    public static boolean esSigno(char c){
        return c=='+' || c=='-';
    }
    
    public static boolean esPunto(char c){
        return c=='.';
    }
    
    public static boolean esFinCadena(char c){
        return c=='\n' || c=='\r';
    }
    
    public static boolean esExponencian(char c){
        return c=='e' || c=='E';
    }

}
