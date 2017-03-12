package appagenda;

import java.util.*;

public class Agenda {

    private final String titulo;
    private final ListaPersonas arrayLisPer;

    public Agenda() {
        titulo = "sin titulo";
        arrayLisPer = new ListaPersonas();
    }

    public Agenda(String titulo) {
        this.titulo = titulo;
        arrayLisPer = new ListaPersonas();
    }
    
    public void agrePerAge(Persona perso){
        arrayLisPer.agreLisPer(perso);
    }
    
    public int tamAge(){
        return arrayLisPer.numPer();
    }
    
    public String damePerso(String nom){
        return arrayLisPer.obtenerPerso(nom);
    }
    
    public String dameTel(String tel){
        return arrayLisPer.obtenerTel(tel);
    }
    
    public String[] darListaPerso(){
        return arrayLisPer.darListaPers();
    }
    
    public void eliminar(String nom){
        arrayLisPer.eliminar(nom);
    }
    
    //public String[] darListaTel(){
        
    //}
    
    @Override
    public String toString(){
        return "Agenda: "+titulo+"\n\n"+arrayLisPer.toString();
    }
}
