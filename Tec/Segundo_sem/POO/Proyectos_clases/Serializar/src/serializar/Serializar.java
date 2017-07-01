/*
 * Hola!
 */
package serializar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Serializar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ObjectOutputStream salida = null;
        ObjectInputStream entrada = null;
        Persona persona,leerPersona;

        try {
            salida = new ObjectOutputStream(new FileOutputStream("personas.dat"));

            persona = new Persona("Jose Daniel", "Masculino", 38, 89, 1.78);
            salida.writeObject(persona);

            persona = new Persona("Aldo Mendez", "Masculino", 19, 51, 1.63);
            salida.writeObject(persona);

            persona = new Persona("Estefania Bello", "Femenino", 19, 51, 1.70);
            salida.writeObject(persona);
            
            persona = new Persona("Jose Eduardo", "Femenino", 19, 51, 1.70);
            salida.writeObject(persona);
            
            persona = new Persona("Aldo Mendez", "Masculino", 19, 51, 1.63);
            salida.writeObject(persona);

            persona = new Persona("Estefania Bello", "Femenino", 19, 51, 1.70);
            salida.writeObject(persona);
            
            persona = new Persona("Jose Eduardo", "Femenino", 19, 51, 1.70);
            salida.writeObject(persona);
            
            salida.close();
            
            entrada = new ObjectInputStream(new FileInputStream("personas.dat"));
            
            try{
                while(true){
                    leerPersona = (Persona) entrada.readObject();
                    System.out.println(leerPersona.toString());
                }
            } catch (ClassNotFoundException ex) {
            }
            

        } catch (FileNotFoundException ex) {
            System.out.println("Error: 1" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: 2" + ex.getMessage());
        } finally {
            try {
                if (salida != null) {
                    salida.close();
                }
                if(entrada != null){
                    entrada.close();
                }
            } catch (IOException ex) {
                System.out.println("Error: este " + ex.getMessage());
            }
        }
    }

}
