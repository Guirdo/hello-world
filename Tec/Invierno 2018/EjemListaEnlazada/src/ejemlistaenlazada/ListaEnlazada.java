package ejemlistaenlazada;

public class ListaEnlazada {

    Nodo cabeza;
    int size;

    public ListaEnlazada() {
        cabeza = null;
        size = 0;
    }

    public boolean esVacia() {
        return (cabeza == null);
    }

    public Object obtener(int index) {
        int contador = 0;
        Nodo temp = cabeza;

        while (contador < index) {
            temp = temp.obtenerSiguiente();
            contador++;
        }
        return temp.obtenerValor();
    }

    public void addCabeza(Object obj) {
        if (cabeza == null) {
            cabeza = new Nodo(obj);
        } else {
            /*
            Se guarda temporalmente la cabeza,
            entonces se crea un nodo aislado antes de agregarlo a la cabeza,
            Para agregarlo a su nuevo lugar, se enlaza con el nodo temporal
             */
            Nodo temp = cabeza;
            Nodo nuevo = new Nodo(obj);
            nuevo.enlazarSiguiente(temp);
            cabeza = nuevo;
        }
        size++;
    }

    public void cortarLista(int tam) {
        int contador = 0;

        while (contador < tam) {
            cabeza = cabeza.obtenerSiguiente();
            contador++;
        }
        size = size - tam;
    }

    public void eliminar(int index) {
        if (index == 0) {
            cabeza=cabeza.obtenerSiguiente();
        } else {
            int contador = 0;
            Nodo temp = cabeza;
            
            while(contador<index-1){
                temp=temp.obtenerSiguiente();
                contador++;
            }
            temp.enlazarSiguiente(temp.obtenerSiguiente().obtenerSiguiente());
        }
        size--;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String salida = "";
        Nodo temp = cabeza;

        for (int i = 0; i < size; i++) {
            salida += temp.toString() + "\n";
            temp = temp.obtenerSiguiente();
        }
        return salida;
    }
}
