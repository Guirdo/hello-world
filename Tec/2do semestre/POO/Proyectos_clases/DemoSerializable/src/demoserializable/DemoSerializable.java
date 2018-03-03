/*
 * Hola!
 */
package demoserializable;

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
public class DemoSerializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ObjectOutputStream salida = null;
        ObjectInputStream entrada = null;
        Empleado empleado,leerEmpleado;
        
        try{
            salida = new ObjectOutputStream(new FileOutputStream("empleados.dat"));
            empleado = new Empleado(2012,1200.40,"Juan Perez Lopez","Masculino",38,78.89,1.78);
            salida.writeObject(empleado);
            
            empleado = new Empleado(2013,1200.40,"Diana Viladolores","Femenino",38,78.89,1.78);
            salida.writeObject(empleado);
            
            empleado = new Empleado(2013,1200.40,"Mujer maravilla","Femenino",38,78.89,1.78);
            salida.writeObject(empleado);
            
            salida.close();
            
            entrada = new ObjectInputStream(new FileInputStream("empleados.dat"));
            
            try{
                while(true){
                    leerEmpleado = (Empleado) entrada.readObject();
                    System.out.println(leerEmpleado.toString());
                }
            } catch (ClassNotFoundException ex) {
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error: "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: "+ex.getMessage());
        }finally{
            try{
                if(salida!=null){
                    salida.close();
                }
                if(entrada != null){
                    entrada.close();
                }
            }catch(IOException ex){
                System.out.println("Error: "+ex.getMessage());
            }
        }
    }
    
}
