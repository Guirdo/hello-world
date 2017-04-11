import javax.swing.*;

public class Calciu{
  public static void main(String[] args) {
    int selec;
    int [] nums = {1,2,3,4,5};

    selec= Integer.parseInt(JOptionPane.showInputDialog(null,"Elige: ","sEleccion",JOptionPane.QUESTION_MESSAGE));
    JOptionPane.showMessageDialog(null,"Selecion"+nums[selec],"Salida",JOptionPane.INFORMATION_MESSAGE);
  }
}
