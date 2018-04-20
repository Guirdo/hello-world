package registradora;

import java.util.Stack;
import javax.swing.JOptionPane;

public class Pila {
    Stack pila;
    String nombre;
    int tam;
    
    public Pila(){
        pila = new Stack();
        tam = 0;
    }
    
    public int tamano(){
        return tam;
    }
    
    public void agregar(String nom){
        pila.push(nom);
        tam++;
    }
    
    public boolean buscar(String nom){
        if(pila.contains(nom)){
            return true;
        }else{
            return false;
        }
    }
    
    public void eliminar(String nom){
        if(buscar(nom)){
            imprimir();
        }else{
            JOptionPane.showMessageDialog(null,"El elemento no se encuentra");
        }
    }
    
    public void imprimir(){
        String salida = "";
        
        for(int i=0; i< tamano();i++){
            salida += pila.toString()+"\n";
        }
        
        JOptionPane.showMessageDialog(null,salida,"Salida de resultados",JOptionPane.INFORMATION_MESSAGE);
    }
}
