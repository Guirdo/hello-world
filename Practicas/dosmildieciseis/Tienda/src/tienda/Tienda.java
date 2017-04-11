package tienda;

import javax.swing.*;

public class Tienda {

    //Metodo que busca caracteres especiales en el usuario
    public static boolean detEspe(String usuario) {
        char c = 'a';
        boolean es = false;

        for (int i = 0; i < usuario.length(); i++) {
            c = usuario.charAt(i);
            if (c >= 32 && c <= 47 || c >= 58 && c <= 64) {
                break;
            }
        }

        if (c >= 32 && c <= 47 || c >= 58 && c <= 64) {
            es = true;
        }

        return es;
    }

    //Metodo que busca los numeros en el nombre de los productos
    public static boolean detNume(String nombre) {
        char c = 'a';
        boolean es = false;

        for (int i = 0; i < nombre.length(); i++) {
            c = nombre.charAt(i);
            if (c >= 48 && c <= 57) {
                break;
            }
        }

        if (c >= 48 && c <= 57) {
            es = true;
        }

        return es;
    }

    public static void main(String[] args) {
        int i = 0, selec = 0, selecIn = 0, cant = 0, selecPri = 0;
        double precio = 0, ingreTo = 0;
        String usuario = "", contra = "", nombre, comprasTotales = "";
        String[] panPrin = {"Login", "Salir"};
        String[] menu1 = {"Inventario", "Ventas", "Corte de caja", "Salir"};
        String[] menuInv = {"Nuevo producto", "Modificar producto", "Visualizar Inventario", "Salir"};
        //Intancia de objetos necesarios
        JPasswordField pass = new JPasswordField();

        do {

            selecPri = JOptionPane.showOptionDialog(null, "Seleccion la accion a realizar", "Pantalla Principal", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, panPrin, null);
            i=0;
            if (selecPri == 0) {
                do {//Existe un limite de intentos

                    do {
                        usuario = JOptionPane.showInputDialog(null, "Introduzca el usuario", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
                        if (usuario.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Error, introduzca por lo menos un caracter", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        }
                        if (detEspe(usuario))//Preguntar si introduce caracteres especiales contarlo como intento fallido
                        {
                            JOptionPane.showMessageDialog(null, "Error, no introduzca caracteres especiales", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (usuario.isEmpty() || detEspe(usuario) == true);

                    do {
                        //contra = JOptionPane.showInputDialog(null, "Ingrese la contraseña", "Password", JOptionPane.QUESTION_MESSAGE);
                        JOptionPane.showConfirmDialog(null,new Object[]{"Ingrese la contraseña",pass},"Password",JOptionPane.OK_CANCEL_OPTION);
                        char p[]=pass.getPassword();
                        contra=new String(p);
                        if (contra.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Error, introduzca por lo menos un caracter", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (contra.isEmpty());

                    if (usuario.equals("Pancho") && contra.equals("perez")) {
                        JOptionPane.showMessageDialog(null, "Login exitoso!", "Login", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        i++;
                        JOptionPane.showMessageDialog(null, "Error, usuario o contraseña incorrectos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        if (i == 3) {
                            break;
                        }
                    }
                } while (!usuario.equals("Pancho") || !contra.equals("perez"));

                if (i < 3) {
                    Inventario lista[] = new Inventario[50];

                    for (int j = 0; j < 50; j++) {
                        lista[j] = new Inventario();
                        lista[j].nombre = "Vacio";
                    }

                    do {
                        selec = JOptionPane.showOptionDialog(null, "Seleccione el menu al que desea ingresar", "Menú principal", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu1, "Inventario");

                        switch (selec) {
                            case 0://Inventario
                                do {
                                    //Seleccion del Inventario
                                    selecIn = JOptionPane.showOptionDialog(null, "Seleccione la accion a realizar", "Menú Inventario", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuInv, "Nuevo producto");

                                    switch (selecIn) {
                                        //Nuevo producto
                                        case 0:
                                            int bus = -1;//Variable buscadora

                                            do {//Ciclo que busca un espacio libre en el arreglo
                                                bus++;
                                                System.out.print(bus);
                                            } while (!lista[bus].nombre.equals("Vacio"));

                                            do {
                                                nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
                                                if (!nombre.isEmpty()) {
                                                    if (detNume(nombre) || detEspe(nombre.replace(" ", ""))) {
                                                        JOptionPane.showMessageDialog(null, "No puede introducir caracteres numericos ni especiales...", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                    } else 
                                                        lista[bus].nombre = nombre.toUpperCase().replace(" ", "");
                                                } else 
                                                    JOptionPane.showMessageDialog(null, "Error, debe ingresar por lo menos un caracter", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                            } while (nombre.isEmpty() || detNume(nombre) == true);

                                            do {
                                                try {
                                                    cant = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad del producto", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                                                    if (cant > 0) {
                                                        lista[bus].cantidad = cant;
                                                    } else 
                                                        JOptionPane.showMessageDialog(null, "Error, debe ingresar un numero mayor a cero", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                } catch (Exception e) {
                                                    JOptionPane.showMessageDialog(null, "Error, el dato debe ser numerico", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                }
                                            } while (cant <= 0);

                                            do {
                                                try {
                                                    precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio del producto", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                                                    if (precio > 0) {
                                                        lista[bus].precio = precio;
                                                    } else 
                                                        JOptionPane.showMessageDialog(null, "Error, debe ingresar un numero mayor a cero", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                } catch (Exception e) {
                                                    JOptionPane.showMessageDialog(null, "Error, el dato debe ser numerico", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                }
                                            } while (precio <= 0);

                                            break;//Nuevo producto

                                        case 1://Modificar producto
                                            int bus1 = -1;//Variable buscadora
                                            int pro = 0;
                                            String[] menuMod = {"Modificar nombre", "Modificar cantidad"};

                                            if (lista[0].nombre.equals("Vacio")) 
                                                JOptionPane.showMessageDialog(null, "Error, aun no existe ningun producto en el invetario", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                            else {
                                                do {//Ciclo que ayuda al ciclo dinamico
                                                    bus1++;
                                                } while (!lista[bus1].nombre.equals("Vacio"));

                                                //Declaracion y creacion de un intento de un arreglo "dinamico"
                                                String listaInv[] = new String[bus1 + 1];

                                                for (int j = 0; j < bus1; j++)//Ciclo que va creando la lista de productos
                                                {
                                                    listaInv[j] = lista[j].nombre;
                                                }

                                                int selecModPro = JOptionPane.showOptionDialog(null, "Seleccione la accion a realizar", "Menu Modificar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuMod, "Modificar nombre");
                                                Object selecProMod = JOptionPane.showInputDialog(null, "Seleccione el producto a modificar", "Seleccion", JOptionPane.QUESTION_MESSAGE, null, listaInv, null);
                                                String selPro = selecProMod.toString();

                                                for (int r = 0; r < bus1; r++)//Ciclo que busca el producto seleccionado
                                                    if (listaInv[r].equals(selPro)) 
                                                        pro = r;

                                                switch (selecModPro) {
                                                    case 0://Modificacion del nombre
                                                        do {
                                                            nombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del producto"+
                                                                                                       "\nNombre anterior: "+lista[pro].nombre, "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
                                                            if (nombre.isEmpty()) 
                                                                JOptionPane.showMessageDialog(null, "Error, debe ingresar por lo menos un caracter", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                            else if (detNume(nombre) || detEspe(nombre)) 
                                                                JOptionPane.showMessageDialog(null, "No puede introducir caracteres numericos ni especiales...", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                            else 
                                                                lista[pro].nombre = nombre.toUpperCase().replace(" ", "");
                                                        } while (nombre.isEmpty() || detNume(nombre) == true || detEspe(nombre) == true);
                                                        break;
                                                    case 1://Modificacion de cantidad
                                                        String[] accion = {"Aumentar cantidad", "Reducir cantidad"};
                                                        String palabra = "";
                                                        int selecModCan = JOptionPane.showOptionDialog(null, "Seleccione la accion a realizar", "Seleccion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, accion, null);

                                                        do {
                                                            try {
                                                                cant = Integer.parseInt(JOptionPane.showInputDialog(null, accion[selecModCan] + " del producto\nCantidad anterior: "+lista[pro].cantidad, "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                                                                if (cant > 0) {
                                                                    switch (selecModCan) {
                                                                        case 0:
                                                                            lista[pro].cantidad += cant;
                                                                            break;
                                                                        case 1:
                                                                            lista[pro].cantidad -= cant;
                                                                            break;
                                                                    }
                                                                } else 
                                                                    JOptionPane.showMessageDialog(null, "Error, debe ingresar un numero mayor a cero", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                            } catch (Exception e) {
                                                                JOptionPane.showMessageDialog(null, "Error, el dato debe ser numerico", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                            }
                                                        } while (cant <= 0);
                                                        break;//Modificacion de cantidad
                                                }
                                            }//else
                                            break;//Modificar producto

                                        case 2://Vizualizar inventario
                                            if (lista[0].nombre.equals("Vacio")) {
                                                JOptionPane.showMessageDialog(null, "El inventario esta vacio", "Inventario", JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                String salida = "";
                                                int bus2 = -1;

                                                do {
                                                    bus2++;//Variable que va a mostar tantos elementos que tenga diferente a vacio
                                                } while (!lista[bus2].nombre.equals("Vacio"));

                                                for (int j = 0; j < bus2; j++) {
                                                    salida += "Producto: " + lista[j].nombre + "\n"
                                                            + "Cantidad: " + lista[j].cantidad + "\n"
                                                            + "Precio: $" + lista[j].precio + "\n\n";
                                                }

                                                JOptionPane.showMessageDialog(null, salida, "Inventario", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                            break;//Vizualizar Inventario
                                    }
                                } while (selecIn != 3);//Ciclo del inventario
                                break;//Inventario

                            case 1://Ventas

                                if (!lista[0].nombre.equals("Vacio")) {
                                    int selecVen;
                                    String salVe;

                                        do {
                                            int bus3 = -1;
                                            salVe="";

                                            do {
                                                bus3++;
                                            } while (!lista[bus3].nombre.equals("Vacio"));

                                            for (int j = 0; j < bus3; j++) {
                                                salVe += "Producto: " + lista[j].nombre + "\n"
                                                        + "Cantidad: " + lista[j].cantidad + "\n\n";
                                            }

                                            selecVen = JOptionPane.showOptionDialog(null, salVe + "Seleccione la accion a realizar ", "Venta", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Comprar", "Salir"}, null);

                                            if (selecVen == 0) {
                                                int bus3_2 = -1;

                                                do {
                                                    bus3_2++;
                                                } while (!lista[bus3_2].nombre.equals("Vacio"));

                                                String[] listVen = new String[bus3_2 + 1];

                                                for (int j = 0; j < bus3_2 + 1; j++) {
                                                    listVen[j] = lista[j].nombre;
                                                }

                                                int comCon = 0;
                                                double totalCom = 0;
                                                String compras = "";
                                                do {
                                                    Object compra = JOptionPane.showInputDialog(null, "Seleccione el producto a comprar", "Compra", JOptionPane.QUESTION_MESSAGE, null, listVen, null);

                                                    int bus3_3 = -1;

                                                    do {
                                                        bus3_3++;
                                                    } while (!lista[bus3_3].nombre.equals(compra.toString()));

                                                    int cantNuev = 0;

                                                    do {
                                                        try {
                                                            cantNuev = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad a comprar", "Comprar", JOptionPane.QUESTION_MESSAGE));
                                                            if (cantNuev <= 0) {
                                                                JOptionPane.showMessageDialog(null, "Error, la cantidad debe ser mayor a cero", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                            }else if (cantNuev > lista[bus3_3].cantidad) {
                                                                JOptionPane.showMessageDialog(null, "Error, sobredemanda...", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                            }
                                                        } catch (Exception e) {
                                                            JOptionPane.showMessageDialog(null, "Error, el dato debe ser numerico...", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    } while (cantNuev <= 0 || cantNuev > lista[bus3_3].cantidad);

                                                    lista[bus3_3].cantidad -= cantNuev;

                                                    compras += "- " + compra.toString() + "\n";
                                                    totalCom += cantNuev * lista[bus3_3].precio;
                                                    comCon = JOptionPane.showOptionDialog(null, "¿Desea comprar otro producto?", "Continuar comprando", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                                                } while (comCon == 0);

                                                comprasTotales += compras;
                                                ingreTo += totalCom;

                                                JOptionPane.showMessageDialog(null, "Lista de compras: \n" + compras + "\n"
                                                                                    + "Total a pagar: $" + totalCom);

                                                double dinero = 0;

                                                do {
                                                    try {
                                                        dinero = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad con la cual va a pagar", "Caja", JOptionPane.QUESTION_MESSAGE));
                                                        if (dinero < totalCom) 
                                                            JOptionPane.showMessageDialog(null, "Error, dinero insuficiente para pagar la cuenta", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                    } catch (Exception e) {
                                                        JOptionPane.showMessageDialog(null, "Error, el dato debe ser numerico", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                } while (dinero < totalCom);

                                                if (dinero == totalCom) {
                                                    JOptionPane.showMessageDialog(null, "¡Gracias por su compra!", "Caja", JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Su cambio es de: $" + (dinero - totalCom) + "\n"
                                                            + "¡Gracias por su compra!", "Caja", JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            }
                                        } while (selecVen == 0);

                                } else {
                                    JOptionPane.showMessageDialog(null, "Error, aun no existen elementos en el inventario", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                }
                                break;//Ventas

                            case 2://Corte de caja

                                JOptionPane.showMessageDialog(null, "Productos comprados: \n" + comprasTotales + "\n"
                                        + "Total de ingresos: " + ingreTo, "Corte de caja", JOptionPane.INFORMATION_MESSAGE);

                                break;//Corte de caja
                        }
                    } while (selec != 3);//Ciclo subprincipal

                } else //Demasiados intentos = salida del programa
                    JOptionPane.showMessageDialog(null, "Error, ha intentado demasiadas veces ingresar al sistema", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
        } while (selecPri == 0);//Ciclo principal

        JOptionPane.showMessageDialog(null, "Hasta luego!", "Salida del programa", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
