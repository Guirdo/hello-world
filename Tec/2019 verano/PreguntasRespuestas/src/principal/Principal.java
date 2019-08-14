/*
 * Hola!
 */
package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader b = null;
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        try {
            String cadena, archivo = "";
            Ruta r = new Ruta();
            b = new BufferedReader(new FileReader(r.getRuta()));
            
            while ((cadena = b.readLine()) != null) {
                
                if(ManejoLineas.esPreguntas(cadena)){
                    preguntas.add(new Pregunta(ManejoLineas.darPregunta(cadena)));
                }else if(ManejoLineas.esRespuesta(cadena)){
                    preguntas.get(preguntas.size()-1).
                            agregarRespuesta(new Respuesta(ManejoLineas.darRespuesta(cadena), false));
                }else if(ManejoLineas.esRespuestaCorrecta(cadena)){
                    preguntas.get(preguntas.size()-1).
                            agregarRespuesta(new Respuesta(ManejoLineas.darRespuestaCorrecta(cadena), true));
                }else{
                    System.out.println("es un comentario:  "+cadena);
                }
                
            }
            b.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                b.close();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for(Pregunta p :preguntas){
            System.out.println(p.toString()+"\n");
        }
    }

}

class Ruta {

    //String ruta = getClass().getResource("/archivos/preguntas.txt").getFile();
    String ruta ="src/archivos/preguntas.txt";

    public String getRuta() {
        return ruta;
    }

}
