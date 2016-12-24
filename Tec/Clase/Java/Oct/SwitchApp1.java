import javax.swing.*;

public class SwitchApp1{
  public static void main(String[] args) {
    int num;

    try {
      num = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero entero","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));
      if (num > 0) {
        switch (num % 10) {
          case 2: case 5: case 8:
            JOptionPane.showMessageDialog(null,"EL cuadrado del numero es: "+num*num,"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
          break;
          case 4: case 7: case 9:
            JOptionPane.showMessageDialog(null,"El numero multiplicado por 5 es: "+num*5,"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
          break;
          default:
            JOptionPane.showMessageDialog(null,"El numero introducido es: "+num,"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
        }//switch
      }else {
        JOptionPane.showMessageDialog(null,"El numero debe ser mayor a cero...","Error...",JOptionPane.ERROR_MESSAGE);
      }
    }//try
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error: introduzca valores numericos...","Error...",JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
    System.exit(0);
  }
}
