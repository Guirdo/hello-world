package examenunidad1;

import java.util.ArrayList;

public class ListaImagen {
    ArrayList<DatosImagen> lista;

    public ListaImagen() {
        this.lista = new ArrayList();
    }
    
    public void agregarImagen(DatosImagen obj){
        lista.add(obj);
    }
    
    public String buscarImagen(String nom){
        boolean esta = false;
        int pos = 0;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getTitutloImagen().equals(nom)){
                esta = true;
                pos = i;
            }
        }
        
        if(esta){
            return "La imagen "+nom+" se encuentra en la posición "+pos;
        }else{
            return "La imagen "+nom+" no se encuentra en la lista";
        }
    }
    
    public String mostrarTitulos(int tam){
        String salida = "";
        
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getTamKb() == tam){
                salida+=lista.get(i).getTitutloImagen()+"\n";
            }
        }
        
        if(!salida.isEmpty()){
            return salida;
        }else{
            return "No existen imagenes de ese tamaño";
        }
    }
    
    public String visualizarDatos(){
        String salida = "";
        
        for(int i=0;i<lista.size();i++){
            salida+=lista.get(i).toString();
        }
        
        return salida;
    }
    
    public int tamanoLista(){
        return lista.size();
    }
}
