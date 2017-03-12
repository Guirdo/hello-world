
package caja;

import java.util.*;

public class ListaCuentaHabientes {
    ArrayList <CuentaHabiente> listaCuenHa;
    
    public ListaCuentaHabientes(){
        listaCuenHa= new ArrayList<>();
    }
    
    public void agreCuenHa(CuentaHabiente cuenHa){
        listaCuenHa.add(cuenHa);
    }
    
    @Override
    public String toString(){
        String sal="";
        
        for(int i=0; i<listaCuenHa.size(); i++){
            sal+="Registro No. "+(i+1)+"\n"+listaCuenHa.get(i).toString()+"\n";
        }
        
        return sal;
    }
}
