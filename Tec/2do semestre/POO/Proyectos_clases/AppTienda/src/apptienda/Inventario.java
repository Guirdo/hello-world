package apptienda;

import java.util.*;

public class Inventario {

    private ArrayList<Producto> invent;

    public Inventario() {
        invent = new ArrayList<>();
    }
    
    public void agregarPro(Producto pro){
        invent.add(pro);
    }
    
    public void disminuirInventario(Venta ven){
       invent.get(invent.indexOf(ven.getProCom())).setCantidad(invent.get(invent.indexOf(ven.getProCom())).getCantidad()-ven.getCantiCom());
    }
    
    @Override
    public String toString() {
        String sal = "";

        for (int i = 0; i < invent.size(); i++) {
            sal += invent.get(i).toString();
        }

        return sal;
    }

}
