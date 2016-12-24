import javax.swing.*;

class Inventario{
  String nombre;
  int cantidad;
  double precio;

}

public class Tienda{

  public static void main(String[] args) {
    int i=0,selec=0,selecIn=0,cant;
    double precio;
    String usuario="",contra="",nombre;
    String []menu1={"Inventario","Ventas","Corte de caja","Salir"};
    String []menuInv={"Nuevo producto","Modificar producto","Visualizar Inventario","Salir"};

    //Existe un limite de intentos

    do {
      usuario = JOptionPane.showInputDialog(null,"Ingrese el usuario","Login",JOptionPane.QUESTION_MESSAGE);
      contra = JOptionPane.showInputDialog(null,"Ingrese la contraseña","Password",JOptionPane.QUESTION_MESSAGE);

      if (usuario.equals("Pancho") && contra.equals("perez")) {
        JOptionPane.showMessageDialog(null,"Login exitoso","Login",JOptionPane.INFORMATION_MESSAGE);
      }else{
        i++;
        JOptionPane.showMessageDialog(null,"Error, usuario o contraseña incorrectos","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        if(i==3)
          break;

      }
    } while (!usuario.equals("Pancho") || !contra.equals("perez"));

    if (i<3) {
      Inventario lista[]=new Inventario[50];

      for (int j=0;j<50 ;j++ ) {
        lista[j]=new Inventario();

        lista[j].nombre="Vacio";
      }

      do {
        selec=JOptionPane.showOptionDialog(null,"Seleccione la accion a realizar","Menú principal",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,menu1,"Inventario");

        switch (selec) {
          //Inventario
          case 0:
            do {
              //Seleccion del Inventario
              selecIn=JOptionPane.showOptionDialog(null,"Seleccione la accion a realizar","Menú Inventario",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,menuInv,"Nuevo producto");

              switch (selecIn) {
                //Nuevo producto
                case 0:
                  int bus=-1;//Variable buscadora

                  do {//Ciclo que busca un espacio libre en el arreglo
                    bus++;
                    System.out.print(bus);
                  } while (!lista[bus].nombre.equals("Vacio"));

                  do {
                    nombre=JOptionPane.showInputDialog(null,"Ingrese el nombre del procuto","Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                    if (!nombre.isEmpty())
                      lista[bus].nombre=nombre;
                    else
                      JOptionPane.showMessageDialog(null,"Error, debe ingresar por lo menos un caracter","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                  } while (nombre.isEmpty());

                  do {
                    cant=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad del producto","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
                    if(cant>0)
                      lista[bus].cantidad=cant;
                    else
                      JOptionPane.showMessageDialog(null,"Error, debe ingresar un numero mayor a cero","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                  } while (cant<=0);

                  do {
                    precio=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el precio del producto","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
                    if (precio>0)
                      lista[bus].precio=precio;
                    else
                      JOptionPane.showMessageDialog(null,"Error, debe ingresar un numero mayor a cero","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                  } while (precio<=0);

                break;//Nuevo producto

                case 1://Modificar producto
                  int bus1=-1;//Variable buscadora
                  int pro=0;
                  String []menuMod={"Modificar nombre","Modificar cantidad"};

                  if (lista[0].nombre.equals("Vacio")) {
                    JOptionPane.showMessageDialog(null,"Error, aun no existe ningun producto en el invetario","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                  }else{
                    do {//Ciclo que ayuda al ciclo dinamico
                      bus1++;
                    } while (!lista[bus1].nombre.equals("Vacio"));

                    //Declaracion y creacion de un intento de un arreglo "dinamico"
                    String listaInv[]=new String[bus1+1];

                    for (int j=0;j<bus1 ;j++ )//Ciclo que va creando la lista de productos
                      listaInv[j]=lista[j].nombre;

                    int selecModPro=JOptionPane.showOptionDialog(null,"Seleccione la accion a realizar","Menu Modificar",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,menuMod,"Modificar nombre");
                    Object selecProMod=JOptionPane.showInputDialog(null,"Seleccione el producto a modificar","Seleccion",JOptionPane.QUESTION_MESSAGE,null,listaInv,null);
                    String selPro=selecProMod.toString();

                    for (int r=0;r<bus1 ;r++ )//Ciclo que busca el producto seleccionado
                      if (listaInv[r].equals(selPro))
                        pro=r;

                    switch (selecModPro) {
                      case 0:
                        do {
                          nombre=JOptionPane.showInputDialog(null,"Ingrese el nombre del procuto","Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                          if (!nombre.isEmpty())
                            lista[pro].nombre=nombre;
                          else
                            JOptionPane.showMessageDialog(null,"Error, debe ingresar por lo menos un caracter","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                          } while (nombre.isEmpty());
                      break;
                      case 1:
                        do {
                          cant=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad del producto","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
                          if(cant>0)
                            lista[pro].cantidad=cant;
                          else
                            JOptionPane.showMessageDialog(null,"Error, debe ingresar un numero mayor a cero","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                          } while (cant<=0);
                      break;
                    }
                  }//else
                break;//Modificar producto

                case 2://Vizualizar inventario
                  if (lista[0].nombre.equals("Vacio")) {
                    JOptionPane.showMessageDialog(null,"El inventario esta vacio","Inventario",JOptionPane.INFORMATION_MESSAGE);
                  }
                break;//Vizualizar Inventario
              }
            } while (selecIn!=3);
          break;
        }
      } while (selec != 3);



    }else {//Demasiados intentos = salida del programa
      JOptionPane.showMessageDialog(null,"Error, ha intentado demasiadas veces ingresar al sistema","Mensaje de error",JOptionPane.ERROR_MESSAGE);
    }
    System.exit(0);
  }
}
