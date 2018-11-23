public class ArbolBinario {

    private NodoArbol raiz;

    public ArbolBinario(){
        raiz=null;
    }

    public void agregarNodo(int dato){
        NodoArbol nuevo = new NodoArbol(dato);

        if(raiz==null){
            raiz=nuevo;
        }else{
            NodoArbol aux = raiz;
            NodoArbol padre;

            while(true){
                padre=aux;
                if(dato<aux.getDato()){
                    aux=aux.getHijoIzq();
                    if(aux==null){
                        padre.setHijoIzq(nuevo);
                        return;
                    }
                }else{
                    aux=aux.getHijoDer();
                    if(aux==null){
                        padre.setHijoDer(nuevo);
                        return;
                    }
                }
            }
        }
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public boolean estaVacio(){
        return raiz==null;
    }

    //Inorden
    public void inOrden(NodoArbol r){
        if(r!=null){
            inOrden(r.getHijoIzq());
            System.out.println(r.getDato());
            inOrden(r.getHijoDer());
        }
    }

    //PreOrden
    public void preOrden(NodoArbol r){
        if(r!=null){
            System.out.println(r.getDato());
            preOrden(r.getHijoIzq());
            preOrden(r.getHijoDer());
        }
    }

    public void postOrden(NodoArbol r){
        if(r!=null){
            postOrden(r.getHijoIzq());
            postOrden(r.getHijoDer());
            System.out.println(r.getDato());
        }
    }

    public NodoArbol buscarNodo(int dato){
        NodoArbol aux = raiz;

        while (aux.getDato()!=dato){
            if(dato < aux.getDato()){
                aux=aux.getHijoIzq();
            }else{
                aux=aux.getHijoDer();
            }

            if(aux==null){
                return null;
            }
        }

        return aux;
    }

}
