import javax.swin.*;

public class ArregloSacar{
  public static void main(String[] args) {
    int num,ren,col,suma=0;

    ren = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de renglones","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
    col = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de columnas","Entrada de datos",JOptionPane.QUESTION_MESSAGE));

    if (ren > 0 && col > 0) {
      int reng[]=new int[ren];
      int colu[]=new int[col];
      int tabla[][]=new int[ren][col];

      for (int i = 0;i<ren ;i++ ) {
        for (int j=0;j<col ;j++ ) {
          tabla[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero en la posicion["+"]"+"["+"]","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
        }
      }

      for (j=0;i<col ;j++ ) {
        for (i=0;i<ren ;i++ ) {
          
        }
      }
    }
  }
}
