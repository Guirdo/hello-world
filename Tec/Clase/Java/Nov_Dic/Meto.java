import javax.swing.*;

public class DetBisi{
  public static boolean esBisi(int ano){
    if (ano%4 == 0 && ano%100 != 0 || ano%400 == 0)
      return true;
    else
      return false;
  }

  public static void main(String[] args) {
    int ano;

    do {
      ano=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el año","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
      if (ano < 1000 || ano > 9999) {
        JOptionPane.showMessageDialog(null,"Error","Error",JOptionPane.ERROR_MESSAGE);
      }
    } while (ano < 1000 || ano > 9999);

    if (esBisi(ano)) {
      JOptionPane.showMessageDialog(null,"El año "+ano+" es bisiesto","Salida",JOptionPane.INFORMATION_MESSAGE);
    }else {
      JOptionPane.showMessageDialog(null,"El año "+ano+" no es bisiesto","Salida",JOptionPane.INFORMATION_MESSAGE);
    }

    System.exit(0);
  }
}
