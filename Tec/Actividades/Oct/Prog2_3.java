import javax.swing.*;

public class Prog2_3{
  public static void main(String[] args) {
    int seg;
    double hrs,min;

    try {
      //Entrada de datos
      seg = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de segundos: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));

      hrs = (1.0/3600.0)*seg;
      min = (1.0/60.0)*seg;

      //Salida de datos
      JOptionPane.showMessageDialog(null,seg+" segundo en horas: "+hrs
                                    +"\n"+seg+" segundos a minutos: "+min
                                    +"\n"+seg+" segundos a segundo: "+seg,"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
    }
    catch (Exception e) {
      System.out.println("Error: introduzca valores numericos...");
    }
    System.exit(0);
  }
}
