package principal;

import java.util.ArrayList;

public class Pregunta {
    
    String texto;
    ArrayList<Respuesta> respuestas;

    public Pregunta(String texto) {
        this.texto = texto;
        this.respuestas = new ArrayList<>();
    }
    
    public void agregarRespuesta(Respuesta e){
        respuestas.add(e);
    }
    
    public boolean esRespuestaCorrecta(int index){
        return respuestas.get(index).isCorrecta();
    }
    
    public String toString(){
        String salida = "";
        
        salida+=texto+"\n";
        
        for(Respuesta r : respuestas) salida+= r.getTexto()+"\n";
        
        return salida;
    }

}
