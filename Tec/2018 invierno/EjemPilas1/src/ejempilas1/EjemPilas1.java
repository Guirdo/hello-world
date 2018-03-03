/*
 * Hola!
 */
package ejempilas1;

import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class EjemPilas1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PilaArray pila = new PilaArray(125);
        String []menu={"Push","Pop","Primero","Visualizar","Salir"};
        int seleccion = 0;
        String empujado,popeado,primero;
        
        while(seleccion != 4){
            seleccion = JOptionPane.showOptionDialog(null,"","Menú principal",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,menu,null);
            
            switch(seleccion){
                //Push
                case 0:
                    empujado = JOptionPane.showInputDialog(null,"Ingrese el objeto a introducir","Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                    pila.push(empujado);
                    break;
                //Popear
                case 1:
                    popeado = pila.pop().toString();
                    JOptionPane.showMessageDialog(null,"El objeto popeado es: "+popeado,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
                    break;
                //Primero
                case 2:
                    primero=pila.primero().toString();
                    JOptionPane.showMessageDialog(null,"El primer objeto de la pila es: "+primero,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    if(!pila.esVacia()){
                        JOptionPane.showMessageDialog(null,pila.toString());
                    }else{
                        JOptionPane.showMessageDialog(null,"La pila esta vacia","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }
        }
    }
    
}
