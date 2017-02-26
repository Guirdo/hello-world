import javax.swing.*;

public class ArrayMay{
  public static void main(String[] args) {
    int num,ele,men=0,may=0;
    String pares="",impares="";

    //Cantidad de elementos
    num=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de elementos","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
    if (num>0) {
      int nums[]=new int[num];
      for (int i=0;i<num ;i++ )
        nums[i]=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero","Entrada de datos",JOptionPane.QUESTION_MESSAGE));

      may=nums[0];
      men=nums[0];
      for (int k=0;k<nums.length ;k++ ) {
        if (may < nums[k])
          may=nums[k];
        if (men > nums[k])
          men=nums[k];
        if (nums[k]%2==0)
          pares+="- "+nums[k]+"\n";
        else
          impares+="- "+nums[k]+"\n";
      }
      JOptionPane.showMessageDialog(null,"El numero mayor "+may
                                          +"\nEl numero menor "+men+
                                          "\nLos numeros pares son\n"+pares+
                                          "\nLos numeros impares son\n"+impares,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
    }
  }
}
