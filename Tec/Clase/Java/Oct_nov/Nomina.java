import javax.swing.*;

public class Nomina{
  public static void main(String[] args) {
    int cSueldo,i=1,s1k_3k=0,sMay3k=0;
    double tSuel=0,sueldo;

    try {
      cSueldo=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce la cantidad de sueldos a capturar","Entrada de datos...",JOptionPane.INFORMATION_MESSAGE));
      if (cSueldo>0) {
        while (i<=cSueldo) {
          sueldo = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduce el sueldo #"+i,"Entrada de datos...",JOptionPane.INFORMATION_MESSAGE));
          if (sueldo >= 1000.00 && sueldo <= 5000.00) {
            if (sueldo >= 1000.00 && sueldo <=3000.00) {
              s1k_3k++;
            }else {
              sMay3k++;
            }
            tSuel += sueldo;
            i++;
          }else {
            JOptionPane.showMessageDialog(null,"Error el sueldo no es valido (1000 - 5000)","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
          }
        }//While
        JOptionPane.showMessageDialog(null,"-Empleados que cobran más de 1000 y 3000 pesos: "+s1k_3k+
                                            "\n-Empleados que cobran más de 3000 pesos: "+sMay3k+"\nImporte total de la nomina: $"+tSuel,"Resultado...",JOptionPane.INFORMATION_MESSAGE);
      }else {
        JOptionPane.showMessageDialog(null,"Error el numero de sueldos debe ser mayor a 0","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
      }
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error al introducir datos no numericos...","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
    System.exit(0);
  }
}
