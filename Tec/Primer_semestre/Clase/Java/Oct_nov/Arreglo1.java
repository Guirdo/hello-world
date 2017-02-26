import javax.swing.*;

public class Arreglo1{
  public static void main(String[] args) {
    int nEl,cal,i,suma=0;
    String nombre;

    nEl=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de alumnos: ","Entrada de datos",JOptionPane.QUESTION_MESSAGE));

    if (nEl>0) {
      int[] cals=new int[nEl];
      String[] nombres=new String[nEl];

      for (i=0;i<nEl ;i++ ) {
        do {
          nombre=JOptionPane.showInputDialog(null,"Ingrese el nombre del alumno #"+i,"Entrada de datos",JOptionPane.QUESTION_MESSAGE);
          if (nombre.isEmpty())
            JOptionPane.showMessageDialog(null,"Error, debe ingresar por lo menos un caracter","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
          else
              nombres[i]=nombre;
        } while (nombre.isEmpty());

        do {
          cal=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la calificacion del alumno #"+i,"Entrada de datos...",JOptionPane.QUESTION_MESSAGE));
          if (cal <0 || cal > 100)
            JOptionPane.showMessageDialog(null,"Error, debe ingresar una calificacion valida...","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
          else
            cals[i]=cal;
        } while (cal <0 || cal > 100);
    }
    for (int f=0;f<cals.length ;f++ )
      suma+=cals[f];

    int prom = suma/cals.length;

    JOptionPane.showMessageDialog(null,"El promedio global es de: "+prom,"Resultado",JOptionPane.INFORMATION_MESSAGE);
    }
    System.exit(0);
  }
}
