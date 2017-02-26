import javax.swing.*;

public class MedTenNoAgru{
  public static double medArit(int numDa){//Este metodo funciona para poblacional y muestral
    double prom,dat=0,sum=0.0;

    for(int i=1; i<=numDa; i++){
      do {
        try{
          dat=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el dato #"+i+": ","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
          if (dat<=0)
            JOptionPane.showMessageDialog(null,"Error, el dato debe ser mayor a cero","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }catch (Exception e) {
          JOptionPane.showMessageDialog(null,"Error, el dato no debe contener caracteres alfabeticos o especiales","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }
      } while (dat<=0);
      sum+=dat;
    }
    prom=sum/numDa;
    return prom;
  }

  public static double medGeo(int numDa){
    double med,dat=0,multi=1.0;

    for (int i=1;i<=numDa ;i++ ) {
      do {
        try{
          dat=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el dato #"+i+": ","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
          if (dat<=0)
            JOptionPane.showMessageDialog(null,"Error, el dato debe ser mayor a cero","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }catch (Exception e) {
          JOptionPane.showMessageDialog(null,"Error, el dato no debe contener caracteres alfabeticos o especiales","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }
      } while (dat<=0);
      multi*=dat;
    }
    med=Math.pow(multi,1.0/numDa);
    return med;
  }

  public static double medPon(int numDa){
    double med,sum=0,dat=0;
    int peso=0,sumPe=0;

    for (int i=1;i<=numDa ;i++ ) {
      do {
        try{
          dat=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el dato #"+i+": ","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
          if (dat<=0)
            JOptionPane.showMessageDialog(null,"Error, el dato debe ser mayor a cero","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }catch (Exception e) {
          JOptionPane.showMessageDialog(null,"Error, el dato no debe contener caracteres alfabeticos o especiales","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }
      } while (dat<=0);

      do {
        try{
          peso=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el peso dato #"+i+": ","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
          if (peso<=0)
            JOptionPane.showMessageDialog(null,"Error, el dato debe ser mayor a cero","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }catch (Exception e) {
          JOptionPane.showMessageDialog(null,"Error, el dato no debe contener caracteres alfabeticos o especiales","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }
      } while (peso<=0);
      sum+=peso*dat;
      sumPe+=peso;
    }//for

    med=sum/sumPe;
    return med;
  }

  public static double mediana(int numDa,double datos[]){
      double dato,dato1=0.0;
      double [] datosOrdenados = new double[numDa];

      for (int i=0;i<numDa ;i++ ) {
        dato1=datos[i];
        for (int j=0;j<numDa ;j++ ) {
          if (dato1>=datos[j])
            dato1=datos[j];
        }
        datosOrdenados[i]=dato1;
      }

      return dato1;
  }

  public static void main(String[] args) {
    int numDa=0,opcMenu=0;
    double dato=0.0;
    String test="";
    String [] opcis={"Iniciar","Salir"};

    do {
      opcMenu=JOptionPane.showOptionDialog(null,"Menú de inicio","Menú de inicio",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcis,null);

      if (opcMenu==0) {

        do {//Ciclo que obtiene el numero de datos
          try {
            numDa=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de muestras a introducir","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
            if (numDa<=0)
              JOptionPane.showMessageDialog(null,"Error: el numero de datos debe ser mayor a cero...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
          }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error, el dato debe numerico","Mensaje de error",JOptionPane.ERROR_MESSAGE);
          }
        } while (numDa<=0);

        //Creacion del arreglo
        double [] datos= new double[numDa];

        for (int i=0;i<numDa ;i++ ) {
          do {
            try {
              dato=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el dato #"+i,"Entrada de datos",JOptionPane.QUESTION_MESSAGE));
              if (dato<=0)
                JOptionPane.showMessageDialog(null,"Error, el dato debe ser mayor a cero","Mensaje de error",JOptionPane.ERROR_MESSAGE);
              else
                datos[i]=dato;
            }catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Error, el dato no debe de tener caracteres alfabeticos o especiales","Mensaje de error",JOptionPane.ERROR_MESSAGE);
            }
          } while (dato<=0);
        }

        for (int i=0;i<numDa ;i++ ) {
          test+="- "+datos[i]+"\n";
        }

        JOptionPane.showMessageDialog(null,test,"Salida",JOptionPane.INFORMATION_MESSAGE);

      }
    } while (opcis==0);

    System.exit(0);
  }
}
