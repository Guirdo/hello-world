import javax.swing.*;

public class SumMatrices{
  public static void main(String[] args) {
    int nFil,nCol;
    String salida="";

    nFil=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de filas","Entrada",JOptionPane.QUESTION_MESSAGE));
    nCol=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de columnas","Entrada",JOptionPane.QUESTION_MESSAGE));

    if (nFil>0 && nCol>0) {
      int [][]matrizA=new int[nFil][nCol];
      int [][]matrizB=new int[nFil][nCol];
      int [][]matrizC=new int[nFil][nCol];

      for (int i=0;i<nFil ;i++ )
        for (int j=0;j<nCol ;j++ )
          matrizA[i][j]=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero","Entrada",JOptionPane.QUESTION_MESSAGE));

      for (int i=0;i<nFil ;i++ )
        for (int j=0;j<nCol ;j++ )
          matrizB[i][j]=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero","Entrada",JOptionPane.QUESTION_MESSAGE));

      for (int i=0;i<nFil ;i++ ) {
        for (int k=0;k<nCol ;k++ ) {
          matrizC[i][k]=matrizA[i][k]+matrizB[i][k];
          salida+="- "+matrizC[i][k]+"\n";
        }
        salida+="\n";
      }

      JOptionPane.showMessageDialog(null,"La suma de las matrices\n"+salida,"salida de datos",JOptionPane.INFORMATION_MESSAGE);



    }
  }
}
