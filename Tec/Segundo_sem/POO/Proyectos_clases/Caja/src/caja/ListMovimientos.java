package caja;

import java.util.*;

public class ListMovimientos {

    ArrayList<Movimiento> listaMovs;

    public ListMovimientos() {
        listaMovs = new ArrayList<>();
    }

    public void agreMov(Movimiento mov) {
        listaMovs.add(mov);
    }
    
    @Override
    public String toString(){
        String sal="";
        
        for(int i=0;i<listaMovs.size(); i++){
            sal+="\nMovimiento No. "+(i+1)+listaMovs.get(i).toString();
        }
        
        return sal;
    }
}
