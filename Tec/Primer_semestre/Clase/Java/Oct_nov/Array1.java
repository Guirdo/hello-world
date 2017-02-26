import javax.swing.*;

public class Array1{
  public static void main(String[] args) {
    int nEle,i,eleBus,pos;
    char res = 'S'; // 0    1
    Object opcion[]={"Si","No"};
    try {
      //Lectura de datos
      nEle=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce el numero de elementos","Entrada de datos",JOptionPane.INFORMATION_MESSAGE));

      if (nEle>0) {
        int [] vector = new int[nEle];
        for (i=0;i<vector.length ;i++ ) {
          vector[i]=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce el valor para el elemento ["+i+"]","Entrada de datos",JOptionPane.INFORMATION_MESSAGE));
        }
        do {
          int seleccion = JOptionPane.showOptionDialog(null,"Desea realizar la busqueda de un elemento?","Entrada de datos",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcion,"Si");
          if (seleccion==0) {
            pos=0;
            eleBus=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce el valor del elemento a buscar","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
            for (i=0;i<vector.length ;i++ ) {
              if (vector[i]!=eleBus && i==vector.length-1) {
                JOptionPane.showMessageDialog(null,"Error, no se encontro el elemento "+eleBus+" dentro del arreglo...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
              }else if (vector[i]==eleBus && i<vector.length) {
                i=vector.length;
                JOptionPane.showMessageDialog(null,"El elemento buscado se localiza en la posicion "+pos,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
                seleccion = JOptionPane.showOptionDialog(null,"Desea remplazar el elemento?","Entrada de datos",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcion,"Si");
                if (seleccion==0)
                  vector[pos]=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el nuevo valor","Entrada de datos",JOptionPane.QUESTION_MESSAE));
              }
              else
                pos++;
            }
            res='S';
          }
          else{
            if (seleccion == 1)
              res='N';
            else
              JOptionPane.showMessageDialog(null,"Error, usted no eligio Si o no.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
          }
        } while (res=='S');
      }
      else {
        JOptionPane.showMessageDialog(null,"Error, el numero de elementos debe ser mayor a cero","Mensaje de error",JOptionPane.ERROR_MESSAGE);
      }
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error","Error",JOptionPane.ERROR_MESSAGE);
    }
    System.exit(0);
  }
}
