import javax.swing.*;
import java.util.*;

public class BolaFortuna{
  public static void main(String[] args) {

    String[] fortunas = {"Si","No","Tal vez","Si así lo quieres, asi sera","No te lo puedo decir ahora",
                        "Pregunta de nuevo","Ni lo pienses"};
    String pregunta=null;
    int continuar=0,fortu;
    double alea;

    Random bola = new Random();

    JOptionPane.showMessageDialog(null,"¡Bienvenido a la Bola de la fortuna!");

    do {

      pregunta=JOptionPane.showInputDialog(null,"Realiza tu pregunta: ",null);
      JOptionPane.showMessageDialog(null,"*Sacudes la bola*");

      alea=Math.floor(bola.nextDouble()*(6-0+1)-0);
      fortu= (int) alea;

      JOptionPane.showMessageDialog(null,"La bola de la fortuna dice...\n"+fortunas[fortu]);
      alea=0;

      continuar=JOptionPane.showOptionDialog(null,"¿Deseas preguntar de nuevo?","¿Ya te vas?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
    } while (continuar==0);

    JOptionPane.showMessageDialog(null,"¡Hasta luego!");

  }
}
