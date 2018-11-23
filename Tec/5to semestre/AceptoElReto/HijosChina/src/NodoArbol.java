public class NodoArbol {

    private int dato;
    private NodoArbol hijoIzq,hijoDer;

    public NodoArbol(int dato){
        this.dato=dato;
        hijoIzq=null;
        hijoDer=null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setHijoIzq(NodoArbol hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public void setHijoDer(NodoArbol hijoDer) {
        this.hijoDer = hijoDer;
    }

    public NodoArbol getHijoIzq() {
        return hijoIzq;
    }

    public NodoArbol getHijoDer() {
        return hijoDer;
    }

    @Override
    public String toString() {
        return "NodoArbol{" +
                "dato=" + dato +
                '}';
    }
}
