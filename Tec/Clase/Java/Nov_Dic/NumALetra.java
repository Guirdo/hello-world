import javax.swing.*;

public class NumALetra{

  public static String convertir(int num){
    String salida="";
    if (num>=1000) {
      salida+=""+(num/1000)+" millares,";
      num=num-((num/1000)*1000);
    }if (num>=100) {
      salida+=" "+(num/100)+" centenas,";
      num=num-((num/100)*100);
    }if (num>=10) {
      salida+=" "+(num/10)+" decenas,";
      num=num-((num/10)*10);
    }if (num>=0)
      salida+=" "+num+" unidades.";

    return salida;
  }

  public static void main(String[] args) {
    int num;

    do {
      num=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero entero","Entrada",JOptionPane.QUESTION_MESSAGE));
    } while (num<=0);

    JOptionPane.showMessageDialog(null,convertir(num),"Resultado",JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
  }
}
