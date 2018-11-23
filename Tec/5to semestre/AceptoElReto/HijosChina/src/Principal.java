import javax.swing.*;

public class Principal {

    public static void main(String[] args) {
        int opcion =0,elemento;
        ArbolBinario arbolito = new ArbolBinario();

        do{
            opcion=JOptionPane.showOptionDialog(null,"","Menu",
                    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
                    null,new Object[]{"Agregar","Inorden","Preorden","Postorden","Buscar","Salir"},null);

            switch (opcion){
                case 0:
                    elemento=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero del nodo","Ingresar nodo",JOptionPane.QUESTION_MESSAGE));
                    arbolito.agregarNodo(elemento);
                    break;
                case 1:
                    if(!arbolito.estaVacio()){
                        arbolito.inOrden(arbolito.getRaiz());
                    }else{
                        JOptionPane.showMessageDialog(null,"El arbol esta vacio");
                    }
                    break;
                case 2:
                    if(!arbolito.estaVacio()){
                        arbolito.preOrden(arbolito.getRaiz());
                    }else{
                        JOptionPane.showMessageDialog(null,"El arbol esta vacio");
                    }
                    break;
                case 3:
                    if(!arbolito.estaVacio()){
                        arbolito.postOrden(arbolito.getRaiz());
                    }else{
                        JOptionPane.showMessageDialog(null,"El arbol esta vacio");
                    }
                    break;
                case 4:
                    if(!arbolito.estaVacio()){
                        elemento=Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el numero del nodo a buscar","Ingresar nodo",JOptionPane.QUESTION_MESSAGE));
                        NodoArbol encontrado=arbolito.buscarNodo(elemento);
                        if(encontrado!=null){
                            System.out.println(encontrado.toString());
                        }else{
                            JOptionPane.showMessageDialog(null,"No se encontro el elemento");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"El arbol esta vacio");
                    }
                    break;
            }

        }while (opcion!=5);

        System.exit(0);
    }
}
