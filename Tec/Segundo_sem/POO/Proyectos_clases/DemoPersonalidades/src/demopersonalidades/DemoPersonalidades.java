/*
 * Este programa se supone que crea objetos que representan a las diferentes personalidad
 * mala suerte que no fui a la clase donde 
 */
package demopersonalidades;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class DemoPersonalidades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Personalidad per = new Personalidad();
            Pesimista pest = new Pesimista();
            Optimista opti = new Optimista();
            Introvertido intro = new Introvertido();
            Extrovertido extro = new Extrovertido();
            
            ListaPersonalidades lista = new ListaPersonalidades();
            
            lista.addPersonalidad(per);
            lista.addPersonalidad(pest);
            lista.addPersonalidad(opti);
            lista.addPersonalidad(intro);
            lista.addPersonalidad(extro);
            
            lista.imprimirLista();
    }
    
}
