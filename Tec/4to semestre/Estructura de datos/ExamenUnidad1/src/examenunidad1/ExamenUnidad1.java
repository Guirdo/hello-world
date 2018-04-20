
package examenunidad1;

import javax.swing.JOptionPane;

public class ExamenUnidad1 {

    public static void main(String[] args) {
        int seleccion=0;
        String titulo;
        int ancho,alto,tamKb;
        ListaImagen lista = new ListaImagen();
        
        while(seleccion < 4){
            
            seleccion = JOptionPane.showOptionDialog(null,"","Menu principal",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[]{"Añadir","Buscar","Mostrar","Visualizar","Salir"},"Añadir");
            
            switch(seleccion){
                case 0:
                    int seleccion1 = 0;
                    while(seleccion1 < 1){
                        titulo = JOptionPane.showInputDialog(null,"Ingrese el titulo de la imagen","Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                        ancho = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el ancho en pixeles de la imagen","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
                        alto = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el alto en pixeles de la imagen","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
                        tamKb = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el tamaño (Kb) de la imagen","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
                        
                        lista.agregarImagen(new DatosImagen(titulo,ancho,alto,tamKb));
                        
                        seleccion1 = JOptionPane.showOptionDialog(null,"¿Desea ingresar otro elemento a la lista?","Entrada de datos",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
                    }
                    break;
                    
                case 1:
                    if(lista.tamanoLista()>0){
                        String nom = JOptionPane.showInputDialog(null,"Ingrese el titulo de la imagen a buscar","Buscar imagen",JOptionPane.QUESTION_MESSAGE);
                        JOptionPane.showMessageDialog(null,lista.buscarImagen(nom),"Buscar imagen",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null,"La lista de imagenes se encuentra vacia","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                    
                case 2:
                    if(lista.tamanoLista()>0){
                        int buscarTam = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el tamaño (Kb) por buscar","Mostrar titulos",JOptionPane.QUESTION_MESSAGE));
                        JOptionPane.showMessageDialog(null,lista.mostrarTitulos(buscarTam),"Mostrar titulos",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null,"La lista de imagenes se encuentra vacia","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                    
                case 3:
                    if(lista.tamanoLista()>0){
                        JOptionPane.showMessageDialog(null,lista.visualizarDatos(),"Visualizar datos",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null,"La lista de imagenes se encuentra vacia","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }
        }
        
        System.exit(0);
    }
    
}
