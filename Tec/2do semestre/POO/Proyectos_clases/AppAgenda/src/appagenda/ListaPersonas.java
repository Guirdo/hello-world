package appagenda;

//Falta la clase Agenda!!

import java.util.*;

public class ListaPersonas {

    ArrayList<Persona> listPerso;

    public ListaPersonas() {
        listPerso = new ArrayList<>();
    }

    public void agreLisPer(Persona perso) {
        listPerso.add(perso);
    }

    public int numPer() {
        return listPerso.size();
    }
    
    public String obtenerPerso(String nom){
        int pos=0;
        
        for(int i=0; i< listPerso.size();i++){
            if(listPerso.get(i).getNombre().equals(nom))
                pos = i;
        }
        
        return listPerso.get(pos).toString();
    }
    
    public String obtenerTel(String tel){
        int pos=0;
        
        for(int i=0; i< listPerso.size();i++){
            if(listPerso.get(i).getArrayLisTel().toString().equals(tel))
                pos = i;
            else
                pos=-1;
        }
        
        return listPerso.get(pos).toString();
    }
    
    public String[]  darListaPers(){
        String [] lista = new String [listPerso.size()];
        
        for(int i=0; i< listPerso.size(); i++){
            lista[i]=listPerso.get(i).getNombre();
        }
        
        return lista;
    }
    
    public void eliminar(String nom){
        listPerso.remove(listPerso.indexOf(nom));
    }

    @Override
    public String toString() {
        String sal = "";

        for (int i = 0; i < listPerso.size(); i++) {
            sal += "Registro No. " + (i + 1) + "\n" + listPerso.get(i).toString() + "\n";
        }

        return sal;
    }

}
