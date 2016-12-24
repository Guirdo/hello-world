import javax.swing.*;

public class Prog5_3{
  public static void main(String[] args) {
    double cat1,cat2,hipo,peri,area;

    try {
      cat1 = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduzca el primer cateto: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));
      cat2 = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduzca el segundo cateto: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));

      //Operaciones
      hipo = Math.sqrt(Math.pow(cat1,2)+Math.pow(cat2,2));
      area = cat1*cat2/2;
      peri = cat1+cat2+hipo;

      //Salida de datos
      JOptionPane.showMessageDialog(null,"\nHipotenusa: "+hipo
                                    +"\nArea: "+area
                                    +"\nPerimetro: "+peri,"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error: Introduzca valores numericos...");
    }
    System.exit(0);
  }
}
