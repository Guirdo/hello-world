/*
 * Hola!
 */
package clasescompuestas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class ClasesCompuestas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ObjectOutputStream salida = null;
        ObjectInputStream entrada = null;
        Alumno alum,leerAlum;
        Fecha fech;
        
        try{
            salida = new ObjectOutputStream(new FileOutputStream("alumnos.dat"));
            
            alum = new Alumno(16520223,new Fecha(24,8,2004),"Aldo","Masculino",19,56.1,1.63);
            salida.writeObject(alum);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClasesCompuestas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClasesCompuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
