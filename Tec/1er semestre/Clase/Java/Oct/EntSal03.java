import javax.swing.*;//Prog1_1

public class EntSal03{
  public static void main(String[] args) {
    String nombrePro;
    int canPro;
    double pre;

    try {
      //Entrada de datos
      nombrePro = JOptionPane.showInputDialog(null,"Nombre del producto: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE);
      canPro = Integer.parseInt(JOptionPane.showInputDialog(null,"Cantidad del producto: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));
      pre = Double.parseDouble(JOptionPane.showInputDialog(null,"Precio del producto:  ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));

      //Salida de datos
      JOptionPane.showMessageDialog(null,"Nombre del producto: "+nombrePro
                                    +"\nCantidad del producto: "+canPro
                                    +"\nPrecio del producto: "+pre
                                    +"\nCantidad a pagar incluyendo IVA: $"
                                    +Math.rint(canPro*pre*1.16),"Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error...");
    }
    System.exit(0);
  }
}
