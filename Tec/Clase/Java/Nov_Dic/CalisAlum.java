import javax.swing.*;

class Alumno{
  String nombre;
  int prom;
  int []calis=new int[3];
}

public class CalisAlum{
  public static void main(String[] args) {
    int nAlum,sum=0,cal;
    String nombre,sal="";

    nAlum=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de alumnos","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
    if (nAlum>0) {
      Alumno array[]=new Alumno[nAlum];

      //Declaracion de los arreglos de la clase
      for (int i=0;i<nAlum ;i++ )
        array[i]=new Alumno();

      for (int i=0;i<nAlum ;i++ ) {

          do {
            nombre=JOptionPane.showInputDialog(null,"Ingrese el nombre del alumno #"+(i+1),"Entrada de datos",JOptionPane.QUESTION_MESSAGE);
            if (!nombre.isEmpty())
              array[i].nombre=nombre;
            else
              JOptionPane.showMessageDialog(null,"Error, ingrese por lo menos un caracter...","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
          } while (nombre.isEmpty());

          for (int j=0;j<3 ;j++ ) {
            do {
              cal=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la calificacion #"+(j+1),"Entrada de datos",JOptionPane.QUESTION_MESSAGE));
              if (cal >= 0 && cal <=100) {
                array[i].calis[j]=cal;
                sum+=cal;
              }
              else
                JOptionPane.showMessageDialog(null,"Error, ingreso una calificacion no valida","Entrada de datos",JOptionPane.ERROR_MESSAGE);
            } while (cal<0 || cal > 100);
          }

          array[i].prom=sum/3;
          sum=0;
        }

        for (int i=0;i<nAlum ;i++ ) {
          sal+="Nombre: "+array[i].nombre+"\n";

          for (int j=0;j<3 ;j++ )
            sal+="- "+array[i].calis[j]+"\n";

          sal+="-Promedio: "+array[i].prom+"\n\n";
        }

        JOptionPane.showMessageDialog(null,sal,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);

      }else
        JOptionPane.showMessageDialog(null,"Error","Error",JOptionPane.ERROR_MESSAGE);

      System.exit(0);
    }
  }
