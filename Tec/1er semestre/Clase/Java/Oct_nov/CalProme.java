import javax.swing.*;

public class CalProme{
  public static void main(String[] args) {
    int suma=0,cant=0,valor=0,prome;
    do {
      try {
        valor = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un valor (0 para finalizar): ","Entrada de datos...",JOptionPane.INFORMATION_MESSAGE));
        if (valor != 0) {
          suma+=valor;
          cant++;
        }
      }
      catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Error...","Error...",JOptionPane.ERROR_MESSAGE);
      }
    } while (valor!=0);
    if (cant != 0) {
      prome=suma/cant;
      JOptionPane.showMessageDialog(null,"El promedio de los valores ingresados es: "+prome,"Resultado...",JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
    }
  }
}
