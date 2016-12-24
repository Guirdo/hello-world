import javax.swing.*;

public class IfElseApp2{
  public static void main(String[] args) {
    int num1,num2,res;

    try {
      num1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el primer valor: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));
      num2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el segundo valor: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error...","Error...",JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
    System.exit(0);
  }
}
