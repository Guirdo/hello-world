import java.util.Random;
import javax.swing.*;

public class PiePaTi{
  public static void main(String[] args) {

    Random aleatorio = new Random();
    double opcJava=aleatorio.nextDouble()*(2-0+1)+0;
    String[] opcs={"Piedra","Papel","Tijeras"};
    int opcUs,conti;

    JOptionPane.showMessageDialog(null,"¡Bienvenido al juego del\n Piedra, Papel o Tijeras!");

    do{
      JOptionPane.showOptionDialog(null,"Escoge entre: ","Elige",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcs,"Piedra");

      conti=JOptionPane.showOptionDialog(null,"¿Qué dices, la revancha?","¿Ya te vas?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
    }while(conti==0);


  }

}
