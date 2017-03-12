
package caja;

import java.util.*;

public class ListaCuentas {
    ArrayList <Cuenta> listaCuentas;

    public ListaCuentas() {
        listaCuentas = new ArrayList <>();
    }
    
    public void agreDatoCuenta(int numCuenta, String tipoCuenta, String fecAper){
        Cuenta cuenta = new Cuenta(numCuenta,tipoCuenta,fecAper);
        listaCuentas.add(cuenta);
    }
    
    public void agreDatoCuenta(Cuenta cuenta){
        listaCuentas.add(cuenta);
    }
    
    @Override
    public String toString(){
        String sal="";
        
        for(int i=0; i<listaCuentas.size(); i++){
            sal+= listaCuentas.get(i).toString();
        }
        
        return sal;
    }
    
    
}
