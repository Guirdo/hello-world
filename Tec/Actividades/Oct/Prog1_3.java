import javax.swing.*;

public class Prog1_3{
  public static void main(String[] args) {
    double b,h;
    try {
      //Entrada de datos
      b = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduzca la base: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));
      h = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduzca la altura: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));

      //Salida de datos
      JOptionPane.showMessageDialog(null,"Area: "+b*h
                                    +"\nPerimetro: "+((b*2)+(h*2)),"Resultados...",JOptionPane.INFORMATION_MESSAGE);
    }
    catch (Exception e) {
      System.out.println("Error: introduzca valores numericos...");
    }
    System.exit(0);
  }
}
