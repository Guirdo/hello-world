import javax.swing.*;

public class Prog1{
  public static void main(String[] args) {
    int nCa,cal,m70=0,me70=0,i=1;

    try {
      nCa = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de alumnos: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));

      if (nCa > 0) {
        while (i<=nCa) {
          cal = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la calificacion #"+i,"Entrada",JOptionPane.QUESTION_MESSAGE));
          if (cal>=0 && cal <=100) {
            if (cal >= 70) {
              m70++;
            }else {
              me70++;
            }
            i++;
          }else {
            JOptionPane.showMessageDialog(null,"Error","error",JOptionPane.ERROR_MESSAGE);
          }
        }
        JOptionPane.showMessageDialog(null,"Mayores a 70 "+m70+"\nMenores 70: "+me70,"Resultado",JOptionPane.INFORMATION_MESSAGE);
      }else {
        JOptionPane.showMessageDialog(null,"Error","Error",JOptionPane.ERROR_MESSAGE);
      }
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error","Error",JOptionPane.ERROR_MESSAGE);
    }
  }
}
