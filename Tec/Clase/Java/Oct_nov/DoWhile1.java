import javax.swing.*;

public class DoWhile1{
  public static void main(String[] args) {
    int num;

    try {
      do {
        num=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero mayor o igual a 100: ","Entrada",JOptionPane.INFORMATION_MESSAGE));
      } while (num>=100);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error al ingresar datos","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
    System.exit(0);
  }
}
