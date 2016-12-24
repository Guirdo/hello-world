import javax.swing.*;

public class NumPrim{

  public static boolean esPrimo(int num){
    int con=0;
    boolean es;

    if (num!=0) {

      if (num<0)
        num=-num;

      for (int i=1;i<=num ;i++ )
        if (num%i==0)
          con++;

      if (con ==1 || con ==2)
        es=true;
      else
        es=false;

    }else
      es=false;

    return es;  

  }

  public static void main(String[] args) {
    int num;

    num=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero","Entrada de datos",JOptionPane.QUESTION_MESSAGE));

    if (esPrimo(num))
      JOptionPane.showMessageDialog(null,"El numero es primo","Resultado",JOptionPane.INFORMATION_MESSAGE);
    else
      JOptionPane.showMessageDialog(null,"El numero no es primo","Resultado",JOptionPane.INFORMATION_MESSAGE);
  }
}
