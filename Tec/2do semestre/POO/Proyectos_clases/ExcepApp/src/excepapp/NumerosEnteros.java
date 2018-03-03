package excepapp;

import java.util.ArrayList;

public class NumerosEnteros {
    private ArrayList<Integer> arreglo;

    public NumerosEnteros() {
        arreglo = new ArrayList<>();
    }
    
    public void agregarElemento(int num){
        arreglo.add(num);
    }
    
    public void modificarElemento(int num,int numMod) throws ExcepcionNoEncontrado{
        int posicion = buscarElemento(num);
        
        if(posicion == -1){
            throw new ExcepcionNoEncontrado("El elemento a modificar no se encuentra en el arreglo...");
        }
        
        arreglo.set(posicion, numMod);
    }
    
    public boolean arregloVacio() throws ExcepcionArregloVacio{
        if(arreglo.size() > 0){
            return false;
        }
        throw new ExcepcionArregloVacio("Error, el arreglo no contiene ningun elemento...");
    }
    
    public String buscar(int num) throws ExcepcionNoEncontrado{
        String sal ="";
        
        for(int i=0;i<arreglo.size();i++){
            if(arreglo.get(i) == num){
                sal+="["+i+"]: "+arreglo.get(i)+"\n";
            }
        }
        
        if(sal.isEmpty()){
            throw new ExcepcionNoEncontrado("El elemento no se encuentra en el arreglo...");
        }
        
        return sal;
    }
    
    public void eliminarElemento(int num) throws ExcepcionNoEncontrado{
        int posicion = buscarElemento(num);
            
        if(posicion == -1){
            throw new ExcepcionNoEncontrado("El elemento a eliminar no se encuentra en el arreglo...");
        }
        
        arreglo.remove(posicion);
        
    }
    
    private int buscarElemento(int num) {
        int posicion=-1;
        
        for(int i=0;i<arreglo.size();i++){
            if(arreglo.get(i) == num){
                posicion=i;
            }
        }
        
        return posicion;
    }
    
    @Override
    public String toString(){
        String sal="";
        
        for(int i=0;i<arreglo.size();i++){
            sal+="["+i+"]: "+arreglo.get(i)+"\n";
        }
        
        return sal;
    }
    
    
}
