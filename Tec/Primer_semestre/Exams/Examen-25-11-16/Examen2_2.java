import javax.swing.*;

public class Examen2_2{
  public static void main(String[] args) {
    Object tipUs []= {"Domestico","Comercial","Industrial","Agricola"};
    Object resp []= {"Si","No"};
    int selec=0,i=1,us;
    double lit,pago,subPa,litTo,pagoTo;
    int sumD=0,sumC=0,sumI=0,sumA=0;
    int sumDl=0,sumCl=0,sumIl=0,sumAl=0;

    try {
      while (selec==0) {
        lit=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de litros consumidos por el usuario #"+i,"Entrada de datos",JOptionPane.QUESTION_MESSAGE));
        if (lit > 0) {
          us=JOptionPane.showOptionDialog(null,"Seleccione el tipo de usuario","Entrada de datos",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,tipUs,"Domestico");

          switch (us) {
            case 0:
              subPa=150.0;
              if (lit > 5000 ) {
                if (lit-5000 >0 && lit-5000 <=15000) {
                  subPa=(lit-5000)*0.44+150;
                }
                if (lit-20000>0) {
                  subPa=15000*0.44+(lit-20000)*0.88;
                }
              }
              pago=subPa;
              sumD+=pago;
              sumDl+=lit;

              JOptionPane.showMessageDialog(null,"Cuota minima: $"+150+
                                                  "\nCuota de agua mensual excedente: $"+(pago-150)+
                                                  "\nTotal a pagar: $"+pago,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
            break;
            case 1:
              subPa=375.0;
              if (lit > 5000 ) {
                if (lit-5000 >0 && lit-5000 <=20000) {
                  subPa=(lit-5000)*0.95+375;
                }
                if (lit-20000>0) {
                  subPa=15000*0.95+(lit-20000)*1.9;
                }
              }
              pago=subPa;
              sumC+=pago;
              sumCl+=lit;
              JOptionPane.showMessageDialog(null,"Cuota minima: $"+375+
                                                  "\nCuota de agua mensual excedente: $"+(pago-375)+
                                                  "\nTotal a pagar: $"+pago,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
            break;
            case 2:
              subPa=825.0;
              if (lit > 5000 ) {
                if (lit-5000 >0 && lit-5000 <=20000) {
                  subPa=(lit-5000)*1.75+825;
                }
                if (lit-20000>0) {
                  subPa=15000*1.75+(lit-20000)*3.5;
                }
              }
              pago=subPa;
              sumI+=pago;
              sumCl+=lit;
              JOptionPane.showMessageDialog(null,"Cuota minima: $"+825+
                                                  "\nCuota de agua mensual excedente: $"+(pago-825)+
                                                  "\nTotal a pagar: $"+pago,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
            break;
            case 3:
              subPa=68.0;
              if (lit > 5000 ) {
                if (lit-5000 >0 && lit-5000 <=20000) {
                  subPa=(lit-5000)*0.18+68;
                }
                if (lit-20000>0) {
                  subPa+=15000*0.18+(lit-20000)*0.36;
                }
              }
              pago=subPa;
              sumA+=pago;
              sumAl+=lit;
              JOptionPane.showMessageDialog(null,"Cuota minima: $"+68+
                                                  "\nCuota de agua mensual excedente: $"+(pago-68)+
                                                  "\nTotal a pagar: $"+pago,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
            break;
          }

          i++;

        }else{
          JOptionPane.showMessageDialog(null,"Error, la cantidad de litros debe ser mayor a cero","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }
        selec=JOptionPane.showOptionDialog(null,"Desea seguir ingresando datos?","Continuar?",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,resp,"Si");
      }

      int sumaTotal=sumD+sumC+sumI+sumA;

      if (sumaTotal>0) {
        JOptionPane.showMessageDialog(null,"Gasto total de agua por tipos de usuario: "+
                                            "\n-Domestico: "+sumDl+
                                            "\n-Comercial: "+sumCl+
                                            "\n-Industrial: "+sumIl+
                                            "\n-Agricola: "+sumAl,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null,"Cobro total por tipos de usuario: "+
                                            "\n-Domestico: $"+sumD+
                                            "\n-Comercial: $"+sumC+
                                            "\n-Industrial: $"+sumI+
                                            "\n-Agricola: $"+sumA,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null,"Total cobrado: $"+sumaTotal,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
      }else {
        JOptionPane.showMessageDialog(null,"Error, no se ingreso ningun dato...","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
      }

    }catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error al introducir los datos","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
    }
    System.exit(0);
  }
}
