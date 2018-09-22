import javax.swing.*;

public class Principal {

    public static void main(String[] args){
        int seleccion=0;
        String[] opciones = {"Agregar datos","Visualizar datos","Salir"};
        String clave,nombreEsc,nombreDic;
        int edad;
        Escuela escuela = null;

        do{
            seleccion = JOptionPane.showOptionDialog(null,"","Menú principal",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,null);
            switch (seleccion){
                //Agegar datos
                case 0:
                    clave = JOptionPane.showInputDialog(null,"Ingrese la clave de la escuela","Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                    nombreEsc = JOptionPane.showInputDialog(null,"Ingrese el nombre de la escuela","Entrada de datos",JOptionPane.QUESTION_MESSAGE);

                    nombreDic = JOptionPane.showInputDialog(null,"Ingrese el nombre del director","Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                    edad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la edad del director","Entrada de datos",JOptionPane.QUESTION_MESSAGE));

                    escuela = new Escuela(clave,nombreEsc, new Director(nombreDic,edad));
                    break;

                //Visualizar datos
                case 1:
                    JOptionPane.showMessageDialog(null,escuela.imprimir(),"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }while(seleccion!=2);
    }
}
