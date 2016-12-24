import javax.swing.*;

public class PromeIns{
  public static void main(String[] args) {
    int i,j,k,cal,nGru,nAlu;
    int promAlumno = 0, promGru = 0, promGen = 0;
    String salida = "",nombre;

    try {
      nGru = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de grupos: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));

      if (nGru > 0) {
        for (i = 1;i<=nGru ;i++ ) {
          nAlu = Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de alumnos para el grupo ["+i+"]:","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));
          if (nAlu > 0) {
            for (j = 1;j<=nAlu ;j++ ) {
              nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del alumno:","Entrada de datos...",JOptionPane.QUESTION_MESSAGE);
              for (k = 1;k<=3 ;k++ ) {
                cal = Integer.parseInt(JOptionPane.showInputDialog(null,"Calificacion #"+k+":","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));
                if (cal >= 0 && cal <= 100)
                  promAlumno += cal;
                else{
                  JOptionPane.showMessageDialog(null,"Error la Calificacion no es valida...","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
                  k--;
                }
              }
              promAlumno /= 3;
              promGru += promAlumno;
              salida = "\t-Alumno: "+nombre+"\n\t-Promedio: "+promAlumno;
              JOptionPane.showMessageDialog(null,salida,"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
              promAlumno=0;
            }
            promGru /= nAlu;
            promGen += promGru;
            JOptionPane.showMessageDialog(null,"Promedio general del grupo{"+i+"}: "+promGru,"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
            promGru = 0;
          }else{
            JOptionPane.showMessageDialog(null,"Error el numero de alumnos deber ser mayor a cero","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
            i--;
          }
        }
        promGen /= nGru;
        JOptionPane.showMessageDialog(null,"Promedio general de la institucion: "+promGen,"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);

      }else {
        JOptionPane.showMessageDialog(null,"Error, el numero de grupos deber ser mayor a cero","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
      }
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error: introduzca valores numericos...","Error...",JOptionPane.ERROR_MESSAGE);
    }
    System.exit(0);
  }
}
