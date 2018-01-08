package ejemlistaenlazada;

public class Nodo {
    Object valor;
    Nodo siguiente;
    
    public Nodo(Object o){
        this.valor=o;
    }
    
    public void enlazarSiguiente(Nodo n){
        siguiente = n;
    }
    
    public Nodo obtenerSiguiente(){
        return siguiente;
    }
    
    public Object obtenerValor(){
        return valor;
    }
    
    @Override
    public String toString(){
        return valor.toString();
    }
}
