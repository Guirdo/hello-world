package demopersonalidades;

/**
 *¡Saludos, mortal! Espero te sirva copiar este programa.
 *Así que, espero que lo aproveches.
 * @author Sebastián Méndez <ITCH>
 */
public class ListaPersonalidades {
    private final ArratList<Personalidad> listaPer;
    
    public ListaPersonalidades(){
        listaPers = new ArrayList<>();
    }
    
    public void addPersonalidad(Personalidad per){
        listaPer.add(per);
    }
    
    public void imprimirLista(){
        System.out.println("Personalidades:\n");
        for(Personalidad pers : listaPer){
            System.out.println("\t-El objeto "+pers.getClass().getSimpleName()+"habla: "+pers.hablar);
        }
    }
}
