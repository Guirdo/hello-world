package automata_1;

public class Automata {
    
    private int estado;
    private int[] estadosFinales;
    
    /**
     * Crea un automata para comprobar que una cadena es un numero real
     * @param estadoInicial estado donde comenzara a evaluar el automata
     * @param estadosFinalesIniciales Estados finales que el automata tiene
     */
    public Automata(int estadoInicial, int... estadosFinalesIniciales) {
        estado = estadoInicial;
        estadosFinales = estadosFinalesIniciales;
    }
    
    public int getEstado() {
        return estado;
    }
    
    public void setEstado(int nuevoEstado) {
        estado = nuevoEstado;
    }
    
    public void transicion(char simbolo) {
        switch (estado) {
            case 1:
                if (ManejoCadenas.esSigno(simbolo)) {
                    estado = 2;
                } else if (ManejoCadenas.esDigito(simbolo)) {
                    estado = 3;
                } else {
                    System.out.println("Un real debe comenzar con un signo o un digito.");
                    estado=-1;
                    break;
                }
                break;
            
            case 2:
                if (ManejoCadenas.esDigito(simbolo)) {
                    estado = 3;
                } else {
                    System.out.println("Después de un digito o un signo sigue otro digito");
                    estado=-1;
                    break;
                }
                break;
            case 3:
                if (ManejoCadenas.esDigito(simbolo)) {
                    estado = 3;
                } else if (ManejoCadenas.esPunto(simbolo)) {
                    estado = 4;
                } else {
                    System.out.println("Después de un digito sigue otro digito o un punto");
                    estado=-1;
                    break;
                }
                break;
            case 4:
                if (ManejoCadenas.esDigito(simbolo)) {
                    estado = 5;
                } else {
                    System.out.println("Despues de un punto sigue un digito");
                    estado=-1;
                    break;
                }
                break;
            case 5:
                if (ManejoCadenas.esDigito(simbolo)) {
                    estado = 5;
                }else if(ManejoCadenas.esExponencian(simbolo)){
                    estado=6;
                } else {
                    System.out.println("Despues de un digito sigue otro digito o el simbolo de exponencial");
                    estado=-1;
                    break;
                }
                break;
            case 6:
                if(ManejoCadenas.esSigno(simbolo)){
                    estado=7;
                }else if(ManejoCadenas.esDigito(simbolo)){
                    estado=8;
                }else{
                    System.out.println("Después del simbolo de exponencian sigue un simbolo o un digito");
                    estado=-1;
                    break;
                }
                break;
            case 7:
                if(ManejoCadenas.esDigito(simbolo)){
                    estado=8;
                }else{
                    System.out.println("Después de un signo o un digito sigue un digito");
                    estado=-1;
                    break;
                }
                break;
            case 8:
                if(ManejoCadenas.esDigito(simbolo)){
                    estado=8;
                }else{
                    System.out.println("Después de un digito sigue otro digito");
                    estado=-1;
                    break;
                }
                break;
                default:break;
        }
    }
    
    public boolean esFinal() {
        for (int estadoFinal : estadosFinales) 
            if (estadoFinal == estado) return true;
        
        return false;
    }
    
}
