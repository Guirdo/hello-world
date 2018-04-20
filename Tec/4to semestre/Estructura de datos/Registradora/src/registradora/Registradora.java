/*
 * Hola!
 */
package registradora;

import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Registradora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num,selec=0;
        Pila pila = new Pila();
        
        num = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de elementos a ingresar","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
        
        for(int i=0; i< num; i++){
            Object nom = JOptionPane.showInputDialog(null,"Ingrese el dato #"+(i+1),"Entrada de datos",JOptionPane.QUESTION_MESSAGE);
            pila.agregar(nom.toString());
        }
        
        while(selec != 3){
            selec = JOptionPane.showOptionDialog(null,"","Menú principal",JOptionPane.QUESTION_MESSAGE,JOptionPane.YES_NO_CANCEL_OPTION,null,new Object[]{"Eliminar","Agregar","Imprimir","Salir"},null);
            switch(selec){
                
            }
        }
        
    }
    
}
