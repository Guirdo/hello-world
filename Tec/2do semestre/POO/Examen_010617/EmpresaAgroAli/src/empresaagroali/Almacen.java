package empresaagroali;

import java.util.ArrayList;

public class Almacen {
    ArrayList<Producto> almacen;

    public Almacen() {
        almacen = new ArrayList<>();
    }
    
    public void agregarProducto(Producto pro){
        almacen.add(pro);
    }
    
    public int tam(){
        return almacen.size();
    }
    
    public String vizualizaProducto(int i){
        return almacen.get(i).toString();
    }
    
    
}
