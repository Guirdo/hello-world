import javax.swing.*;

public class DoWhile2{
  public static void main(String[] args) {
    int num,numTemp,digitos=0;
    try {
      num=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero: ","Entrada",JOptionPane.INFORMATION_MESSAGE));
      if (num>=0) {
        numTemp=num;
      }else {
        numTemp=num;
        num=num*-1;
      }
      do {
        num/=10;
        digitos++;
      } while (num>0);
      JOptionPane.showMessageDialog(null,"El numero "+numTemp+" tiene "+digitos+" digitos","Mensaje",JOptionPane.INFORMATION_MESSAGE);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error","Error",JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
    System.exit(0);
  }
}
