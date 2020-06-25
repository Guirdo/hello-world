package principal;

public class Arbol {

    NodoArbol raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void agregarNodo(int dato, String nombre) {
        NodoArbol nuevo = new NodoArbol(dato, nombre);

        if (raiz == null) {
            raiz = nuevo;
            System.out.println("raiz --> ["+raiz.dato+"]");
        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;

            while (true) {
                padre = auxiliar;

                if (dato < auxiliar.dato) {
                    auxiliar = auxiliar.hijoIzquierdo;
                    if(auxiliar == null){
                        padre.hijoIzquierdo = nuevo;
                        System.out.println("["+padre.dato+"]---izquierda-->["+padre.hijoIzquierdo.dato+"]");
                        return;
                    }
                }else{
                    auxiliar = auxiliar.hijoDerecho;
                    if(auxiliar == null){
                        padre.hijoDerecho = nuevo;
                        System.out.println("["+padre.dato+"]---derecha-->["+padre.hijoDerecho.dato+"]");
                        return;
                    }
                }
            }
        }
    }
}
