package escribirleerdatos;

import java.util.ArrayList;

public class ListPersonas {
    ArrayList<Persona> lista;
    
    public ListPersonas(){
        this.lista= new ArrayList<>();
    }
    
    public void agregar(Persona obj){
        lista.add(obj);
    }
    
    public int tamano(){
        return lista.size();
    }
    
    public String imprimir(){
        String salida = "";
        
        for(Persona per : lista){
            salida+=per.toString()+"\n";
        }
        
        return salida;
    }
}
