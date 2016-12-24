import javax.swing.*;

class Anadir{
  public  String producto,formPa;
  public int cantidad;
  public double valor,costTo,costBru;

  public double darCostoTotal(String formPa, double costo){
    double total=0.0;

    if (formPa.equals("50% anticipado"))
      total=costo*0.95;
    else if (formPa.equals("Contado"))
      total=costo*0.9;
    else if (formPa.equals("30 dias"))
      total=costo*0.97;
    else if (formPa.equals("Credito"))
      total=costo*1.05;

    return total;
  }
}

public class CentroCump{

  public static void main(String[] args) {
    int selec,num,cant;
    double costo;
    String nombre,salida="";
    String []menu1={"Nuevo presupuesto","Salir"};
    String []menu2={"50% anticipado","Contado","30 dias","Credito"};
    Anadir met=new Anadir();

    do {
      selec = JOptionPane.showOptionDialog(null,"Seleccion la accion a realizar","Menu principal",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,menu1,null);

      if (selec==0) {
        do {
          num=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de productos a ingresar","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
          if (num<=0)
            JOptionPane.showMessageDialog(null,"Error, el numero de elementos debe ser mayor a cero","Entrada de datos",JOptionPane.QUESTION_MESSAGE);
        } while (num<=0);

        Anadir []lista=new Anadir[num];

        for (int i=0;i<num ;i++ )
          lista[i]=new Anadir();

        for (int i=0;i<num ;i++ ) {

          do {
            nombre=JOptionPane.showInputDialog(null,"Ingrese el nombre del producto","Entrada de datos",JOptionPane.QUESTION_MESSAGE);
            if (!nombre.isEmpty())
              lista[i].producto=nombre;
            else
                JOptionPane.showMessageDialog(null,"Error, ingrese por lo menos un caracter","Mensaje de error",JOptionPane.ERROR_MESSAGE);
          } while (nombre.isEmpty());

          do {
            costo=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el costo del procuto","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
            if (costo>0)
              lista[i].valor=costo;
            else
              JOptionPane.showMessageDialog(null,"Error, el costo debe ser mayor a cero","Mensaje de error",JOptionPane.ERROR_MESSAGE);
          } while (costo<=0);

          do {
            cant=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad a comprar","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
            if (cant>0)
              lista[i].cantidad=cant;
            else
              JOptionPane.showMessageDialog(null,"Error, ingrese una cantidad mayor a cero","Mensaje de error",JOptionPane.ERROR_MESSAGE);
          } while (cant<=0);

          Object men2=JOptionPane.showInputDialog(null,"Seleccione la forma de pago","Entrada de datos",JOptionPane.QUESTION_MESSAGE,null,menu2,null);
          lista[i].formPa=men2.toString();

          lista[i].costBru=costo*cant;
          lista[i].costTo=met.darCostoTotal(lista[i].formPa,lista[i].costBru);

        }//for principal

        for (int i=0;i<num ;i++ ) {
          salida+="Nombre del producto: "+lista[i].producto+"\n"+
                  "Cantidad a comprar: "+lista[i].cantidad+"\n"+
                  "Costo por unidad: "+lista[i].valor+"\n"+
                  "Forma de pago: "+lista[i].formPa+"\n"+
                  "Costo bruto: "+lista[i].costBru+"\n"+
                  "Costo total: "+lista[i].costTo+"\n\n";
        }

      }
    } while (selec==0);
    System.exit(0);
  }
}
