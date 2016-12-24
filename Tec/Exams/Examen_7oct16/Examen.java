import javax.swing.*;

public class Examen{
  public static void main(String[] args) {

    int df=0,rg=0,st=0,ex=0,cal,nCal,i;
    double dfp,rgP,stP,exP;

    try {
       do{
        nCal=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce:","Entrada",JOptionPane.INFORMATION_MESSAGE));
        if (nCal<=0) {
          JOptionPane.showMessageDialog(null,"Error","Error...",JOptionPane.QUESTION_MESSAGE);
        }
      }while (nCal<0);

      for (i=1;i<=nCal ;i++ ) {
        cal = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese cal #"+i,"Entrada",JOptionPane.QUESTION_MESSAGE));
      }
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error","Error",JOptionPane.ERROR_MESSAGE);
    }
    System.exit(0);
  }
}
