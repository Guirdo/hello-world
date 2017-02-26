import javax.swing.*;

class DatosVendedor{
  String nombreVen;
  double suelMen,venMen,comi,suelTotal;
}

public class Examen3_2{
  public static void main(String[] args) {
    int nEmple=0;
    String nombre,salida="";
    double suelMen,venMen,suelMenTo=0,venMenTo=0,sumComi=0,promComi;

    do {
      try {
        nEmple=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de empleados","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
      }catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Error, el dato debe ser numerico","Mensaje de error",JOptionPane.ERROR_MESSAGE);
      }
      if (nEmple<=0)
        JOptionPane.showMessageDialog(null,"Error, debe ingresar por lo menos un empleado","Mensaje de error",JOptionPane.ERROR_MESSAGE);
    } while (nEmple<=0);

    DatosVendedor lista[]=new DatosVendedor[nEmple];

    for (int i=0;i<nEmple ;i++ )
      lista[i]=new DatosVendedor();

    for (int i=0;i<nEmple ;i++ ) {

      do {
        nombre=JOptionPane.showInputDialog(null,"Ingrese el nombre del empleado #"+(i+1),"Entrada de datos",JOptionPane.QUESTION_MESSAGE);
        if (!nombre.isEmpty())
          lista[i].nombreVen=nombre;
        else
          JOptionPane.showMessageDialog(null,"Error, ingrese por lo menos un caracter...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
      } while (nombre.isEmpty());

      do {
        suelMen=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el sueldo mensual de empleado #"+(i+1),"Entrada de datos",JOptionPane.QUESTION_MESSAGE));
        if (suelMen>0)
          lista[i].suelMen=suelMen;
        else
          JOptionPane.showMessageDialog(null,"Error, el sueldo debe ser mayor a cero...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
      } while (suelMen<=0);

      do {
        venMen=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese la venta mensual del empleado #"+(i+1),"Entrada de datos",JOptionPane.QUESTION_MESSAGE));
        if (venMen>0)
          lista[i].venMen=venMen;
        else
          JOptionPane.showMessageDialog(null,"Error, el sueldo debe ser mayor a cero...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
      } while (venMen<=0);

      if (venMen<5000)
        lista[i].suelTotal=suelMen;
      if (venMen>=5000 && venMen<10000) {
        lista[i].comi=venMen*0.075;
        lista[i].suelTotal=lista[i].comi+suelMen;
      }if (venMen>=10000) {
        lista[i].comi=venMen*0.15;
        lista[i].suelTotal=lista[i].comi+suelMen;
      }

      suelMenTo+=suelMen;
      venMenTo+=venMen;
      sumComi+=lista[i].comi;

      salida+="Nombre: "+nombre+"\n"+
              "Sueldo Mensual: $"+suelMen+"\n"+
              "Venta mensual: $"+venMen+"\n"+
              "Comision: $"+lista[i].comi+"\n"+
              "Sueldo total: $"+lista[i].suelTotal+"\n\n";

    }//for para la obtencion de datos

    promComi=sumComi/nEmple;

    JOptionPane.showMessageDialog(null,salida,"Resultado",JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null,"Total de sueldos mensuales: $"+suelMenTo+"\n"+
                                        "Total de ventas mensuales: $"+venMenTo+"\n"+
                                        "Promedio de comisiones: $"+promComi+"\n","Salida de datos",JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
  }
}
