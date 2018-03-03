package apptienda;

import javax.swing.*;

public class AppTienda {

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

    public static boolean darPaso(JTextField[] formulario, String contra) {
        boolean pasa = false;
        int cont = 0;

        for (int i = 0; i < 4; i++) {
            if (formulario[i].getText().equals("") || detEspe(formulario[i].getText())) {
                cont++;
            }if(!formulario[3].getText().equals(""))
                cont-=1;
        }

        if (contra.equals("") || cont > 0) {
            pasa = false;
        } else {
            pasa = true;
        }

        return pasa;
    }

    public static void main(String[] args) {
        String[] menu1 = {"Sign in", "Sign up", "Salir"};
        String[] menu2 = {"Inventario", "Ventas", "Corte de caja", "Usuario", "Cerrar Sesión"};
        String usuario, contrasena;
        RegistroUsuarios regUsu = new RegistroUsuarios();
        boolean correcto = false;
        //Instancias
        

        int opcion1 = 0, opcion2 = 0;

        do {
            opcion1 = JOptionPane.showOptionDialog(null, null, "Tienda de Abarrotes", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu1, null);
            switch (opcion1) {
                //Iniciar sesion
                case 0:
                    boolean entrada = false;
                    int intento = 0;
                    JTextField login = new JTextField();
                    JPasswordField passIn = new JPasswordField();
                    Object signIn[] = {"Usuario", login, "Contraseña", passIn};
                    
                    
                    if (regUsu.numRegs()>0) {
                        do {
                            int entra = JOptionPane.showConfirmDialog(null, signIn, "Iniciar sesión", JOptionPane.OK_CANCEL_OPTION);
                            if (entra == 0) {
                                char p1 []= passIn.getPassword();
                                String contra = new String(p1);
                                if(regUsu.busqueda(login.getText(), contra)){
                                    JOptionPane.showMessageDialog(null,"¡Bienvenido "+login.getText()+"!","Inicio de sesión",JOptionPane.INFORMATION_MESSAGE);
                                    entrada = true;
                                }else{
                                    JOptionPane.showMessageDialog(null,"Error, usuario o contraseña incorrecta","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                                    intento++;
                                }
                            }else{
                                entrada = true;
                            }
                        } while (!entrada);
                    }else{
                        JOptionPane.showMessageDialog(null,"Aún no se han registrado usuarios","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                    }

                    break;

                //Registro de usuario
                case 1:
                    boolean registro = false;
                    String contraUsu;
                    JPasswordField pass = new JPasswordField();

                    JTextField formu[] = new JTextField[4];
                    for (int i = 0; i < 4; i++) {
                        formu[i] = new JTextField("");
                    }
                    //Creando caja para seleccionar el sexo
                    JComboBox sexos = new JComboBox();
                    sexos.addItem("Femenino");
                    sexos.addItem("Masculino");

                    Object formularioRegistro[] = {"Usuario", formu[0], "Contraseña", pass, "Nombre completo", formu[1], "Sexo", sexos, "Fecha de Nacimiento", formu[2], "Domicilio", formu[3]};

                    do {
                        int reg = JOptionPane.showConfirmDialog(null, formularioRegistro, "Registro de usuario", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (reg == 0) {
                            //Obtenciond de contraseña
                            char p[] = pass.getPassword();
                            contraUsu = new String(p);

                            if (darPaso(formu, contraUsu)) {
                                registro = true;
                                Usuario nuevo = new Usuario(formu[0].getText(), contraUsu, formu[1].getText(), (String) sexos.getSelectedItem(), formu[2].getText(), formu[3].getText());
                                regUsu.agregarUsuario(nuevo);
                                JOptionPane.showMessageDialog(null, "¡Nuevo usuario registrado con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Error, introduzca correctamente los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else if (reg != 0) {
                            registro = true;
                        }

                    } while (registro == false);
                    break;
            }
        } while (opcion1 != 2);

    }

}

/*
do {
                        opcion2 = JOptionPane.showOptionDialog(null, null, "Tienda de Abarrotes", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu2, null);

                        switch (opcion2) {
                            //Inventario
                            case 0:

                                break;
                            //Ventas
                            case 1:

                                break;
                            //Corte de caja
                            case 2:

                                break;
                            //Usuario
                            case 3:

                                break;
                            //Cerrar sesión
                            case 4:
                                int num = 0;

                                num = JOptionPane.showOptionDialog(null, "¿Seguro?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                                if (num == 0) {
                                    JOptionPane.showMessageDialog(null, "Hasta luego", "Cerrar Sesión", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    opcion2 = 0;
                                }
                                break;
                        }
                    } while (opcion2 != 4);

 */
