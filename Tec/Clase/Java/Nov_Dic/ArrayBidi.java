import javax.swing.*;

public class ArrayBidi{
  public static void main(String[] args) {
    int nFilas,nCol,opcion,nFil,nBut;
    String nombre="";
    Object respuesta[]={"Si","No"};

    try {
      nFilas=Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de filas","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
      nCol=Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de butacas por fila","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
      if (nFilas > 0 && nCol > 0) {
        String[][]asistentes=new String[nFilas][nCol];
        //Inicializa los elementos en el arreglo con cadenas vacias
        for (int i=0;i<nFilas ;i++ )
          for (int j=0;j<nCol ;j++ )
            asistentes[i][j]="";
        do {//Presentacion del menu
          opcion=Integer.parseInt(JOptionPane.showInputDialog(null,"[1]Reservar\n[2]Cancelar\n[3]Visualizar\n[4]Salir\nSeleccione la opcion deseada","Menu principal",JOptionPane.QUESTION_MESSAGE));
          switch (opcion) {
            case 1:
              nFil=Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de fila","Reservacion",JOptionPane.QUESTION_MESSAGE));
              nBut=Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de la butaca","Reservacion",JOptionPane.QUESTION_MESSAGE));
              if (nFil >= 0 && nFil < nFilas && nBut >= 0 && nBut <nCol) {
                if (asistentes[nFil][nBut].isEmpty()) {
                  do {
                    nombre=JOptionPane.showInputDialog(null,"Nombre de la persona","Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                  } while (nombres.isEmpty());
                  asistentes[nFil][nBut]=nombre;
                }else
                  JOptionPane.showMessageDialog(null,"Error reservacion ocupada","Mensaje de error",JOptionPane.ERROR_MESSAGE);
              }else
                JOptionPane.showMessageDialog(null,"Error la butaca a reservar no existe","Mensaje de error",JOptionPane.ERROR_MESSAGE);
            break;
            case 2:
            nFil=Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de fila","Cancelacion",JOptionPane.QUESTION_MESSAGE));
            nBut=Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de la butaca","Cancelacion",JOptionPane.QUESTION_MESSAGE));
            if (nFil >= 0 && nFil < nFilas && nBut >= 0 && nBut <nCol){
              int seleccion = JOptionPane.showOptionDialog(null,"Butaca reservada a nombre de "+asistentes[nFil][nBut]+"\nDesea realizar la cancelacion...","Cancelacion",JOptionPane.QUESTION_MESSAGE);
            }
            break;
          }

        } while ();
      }
    }catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
    }
    System.exit(0);
  }
}
