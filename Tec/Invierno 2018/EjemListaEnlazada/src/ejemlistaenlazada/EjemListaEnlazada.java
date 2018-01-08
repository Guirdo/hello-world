/*
 * Hola!
 */
package ejemlistaenlazada;

import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class EjemListaEnlazada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaEnlazada lista = new ListaEnlazada();
        String menu[]={"Agregar","Obtener","Cortar","Eliminar","Visualizar","Salir"};
        String objeto;
        int selec=0,index=0,cortar=0;
        
        while(selec!=5){
            selec=JOptionPane.showOptionDialog(null,"","Menú principal",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,menu,null);
            
            switch(selec){
                //Agregar
                case 0:
                    objeto=JOptionPane.showInputDialog(null,"Ingrese el objeto","Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                    lista.addCabeza(objeto);
                    break;
                //Obtener
                case 1:
                    index=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el indice","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
                    objeto=lista.obtener(index).toString();
                    JOptionPane.showMessageDialog(null,"El objeto es: "+objeto,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
                    break;
                //Cortar
                case 2:
                    cortar=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la longitud del corte","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
                    lista.cortarLista(cortar);
                    break;
                //Eliminar
                case 3:
                    index=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el indice a eliminar","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
                    lista.eliminar(index);
                    break;
                //Visualizar
                case 4:
                    if(!lista.esVacia()){
                        JOptionPane.showMessageDialog(null,lista.toString(),"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                       JOptionPane.showMessageDialog(null,"La lista esta vacia","Mensaje de error",JOptionPane.ERROR_MESSAGE); 
                    }
                    break;
            }
        }
    }
    
}
