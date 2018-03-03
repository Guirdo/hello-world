import javax.swing.*;

public class WhileApp1{
  public static void main(String[] args) {
    int sumC=0,nCal,cal,prom,i=1;

    try {
      nCal = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce el numero de calificaciones a capturar: ","Entrada de datos",JOptionPane.QUESTION_MESSAGE));

      if (nCal > 0) {
        while (i<=nCal) {
          cal = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la calificacion #"+1,"Entrada de datos",JOptionPane.QUESTION_MESSAGE));
          if (cal >= 0 && cal <= 100) {
            sumC=sumC+cal;
            i++;
          }else {
            JOptionPane.showMessageDialog(null,"Error al introducir la calificacion...","Error...",JOptionPane.ERROR_MESSAGE);
          }
          prom = sumC/nCal;
          JOptionPane.showMessageDialog(null,"El promedio de las "+nCal+"calificaciones es de: "+prom,"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
        }
      }else {
        JOptionPane.showMessageDialog(null,"Error, el numero de calificaciones debe ser mayor a cero...","Error...",JOptionPane.ERROR_MESSAGE);
      }
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error al introducir los datos...","Error...",JOptionPane.ERROR_MESSAGE);
    }
    System.exit(0);
  }
}
