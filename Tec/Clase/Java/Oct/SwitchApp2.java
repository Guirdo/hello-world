import javax.swing.*;

public class SwitchApp2{
  public static void main(String[] args) {
    String cadena;

    cadena = JOptionPane.showInputDialog(null,"Introduzca un caracter: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE);
    switch (cadena.charAt(0)) {
      case 'a': case 'A':
        JOptionPane.showMessageDialog(null,"Excelente","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
      break;
      case 'b': case 'B':
        JOptionPane.showMessageDialog(null,"Bueno","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
      break;
      case 'c': case 'C':
        JOptionPane.showMessageDialog(null,"Regular","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
      break;
      case 'd': case 'D':
        JOptionPane.showMessageDialog(null,"Malo","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
      break;
      case 'e': case 'E':
        JOptionPane.showMessageDialog(null,"Pesimo","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
      break;
      default:
        JOptionPane.showMessageDialog(null,"El caracter es invalido...","Error...",JOptionPane.ERROR_MESSAGE);
    }
    System.exit(0);
  }
}
