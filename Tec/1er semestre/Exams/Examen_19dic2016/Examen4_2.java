import javax.swing.*;

public class Examen4_2{
  public static double convierteEuros(double euros,String moneda,double tipCambio){
    double conversion=0;
    if (moneda.equals("Dolar")) {
      conversion=euros*tipCambio;
    }else if (moneda.equals("Libra esterlina")) {
      conversion=euros*tipCambio;
    }else if (moneda.equals("Yen")) {
      conversion=euros*tipCambio;
    }else if (moneda.equals("Franco Suizo")) {
      conversion=euros*tipCambio;
    }

    return conversion;
  }

  public static void main(String[] args) {
    double euros,tipCambio;
    String moneda;
    String []monedas={"Dolar","Libra esterlina","Yen","Franco Suizo"};

    do {
      euros=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese la cantidad de euros a convertir","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
      if (euros<0) {
        JOptionPane.showMessageDialog(null,"Error, la cantidad de euros debe ser mayor a cero","Mensaje de error",JOptionPane.ERROR_MESSAGE);
      }
    } while (euros<0);

    Object selecMon=JOptionPane.showInputDialog(null,"Seleccione la moneda para la conversion","Entrada de datos",JOptionPane.QUESTION_MESSAGE,null,monedas,"Dolar");
    moneda=selecMon.toString();

    do {
      tipCambio=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el tipo de cambio","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
      if (tipCambio<0) {
        JOptionPane.showMessageDialog(null,"Error, la cantidad de euros debe ser mayor a cero","Mensaje de error",JOptionPane.ERROR_MESSAGE);
      }
    } while (tipCambio<0);

    JOptionPane.showMessageDialog(null,"Euros a "+moneda+" es igual a: $"+convierteEuros(euros,moneda,tipCambio),"Salida de datos",JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
  }
}
