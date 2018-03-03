import javax.swing.*;

public class Prog6_3{
  public static void main(String[] args) {
    double est,peso,imc;

    try {
      est = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduzca su altura en metros: ","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
      peso = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduzca su peso en kg: ","Entrada de datos",JOptionPane.QUESTION_MESSAGE));

      //Operaciones
      imc = peso/Math.pow(est,2);

      //Salida de datos
      JOptionPane.showMessageDialog(null,"Su IMC es de: "+imc,"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error: introduzca valores numericos...","Error...",JOptionPane.ERROR_MESSAGE);
    }
    System.exit(0);
  }
}
