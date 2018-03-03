package clases;

public class Nodo {
    Carta carta;
    Nodo siguiente;
    
    public Nodo(Carta o){
        this.carta=o;
    }
    
    public void enlazarSiguiente(Nodo s){
        siguiente=s;
    }
    
    public Nodo obtenerSiguiente(){
        return siguiente;
    }
    
    public Carta obtenerCarta(){
        return carta;
    }
    
    @Override
    public String toString(){
        return carta.toString();
    }
    
}
