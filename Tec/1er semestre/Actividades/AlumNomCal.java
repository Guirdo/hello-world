import javax.swing.*;

public class AlumNomCal{
  public static void main(String[] args) {
    String nom,sal="",debProm="",arrProm="",nomPeor="",nomMej="";
    int num,nCal,cal,prom,promG,sum=0,j,peor=0,mejor=0;

    do {
      num = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de alumnos","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
    } while (num<=0);

    do {
      nCal=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de calificaciones","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
    } while (nCal<=0);

    String nombres[]=new String[num];
    int calis[][]=new int[num][nCal+1];

    for (int i=0;i<nombres.length ;i++ ) {
      do {
        nom=JOptionPane.showInputDialog(null,"Ingrese el nombre del alumno #"+(i+1),"Entrada de datos",JOptionPane.INFORMATION_MESSAGE);
        if (!nom.equals(""))
          nombres[i]=nom;
      } while (nom.equals(""));

      for (j=0;j<nCal+1 ;j++ ) {
        if (j<nCal) {

          do {
            cal=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la calificacion #"+(j+1),"Entrada de datos",JOptionPane.QUESTION_MESSAGE));
            if (cal >= 0 && cal <= 100) {
              calis[i][j]=cal;
              sum+=cal;
            }
          } while (cal < 0 || cal > 100);
        }else {
          prom=sum/nCal;
          calis[i][j]=prom;
        }
      }//for J
      sum=0;
    }//for I

    for (int k=0;k<nombres.length ;k++ )
      sum+=calis[k][nCal];

    promG=sum/num;

    for (int l=0;l<nombres.length ;l++ ) {
      if (calis[l][nCal]<promG)
        debProm+="- "+nombres[l]+"\n";
      else
        arrProm+="- "+nombres[l]+"\n";
    }


    for (int m=0;m<nombres.length ;m++ ) {
      if (m==0) {
        peor=calis[m][nCal];
        mejor=calis[m][nCal];
      }
      else {
        if (peor > calis[m][nCal])
          peor=calis[m][nCal];
        if (mejor < calis[m][nCal])
          mejor=calis[m][nCal];
      }
    }

    for (int n=0;n<nombres.length ;n++ ) {
      if (peor==calis[n][nCal])
        nomPeor+="- "+nombres[n]+"\n";
      if (mejor == calis[n][nCal])
        nomMej+="- "+nombres[n]+"\n";
    }

    JOptionPane.showMessageDialog(null,"La mejor calificacion\n"+nomMej+
                                        "La peor calificacion\n"+nomPeor,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);

    JOptionPane.showMessageDialog(null,"Por debajo del promedio general\n"+debProm+
                                        "Por arriba del promedio general\n"+arrProm,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);

    /*
    for (int t=0;t<nombres.length ;t++ ) {
      sal+=nombres[t]+" ";
      for (j=0;j<nCal+1 ;j++ ) {
        sal+=" "+calis[t][j];
      }
      sal+=" \n";
    }

    JOptionPane.showMessageDialog(null,sal,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
    */

    System.exit(0);

  }
}
