/*
 * Hola!
 */
package carchsecesc02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class CArchSecEsc02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        String nombre, sexo = "";
        int edad;
        double peso, estatura;
        boolean disponeAuto = false;

        int seleccion = 0, continuar = 0, menu = 0,selec=0;
        Object opcion[] = {"Si", "No"};
        Object genero[] = {"Masculino", "Femenino"};
        DataOutputStream flujoSalidaDatos = new DataOutputStream(new FileOutputStream("agenda.dat", true));
        DataInputStream flujoEntradaDatos = new DataInputStream(new FileInputStream("agenda.dat"));

        try {
            do {
                menu = JOptionPane.showOptionDialog(null, null, "Menu principal", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Agregar datos", "Consultar datos", "Salir"}, null);
                switch (menu) {
                    case 0:
                        while (continuar == 0) {
                            nombre = JOptionPane.showInputDialog(null, "Nombre", "Entrada de datos", JOptionPane.INFORMATION_MESSAGE);
                            if (nombre.length() != 0) {
                                selec = JOptionPane.showOptionDialog(null, "Sexo", "Entrada de datos",JOptionPane.YES_NO_OPTION ,JOptionPane.QUESTION_MESSAGE, null, genero, null);
                                if (selec == -1) {
                                    JOptionPane.showMessageDialog(null, "Error, usted selecciono cancelar o cerrar", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                if(selec == 0){
                                    sexo = "Masculino";
                                }else{
                                    sexo = "Femenino";
                                }
                            }
                            edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                            peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Peso", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                            estatura = Double.parseDouble(JOptionPane.showInputDialog(null, "Estatura", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));

                            seleccion = JOptionPane.showOptionDialog(null, "Dispone de auto", "Entrada de datos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcion, null);
                            if (seleccion == 0) {
                                disponeAuto = true;
                            } else {
                                disponeAuto = false;
                            }

                            flujoSalidaDatos.writeUTF(nombre);
                            flujoSalidaDatos.writeUTF(sexo);
                            flujoSalidaDatos.writeInt(edad);
                            flujoSalidaDatos.writeDouble(peso);
                            flujoSalidaDatos.writeDouble(estatura);
                            flujoSalidaDatos.writeBoolean(disponeAuto);

                            flujoSalidaDatos.flush();

                            continuar = JOptionPane.showOptionDialog(null, "Desea continuar?", "Continuar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                            if (continuar == -1) {
                                JOptionPane.showMessageDialog(null, "Selecciono cerrar", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                        break;

                    case 1:
                        int menuCon = JOptionPane.showOptionDialog(null, "Seleccione el modo de consultar", "Consulta", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Persona", "Edad", "Sexo y edad", "Sexo y si dispone de auto", "Completo"}, null);
                        switch (menuCon) {
                            //Persona
                            case 0:
                                String salida = "";
                                String nom = JOptionPane.showInputDialog(null, "Ingrese la persona a buscar", "Consulta por persona", JOptionPane.QUESTION_MESSAGE);

                                try {
                                    while (true) {
                                        if (flujoEntradaDatos.readUTF().equals(nom)) {
                                            salida += "Nombre: " + nom + "\nSexo: " + flujoEntradaDatos.readUTF() + "\nEdad: " + flujoEntradaDatos.readInt() + "\nPeso: " + flujoEntradaDatos.readDouble() + "\nEstatura: " + flujoEntradaDatos.readDouble();
                                            if (flujoEntradaDatos.readBoolean()) {
                                                salida += "\nDispone de auto: Si\n";
                                            } else {
                                                salida += "\nDispone de auto: No\n";
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    if (salida.isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Error, la persona no se encuentra registrada", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, salida, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }

                                break;
                            //Edad    
                            case 1:
                                String nom1,
                                 sexo1,
                                 sal1 = "";
                                int edad1;
                                double peso1,
                                 estatura1;
                                boolean dispo1;

                                int consulEdad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad a consultar", "Consulta por edad", JOptionPane.QUESTION_MESSAGE));

                                try {
                                    while (true) {
                                        nom1 = flujoEntradaDatos.readUTF();
                                        sexo1 = flujoEntradaDatos.readUTF();
                                        edad1 = flujoEntradaDatos.readInt();
                                        peso1 = flujoEntradaDatos.readDouble();
                                        estatura1 = flujoEntradaDatos.readDouble();
                                        dispo1 = flujoEntradaDatos.readBoolean();

                                        if (consulEdad == edad1) {
                                            sal1 += "Nombre: " + nom1 + "\nSexo: " + sexo1 + "\nEdad: " + edad1 + "\nPeso: " + peso1 + "\nEstatura: " + estatura1;
                                            if (dispo1) {
                                                sal1 += "\nDispone de auto: Si\n";
                                            } else {
                                                sal1 += "\nDispone de auto: No\n";
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    if (sal1.isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Error: no existe ninguna persona en el registro con esa edad", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, sal1, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;
                            //Sexo y edad
                            case 2:
                                String nom2,sexo2,sal2 = "",consulSex = "";
                                int edad2;
                                double peso2,estatura2;
                                boolean dispo2;

                                int consulEdad1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad a buscar", "Consulta por edad y sexo", JOptionPane.QUESTION_MESSAGE));
                                Object selecSex = JOptionPane.showInputDialog(null, "Seleccione el sexo a consultar", "Consulta por edad y sexo", JOptionPane.QUESTION_MESSAGE, null, genero, null);
                                try {
                                    while (true) {
                                        nom2 = flujoEntradaDatos.readUTF();
                                        sexo2 = flujoEntradaDatos.readUTF();
                                        edad2 = flujoEntradaDatos.readInt();
                                        peso2 = flujoEntradaDatos.readDouble();
                                        estatura2 = flujoEntradaDatos.readDouble();
                                        dispo2 = flujoEntradaDatos.readBoolean();

                                        if (selecSex.equals(sexo2) && consulEdad1 == edad2) {
                                            sal2 += "Nombre: " + nom2 + "\nSexo: " + sexo2 + "\nEdad: " + edad2 + "\nPeso: " + peso2 + "\nEstatura: " + estatura2;
                                            if (dispo2) {
                                                sal2 += "\nDispone de auto: Si\n";
                                            } else {
                                                sal2 += "\nDispone de auto: No\n";
                                            }
                                        }
                                    }

                                } catch (Exception e) {
                                    if (sal2.isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Error: no existe ninguna persona en el registro con esa edad", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, sal2, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;
                            //Sexo y si dispone de auto    
                            case 3:
                                String nom3,sexo3,sal3 = "",consulSex1 = "";
                                int edad3;
                                double peso3,estatura3;
                                boolean dispo3;

                                Object selecSex1 = JOptionPane.showInputDialog(null, "Seleccione el sexo", "Consulta", JOptionPane.QUESTION_MESSAGE, null, genero, null);

                                try {
                                    while (true) {
                                        nom3 = flujoEntradaDatos.readUTF();
                                        sexo3 = flujoEntradaDatos.readUTF();
                                        edad3 = flujoEntradaDatos.readInt();
                                        peso3 = flujoEntradaDatos.readDouble();
                                        estatura3 = flujoEntradaDatos.readDouble();
                                        dispo3 = flujoEntradaDatos.readBoolean();

                                        if (selecSex1.equals(sexo3) && dispo3) {
                                            sal3 += "Nombre: " + nom3 + "\nSexo: " + sexo3 + "\nEdad: " + edad3 + "\nPeso: " + peso3 + "\nEstatura: " + estatura3+"\nDispone de auto: Si\n";
                                        }
                                    }

                                } catch (Exception e) {
                                    if (sal3.isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Error: no existe ninguna persona en el registro con esa edad", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, sal3, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }

                                break;

                            case 4:
                                String salida1 = "";
                                try {
                                    while (true) {

                                        salida1 += "Nombre: " + flujoEntradaDatos.readUTF() + "\nSexo: " + flujoEntradaDatos.readUTF() + "\nEdad: " + flujoEntradaDatos.readInt() + "\nPeso: " + flujoEntradaDatos.readDouble() + "\nEstatura: " + flujoEntradaDatos.readDouble();
                                        if (flujoEntradaDatos.readBoolean()) {
                                            salida1 += "\nDispone de auto: Si\n";
                                        } else {
                                            salida1 += "\nDispone de auto: No\n";
                                        }

                                    }
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, salida1, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                        }
                        break;
                }
            } while (menu != 2);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        } finally {

            try {
                flujoSalidaDatos.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }

            System.exit(0);
        }
    }

}
