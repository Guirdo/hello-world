
package dearregloest1;
import javax.swing.*;

public class DeArregloEst1 {

    public static void main(String[] args) {
        String nombre,fechaNac,telefono;
        int num;
        
        try{
            num=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de personas: ","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
            if(num>0){
                //Se crea el espacio para el nu referencias a Persona
                Persona[] arrayPersonas = new Persona[num];
                
                for(int i=0;i<num;i++){
                    //Entrada de datos
                    nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre de la persona #"+i,"Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                    fechaNac=JOptionPane.showInputDialog(null,"Ingrese la fecha de nacimiento de la persona #"+i,"Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                    telefono=JOptionPane.showInputDialog(null,"Ingrese el numero telefonico de la persona #"+i,"Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                    
                    //Se almacenan los datos de tipo Persona en el arreglo
                    arrayPersonas[i]= new Persona(nombre,fechaNac,telefono);
                }
                
                //Salida de datos
                String sali="";
                for(int i=0;i<num;i++)
                    sali+=arrayPersonas[i].toString();
                
                JOptionPane.showMessageDialog(null,sali,"Datos personales",JOptionPane.INFORMATION_MESSAGE);
            }else
                JOptionPane.showMessageDialog(null,"Error, el numero de personas debe ser mayor a cero...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error, los datos deben ser numericos","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }
    
}
