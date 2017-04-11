package demobasedatos;

import java.util.ArrayList;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class BaseDatos {
    private ArrayList<Elemento> elementos;
    protected String sal;
    
    public BaseDatos(){
        elementos = new ArrayList<>();
    }
    
    public void addElemento(Elemento ele){
        elementos.add(ele);
    }
    
    @Override
    public String toString(){
        return "Contenido del arreglo:\n"+elementos.toString();
    }
}
