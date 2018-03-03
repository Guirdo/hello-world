package appagenda;

import java.util.*;

public class ListaTelefonos {

    //Atributos
    ArrayList<Telefono> arrayTel;

    //Metodo constructor
    public ListaTelefonos() {
        arrayTel = new ArrayList<>();
    }
    
    //Metodos
    public void agreDaTel(String numTel,String tipoTel){
        Telefono tel = new Telefono(numTel,tipoTel);
        arrayTel.add(tel);
    }
    
    public void agreDaTel(Telefono tel){
        agreDaTel(tel.getNumTel(),tel.getTipoTel());
    }
    
    @Override
    public String toString(){
        String sal="";
        
        for(int i=0; i<arrayTel.size(); i++)
            sal+=arrayTel.get(i).toString();
        
        return sal;
    }
}
