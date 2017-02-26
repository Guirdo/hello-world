import javax.swing.*;

public class DetMayMen{

  public static String detMay(int x,int y,int z){
    String mayor;

    if (x == y && y == z)
      mayor="Todos son iguales";
    else{
      if (x>y&&x>z)
        mayor=""+x;
      else if (y>z)
        mayor=""+y;
      else
        mayor=""+z;
    }
    return mayor;
  }

  public static String detMen(int x,int y,int z){
    String menor;

    if (x == y && y == z)
      menor="Todos son iguales";
    else{
      if (x<y&&x<z)
        menor=""+x;
      else if (y<z)
        menor=""+y;
      else
        menor=""+z;
    }
    return menor;
  }

  public static void main(String[] args) {
    int x,y,z;

    x=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero: ","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
    y=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero: ","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
    z=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero: ","Entrada de datos",JOptionPane.QUESTION_MESSAGE));

    JOptionPane.showMessageDialog(null,"El numero mayor es: "+detMay(x,y,z)+"\nEl numero menor es: "+detMen(x,y,z),"Salida",JOptionPane.INFORMATION_MESSAGE);
  }
}
