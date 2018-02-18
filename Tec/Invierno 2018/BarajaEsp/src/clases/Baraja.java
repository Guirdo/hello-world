package clases;

public class Baraja {
    Nodo cabeza;
    int tamano;
    
    public Baraja(){
        cabeza=null;
        tamano=0;
    }
    
    public boolean esVacia(){
        return (cabeza==null);
    }
    
    public Object obtener(int index) {
        int contador = 0;
        Nodo temp = cabeza;

        while (contador < index) {
            temp = temp.obtenerSiguiente();
            contador++;
        }
        return temp.obtenerCarta();
    }

    public void addCabeza(int num,int index) {
        if (cabeza == null) {
            cabeza = new Nodo(new Carta(num,index));
        } else {
            /*
            Se guarda temporalmente la cabeza,
            entonces se crea un nodo aislado antes de agregarlo a la cabeza,
            Para agregarlo a su nuevo lugar, se enlaza con el nodo temporal
             */
            Nodo temp = cabeza;
            Nodo nuevo = new Nodo(new Carta(num,index));
            nuevo.enlazarSiguiente(temp);
            cabeza = nuevo;
        }
        tamano++;
    }

    public void cortarLista(int tam) {
        int contador = 0;

        while (contador < tam) {
            cabeza = cabeza.obtenerSiguiente();
            contador++;
        }
        tamano = tamano - tam;
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
        tamano--;
    }

    public int size() {
        return tamano;
    }

    @Override
    public String toString() {
        String salida = "";
        Nodo temp = cabeza;

        for (int i = 0; i < tamano; i++) {
            salida += temp.toString()+ "\n";
            temp = temp.obtenerSiguiente();
        }
        return salida;
    }
}
