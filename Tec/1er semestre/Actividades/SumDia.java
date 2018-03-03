import javax.swing.*;

public class SumDia{
  public static void main(String[] args) {
    int nFil,nCol,sum=0;

    nFil=Integer.parseInt(JOptionPane.showInputDialog(null,"Filas","Entrada",JOptionPane.QUESTION_MESSAGE));
    nCol=Integer.parseInt(JOptionPane.showInputDialog(null,"Columnas","Entrada",JOptionPane.QUESTION_MESSAGE));

    if (nFil>0 && nCol>0) {
      int [][] matriz=new int[nFil][nCol];

      for (int i=0;i<nFil ;i++)
        for (int j=0;j<nCol ;j++)
          matriz[i][j]=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero","Entrada",JOptionPane.QUESTION_MESSAGE));

      for (int i=0;i<nFil ;i++ )
        for (int j=0;j<nCol ;j++ )
          if (i==j)
            sum+=matriz[i][j];

            //Suma de filas y de columnas
            //>0,<0,=0,pares,impares,primos
      JOptionPane.showMessageDialog(null,"La suma de la diagonal "+sum,"Salida",JOptionPane.INFORMATION_MESSAGE);

      System.exit(0);
    }
  }
}
