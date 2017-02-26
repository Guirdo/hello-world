import javax.swing.*;

public class Prog4_3{
  public static void main(String[] args) {
    double preH,suelB,suelNe;
    int hrs;

    try {
      //Entrada de datos
      hrs = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el numero de horas trabajadas: ","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
      preH = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduzca el precio por horas trabajadas: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));

      //Operaciones
      suelB = hrs*preH;
      suelNe = suelB*80/100;

      //Salida de datos
      JOptionPane.showMessageDialog(null,"Sueldo neto del trabajador: "+suelNe,"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error: Introduzca valores numericos...","Error...",JOptionPane.ERROR_MESSAGE);
    }
    System.exit(0);
  }
}
