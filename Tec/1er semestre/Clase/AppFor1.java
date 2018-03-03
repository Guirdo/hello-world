import javax.swing.*;

public class AppFor1{
  public static void main(String[] args) {
    int i,num;
    String salida = "";

    try {
      //Entrada de datos
      num = Integer.parseInt(JOptionPane.showInputDialog(null,"Numero: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));

      if (num > 0) {
        for (i = 1;i<=num ;i++ ) {
          if (i%2 != 0) {
            salida = salida + i + ",";
          }
        }
        JOptionPane.showMessageDialog(null,salida,"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
      }else{
        JOptionPane.showMessageDialog(null,"Error: el numero debe ser mayor a cero...","Error...",JOptionPane.ERROR_MESSAGE);
      }
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error: el numero debe ser mayor a cero...","Error...",JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
    System.exit(0);
  }
}
