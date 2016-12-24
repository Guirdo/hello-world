import javax.swing.*;

public class Prog3_3{
  public static void main(String[] args) {
    double euros,pesos,yen,cambioP,cambioY;

    try {
      euros = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduzca la cantidad de euros: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));
      cambioP = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduzca el tipo de cambio para el peso: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));
      cambioY = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduzca el tipo de cambio para el yen: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));

      pesos = euros*cambioP;
      yen = euros*cambioY;

      JOptionPane.showMessageDialog(null,euros+" euros en pesos: $"+pesos
                                    +"\n"+euros+" euros en yenes: "+yen,"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error, Introduzca valores numericos...","Error...",JOptionPane.ERROR_MESSAGE);
    }
    System.exit(0);
  }
}
