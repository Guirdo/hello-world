import javax.swing.*;

class Alumno{
  public String nombre;
  public int cal1,cal2,cal3,prom;
}

public class DemoRegis1{
  public static void main(String[] args) {

    int nAlum,cal,sumaCal=0;
    int mProm,pProm,sumaProm=0,promGen;
    String nomAlum,salDa="";
    try {
      nAlum=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de alumnos","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
      if (nAlum>0) {
        Alumno arreAlums[]=new Alumno[nAlum];
        for (int i=0;i<arreAlums.length ;i++ )
          arreAlums[i]=new Alumno();
        for (int j=0;j<nAlum ;j++ ) {
          do {

          } while (
          
          );
        }
      }
    }catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error al ingresar datos...","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
    }
  }
}
