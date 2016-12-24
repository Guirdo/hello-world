import javax.swing.*;

class Triangulo{
  private int Base,Altura,Lado1,Lado2,Lado3,Perimetro,Area;

  public int darArea(int base,int altu){
    Area=(base*altu)/2;
    return Area;
  }
}

public class Figura{
  public static void main(String[] args) {
    int base,altura;
    Triangulo tria=new Triangulo();

    base=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la base","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
    altura=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la altura","Entrada de datos",JOptionPane.QUESTION_MESSAGE));

    JOptionPane.showMessageDialog(null,"El area del Triangulo es: "+tria.darArea(base,altura),"Salida",JOptionPane.INFORMATION_MESSAGE);
  }
}
