/*
Nombre: Aldo Sebastián Méndez González
Grupo: R-1
Horario: 7:00 - 8:00
*/

package apptienda;

import java.util.ArrayList;
import javax.swing.*;

public class AppTienda {

    static RegistroUsuarios regUsu = new RegistroUsuarios();
    static Inventario inven = new Inventario();
    static RegistroVentas regVen = new RegistroVentas();
    static String usuNum, usu;

    //Metodos de login y de registro--------------------------------------------------------------------------------------------------------------------------------------------
    static boolean login() {
        String nickName = "", contrasena = "";
        boolean error = false, entrada = false;
        int i = 0;//0=OK;1=Cancel
        JPasswordField pass = new JPasswordField();
        JTextField usuario = new JTextField();
        Object login[] = {"Usuario: ", usuario, "Contraseña: ", pass};

        do {
            int ini = JOptionPane.showConfirmDialog(null, login, "Iniciar Sesión", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (ini == 0) {
                //Obtenciond de contraseña y usuario de los objetos
                char p[] = pass.getPassword();
                contrasena = new String(p);
                nickName = usuario.getText();

                if (regUsu.busqueda(nickName, contrasena)) {
                    JOptionPane.showMessageDialog(null, "¡Bienvenido " + nickName + "!", "¡Sesión iniciada!", JOptionPane.INFORMATION_MESSAGE);
                    //Para usos futuros
                    setUsuarioNum(regUsu.getNumEmp(regUsu.busqueda(nickName)));
                    setUsuario(regUsu.getNombreEmp(regUsu.busqueda(nickName)));

                    entrada = true;
                    error = false;
                } else {
                    System.out.println(contrasena + "\n" + nickName);
                    JOptionPane.showMessageDialog(null, "Error, usuario o contraseña son incorrectos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                    i++;
                    if (i == 3) {
                        entrada = true;
                        JOptionPane.showMessageDialog(null, "Error, llego al numero de intentos maximos...", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                    }
                    error = true;
                }
            } else if (ini > 0) {
                entrada = true;
                error = true;
            }
        } while (!entrada);

        if (error) {
            return false;
        } else {
            return true;
        }
    }

    static void setUsuario(String nom) {
        usu = nom;
    }

    static void setUsuarioNum(String nom) {
        usuNum = nom;
    }

    static void registro() {
        boolean pasa = false;
        JPasswordField pass = new JPasswordField();
        //0=nickname;1=nombre;2=fechanacimiento;3=domicilio
        JTextField formu[] = new JTextField[4];
        for (int i = 0; i < 4; i++) {
            formu[i] = new JTextField();
        }

        //Creando caja para seleccionar el sexo
        JComboBox sexos = new JComboBox();
        sexos.addItem("Femenino");
        sexos.addItem("Masculino");

        //Objeto donde se forma el formulario (valga la redundancia)
        Object formulario[] = {"Nickame", formu[0], "Contraseña", pass, "Nombre completo", formu[1], "Sexo", sexos, "Fecha de nacimiento", formu[2], "Domicilio", formu[3]};

        do {
            int regis = JOptionPane.showConfirmDialog(null, formulario, "Registro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (regis == 0) {
                char p[] = pass.getPassword();
                String contra = new String(p);
                if (comprobacion(formu, contra)) {
                    pasa = true;
                    Usuario nuevo = new Usuario(formu[0].getText(), formu[1].getText(), formu[2].getText(), formu[3].getText(), (String) sexos.getSelectedItem(), contra);
                    regUsu.agregarUsuario(nuevo);
                    JOptionPane.showMessageDialog(null, "¡Nuevo usuario registrado con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error, introduzca correctamente los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                pasa = true;
            }
        } while (!pasa);

    }

    //Metodos de login y de registro--------------------------------------------------------------------------------------------------------------------------------------------
    static boolean comprobacion(JTextField[] formu, String pass) {
        boolean pasa = false, pasaCon = false;

        if (!pass.isEmpty()) {
            pasaCon = true;
        } else {
            pasaCon = false;
        }

        for (int i = 0; i < formu.length; i++) {
            if (!formu[i].getText().equals("")) {
                pasa = true;
            } else {
                pasa = false;
                break;
            }
        }

        if (pasa && pasaCon) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] menuInicio = {"Iniciar sesión", "Registro", "Salir"};
        String[] menuPrincipal = {"Inventario", "Ventas", "Corte de caja", "Cerrar sesión"};
        int opc1 = 0, opc2 = 0;

        do {
            opc1 = JOptionPane.showOptionDialog(null, null, "Menú de Inicio", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuInicio, null);
            switch (opc1) {
                //Iniciar sesión
                case 0:
                    if (regUsu.numRegs() > 0) {
                        if (login()) {
                            do {
                                opc2 = JOptionPane.showOptionDialog(null, null, "Menú principal", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuPrincipal, null);
                                switch (opc2) {
                                    //Inventario
                                    case 0:
                                        String[] menuInv = {"Agregar producto", "Modificar producto", "Ver Inventario", "Salir"};
                                        int selec1 = 0;

                                        do {
                                            selec1 = JOptionPane.showOptionDialog(null, null, "Inventario", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuInv, null);

                                            switch (selec1) {
                                                //Agregar producto
                                                case 0:
                                                    darAltaPro();
                                                    break;
                                                //Modificar producto    
                                                case 1:
                                                    if (inven.numPro() > 0) {
                                                        Object busPro = JOptionPane.showInputDialog(null, "Realice la busqueda del producto a modificar", "Inventario", JOptionPane.QUESTION_MESSAGE,null,inven.getLista(),null);
                                                        modificarPro(busPro.toString());
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Error, no se han registrado ningun producto", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                    break;
                                                case 2:
                                                    if (inven.numPro() > 0) {
                                                        JTextArea area = new JTextArea(inven.toString());
                                                        JOptionPane.showMessageDialog(null, area, "Inventario", JOptionPane.INFORMATION_MESSAGE);
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Error, aun no se ha registrado ningún producto...", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                    break;
                                            }
                                        } while (selec1 != 3);

                                        break;//Inventario
                                    //Ventas    
                                    case 1:
                                        if (inven.numPro() > 0) {
                                            compra();
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Error, aun no se ha registrado ningún producto...", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                        }
                                        break;

                                    case 2:
                                        JTextArea area = new JTextArea(regVen.toString());

                                        JOptionPane.showMessageDialog(null, area, "Corte de caja", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case 3:
                                        JOptionPane.showMessageDialog(null,"Hasta luego "+usu,"Sesión cerrada",JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                }
                            } while (opc2!=3);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error, no se ha registrado nigún usuario...", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                //Registro de usuario
                case 1:
                    registro();
                    break;
            }
        } while (opc1 != 2);

        System.exit(0);
    }

    static void darAltaPro() {
        boolean sale = false;
        JTextField formu[] = new JTextField[3];
        for (int i = 0; i < 3; i++) {
            formu[i] = new JTextField();
        }

        Object campos[] = {"Nombre del producto", formu[0], "Cantidad", formu[1], "Precio por pieza", formu[2]};

        do {
            int agre = JOptionPane.showConfirmDialog(null, campos, "Producto nuevo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (agre == 0) {
                String nombre = formu[0].getText();
                int cantidad = Integer.parseInt(formu[1].getText());
                double precio = Double.parseDouble(formu[2].getText());

                if (comprobacion(nombre, cantidad, precio)) {
                    sale = true;

                    Producto pro = new Producto(nombre, cantidad, precio);
                    inven.agregarPro(pro);
                    JOptionPane.showMessageDialog(null, "Nuevo producto registrado", "Inventario", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error, introduzca bien los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (agre != 0) {
                sale = true;
            }
        } while (!sale);

    }

    static void modificarPro(String nombre) {
        int num = inven.busqueda(nombre);
        String preString = String.valueOf(inven.getPrecio(num));
        String cantString = String.valueOf(inven.getCantidad(num));

        if (num >= 0) {
            boolean pasa = false;

            JTextField nom = new JTextField(inven.getNombre(num));
            JTextField cant = new JTextField(cantString);
            JTextField pre = new JTextField(preString);

            Object campos[] = {"Nombre", nom, "Cantidad", cant, "Precio", pre};

            do {
                int mod = JOptionPane.showConfirmDialog(null, campos, "Modificación del producto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (mod == 0) {
                    String nombreMod = nom.getText();
                    int cantidadMod = Integer.parseInt(cant.getText());
                    double precioMod = Double.parseDouble(pre.getText());

                    if (comprobacion(nombreMod, cantidadMod, precioMod)) {
                        pasa = true;

                        inven.modificarProducto(num, nombreMod, cantidadMod, precioMod);
                        JOptionPane.showMessageDialog(null, "El Producto ha sido modificado", "Inventario", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error, introduzca los valores correctamente", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (mod != 0) {
                    pasa = true;
                }
            } while (!pasa);

        } else {
            JOptionPane.showMessageDialog(null, "Error, el producto que busco, no se encuentra registrado...", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
    }

    static boolean comprobacion(String nombre, int cantidad, double precio) {

        if (!nombre.isEmpty()) {
            if (cantidad > 0) {
                if (precio > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    static void compra() {
        boolean compro = false;
        int continuar = 0;
        String[] listaPro = inven.getLista();
        JTextField cantCom = new JTextField();
        JTextArea area = new JTextArea(inven.verProductos());

        JComboBox pros = new JComboBox();
        for (int i = 0; i < listaPro.length; i++) {
            pros.addItem(listaPro[i]);
        }

        ArrayList<String> lista = new ArrayList<>();
        ArrayList<Integer> cants = new ArrayList<>();

        Object campos[] = {"Seleccione el producto", pros, "Ingrese la cantidad a comprar", cantCom};

        int com = JOptionPane.showOptionDialog(null, area, "Ventas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Realizar compra", "Salir"}, null);

        if (com == 0) {
            while (continuar == 0) {
                int compra = JOptionPane.showConfirmDialog(null, campos, "Venta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (compra == 0) {
                    String pro = (String) pros.getSelectedItem();
                    int cant = Integer.parseInt(cantCom.getText());
                    if (comprobacion(pro, cant)) {
                        lista.add(pro);
                        cants.add(cant);
                        continuar = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "Venta", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Continuar venta", "Finalizar", "Cancelar"}, null);
                        if (continuar == 2) {
                            JOptionPane.showMessageDialog(null, "Compra cancelada", "Cancelación", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error, la cantidad a comprar es mayor a la cantidad disponible...", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        if (!lista.isEmpty()) {
                            continuar = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "Venta", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Continuar venta", "Finalizar", "Cancelar"}, null);
                            if (continuar == 2) {
                                JOptionPane.showMessageDialog(null, "Compra cancelada", "Cancelación", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                }
            }

            //If donde se van haciendo las operaciones correspondientes y la creación del objeto venta
            if (continuar == 1) {
                String nom = "", sal = "Producto\tCant.\t $\n";
                int can = 0;
                double subTotal = 0.0, total = 0.0;

                for (int i = 0; i < lista.size(); i++) {
                    nom = lista.get(i);
                    can = cants.get(i);
                    subTotal = inven.getPrecio(inven.busqueda(nom)) * can;

                    sal += "-" + nom + "\t" + can + "\t" + subTotal + "\n";

                    //Va sumando los subtotales para mostra la venta
                    total += subTotal;

                    //Va disminiyendo las cantidades dentro del inventario, uno por uno
                    inven.disminuirInventario(inven.busqueda(nom), can);
                }

                String sal1 = sal;
                sal += "\nLe atendio " + usu;

                JTextArea boleto = new JTextArea(sal);
                JTextField pago = new JTextField();
                boolean pagado = false;

                Object camps[] = {boleto, "¿Con cuanto desea pagar?", pago};

                while (!pagado) {
                    int pagar = JOptionPane.showConfirmDialog(null, camps, "Venta realizada", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (pagar == 0) {
                        double dinero = Double.parseDouble(pago.getText());
                        if (dinero == total) {
                            JOptionPane.showMessageDialog(null, "¡Gracias por su compra!", "Venta", JOptionPane.INFORMATION_MESSAGE);
                            pagado = true;
                        } else if (dinero > total) {
                            JOptionPane.showMessageDialog(null, "Su cambio es de: $" + (dinero - total) + "\n¡Gracias por su compra!", "Venta", JOptionPane.INFORMATION_MESSAGE);
                            pagado = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Le hace falta dinero para pagar la cuenta", "Venta", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

                Venta venta = new Venta(sal, usuNum, total);
                regVen.agregaVenta(venta, total);
            }
        }
    }

    static boolean comprobacion(String nombre, int cant) {
        if (cant <= inven.getCantidad(inven.busqueda(nombre))) {
            return true;
        } else {
            return false;
        }
    }

}
