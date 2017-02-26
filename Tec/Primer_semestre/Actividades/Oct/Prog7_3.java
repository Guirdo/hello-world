import javax.swing.*;

public class Prog7_3{
  public static void main(String[] args) {
    double radio,peri,area;
    final double PI = 3.1415926536;

    try {
      //Entrada de datos
      radio = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduzca la medida del radio: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));

      //Operaciones
      peri = 2*PI*radio;
      area = PI*Math.pow(radio,2);

      //Salida de datos
      JOptionPane.showMessageDialog(null,"Perimetro: "+peri+"\nArea: "+area,"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error: introduzca valores numericos...","Error...",JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
    System.exit(0);
  }
}
