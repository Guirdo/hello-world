package apptienda;

import java.util.*;

public class Inventario {

    private ArrayList<Producto> invent;

    public Inventario() {
        invent = new ArrayList<>();
    }
    
    public int numPro(){
        return invent.size();
    }
    
    public void agregarPro(Producto pro){
        invent.add(pro);
    }
    
    public void disminuirInventario(int num,int cant){
       int num2=invent.get(num).getCantidad();
       
       invent.get(num).setCantidad(num2-cant);
    }
    
    public int busqueda(String nombre){
        int esta = 0;
        for(int i=0;i<invent.size();i++){
            if(invent.get(i).getNombre().equals(nombre)){
                esta = i;
                break;
            }    
            else
                esta = -1;
        }
        
        return esta;
    }
    
    public String [] getLista(){
        String [] lista = new String[invent.size()];
        
        for(int i=0;i<invent.size();i++){
            lista[i]=invent.get(i).getNombre();
        }
        
        return lista;
    }
    
    public String verProductos(){
        String sal="";
        
        for(int i=0;i<invent.size();i++){
            sal+="-"+invent.get(i).getNombre()+
                 "\n-Cantidad: "+invent.get(i).getCantidad()+"\n\n";
        }
        
        return sal;
    }
    
    public String getNombre(int num){
        return invent.get(num).getNombre();
    }
    
    public int getCantidad(int num){
        return invent.get(num).getCantidad();
    }
    
    public double getPrecio(int num){
        return invent.get(num).getPrecio();
    }
    
    public void modificarProducto(int num,String nombre,int cantidad,double precio){
        invent.get(num).setNombre(nombre);
        invent.get(num).setCantidad(cantidad);
        invent.get(num).setPrecio(precio);
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
