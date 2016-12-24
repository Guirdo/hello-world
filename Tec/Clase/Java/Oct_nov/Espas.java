import javax.swing.*;
import java.util.*;

public class Espas{
  public static void main(String[] args) {

    String test;

    test=JOptionPane.showInputDialog(null,"Ingrese una frase: ","Entrada",JOptionPane.QUESTION_MESSAGE);
    
    StringTokenizer st = new StringTokenizer(test);
    JOptionPane.showMessageDialog(null,"El numero de palabras es: "+st.countTokens());

    System.exit(0);
  }
}
