/*
 * Hola, mortal. Saludos desde el más paca, o sease, desde el pasado.
 * Sabes, me canse escribriendo (la verdad no, pero me gusta el drama),
 * asi que usalo bien, ponte a estudiar cabron/a.
 */
package excepcion1;

import java.util.Vector;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
class ListaNumeros {

    private final Vector lista;

    public ListaNumeros() {
        lista = new Vector();
    }
    
    public void agreEle(int ele){
        lista.addElement(ele);
    }
    
    public void eliminarEle(int ind){
        try{
            lista.remove(ind);
            System.out.print("El elemento de la posición "+ind+"fue eliminado.");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error, el indice de la lista esta fuera del alcance");
        }
    }
    
    public void escribirLista(){
        if(lista.isEmpty())
            System.out.println("Error, la lista esta vacía...");
        else{
            System.out.println("Visualización de los elementos de la lista\n");
            for(int i=0;i<lista.size();i++)
                System.out.println("Elemento["+i+"]= "+lista.elementAt(i));
        }
    }
}

public class Excepcion1 {

    public static void main(String[] args) {
        ListaNumeros lista = new ListaNumeros();
        lista.agreEle(5);
        lista.agreEle(51);
        lista.agreEle(15);
        lista.agreEle(55);
        lista.escribirLista();
        lista.eliminarEle(30);
        lista.escribirLista();
        System.out.println("El programa ha sido cerrado exitosamente");
        System.exit(0);
    }

}
