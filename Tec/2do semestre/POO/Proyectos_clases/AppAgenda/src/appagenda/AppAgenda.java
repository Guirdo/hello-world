package appagenda;

import javax.swing.*;

public class AppAgenda {

    public static void main(String[] args) {
        Agenda agen = new Agenda("Contactos de Aldo");
        Object opcion[] = {"Si", "No"};
        String[] opciones = {"Agregar", "Consultar", "Eliminar", "Visualizar", "Salir"};
        char resp = 'S';
        int sel, flag;
        boolean telVali;
        String nombre, fecNa, numTel, tipo, opc,nom;

        do {
            Object opcs = JOptionPane.showInputDialog(null, "Seleccione la accion a realizar", "Menú principal", JOptionPane.QUESTION_MESSAGE,null, opciones,null);
            opc = opcs.toString();

            if (opc.equals("Agregar")) {
                //Captura de datos
                while (resp == 'S') {
                    nombre = JOptionPane.showInputDialog(null, "Nombre", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
                    fecNa = JOptionPane.showInputDialog(null, "Fecha de nacimiento (DD/MM/AAAA)", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);

                    Persona perso = new Persona(nombre, fecNa);

                    flag = 0;
                    while (flag == 0) {
                        numTel = JOptionPane.showInputDialog(null, "Numero telefonico", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);

                        if (valiNum(numTel)) {
                            Object tipoTel = JOptionPane.showInputDialog(null, "Tipo de telefono", "Entrada de datos", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Casa", "Movil", "Trabajo"}, null);
                            tipo = tipoTel.toString();

                            perso.agreTel(numTel, tipo);
                            telVali = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Error, el numero de telefono no es valido...", "Mensaje de error...", JOptionPane.ERROR_MESSAGE);
                            telVali = false;
                        }

                        flag = JOptionPane.showOptionDialog(null, "Desea ingresar otro numero telefonico?", "Directorio telefonico", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, null);

                        if (telVali && flag != 0) {
                            agen.agrePerAge(perso);
                        }
                    }//While (flag)
                    sel = JOptionPane.showOptionDialog(null, "Desea registrar a otra persona?", "Directorio telefonico", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcion, "Si");

                    if (sel == 0) {
                        resp = 'S';
                    }

                    if (sel == 1) {
                        resp = 'N';
                    }

                    if (sel == -1) {
                        JOptionPane.showMessageDialog(null, "Error, usted no eligio Si o No", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        System.exit(1);
                    }
                }//while resp
                resp = 'S';
            } else if (opc.equals("Consultar")) {
                
                Object conopcs = JOptionPane.showInputDialog(null,"Seleccione","Consulta",JOptionPane.QUESTION_MESSAGE,null, new Object[]{"Por nombre","Por telefono"},null);
                String conopc=conopcs.toString();
                
                if(conopc.equals("Por nombre")){
                    
                    nom = JOptionPane.showInputDialog(null,"Busque la persona deseada","Consulta",JOptionPane.QUESTION_MESSAGE);
                    //nom=listNom.toString();
                    
                    JTextArea areSal = new JTextArea();
                    areSal.setText(agen.damePerso(nom));
                    
                    JOptionPane.showMessageDialog(null,areSal,"Consulta",JOptionPane.INFORMATION_MESSAGE);
                }else if(conopc.equals("Por telefono")){
                    
                    String tel = JOptionPane.showInputDialog(null,"Seleccione el telefono para consultar su informacion","Consulta",JOptionPane.QUESTION_MESSAGE);
                    
                    JTextArea areSal = new JTextArea();
                    areSal.setText(agen.dameTel(tel));
                    
                    JOptionPane.showMessageDialog(null,areSal,"Consulta",JOptionPane.INFORMATION_MESSAGE);
                }
                

            } else if (opc.equals("Eliminar")) {
                
                Object eli = JOptionPane.showInputDialog(null,"Seleccione a la persona que quiere eliminar","Eliminar",JOptionPane.QUESTION_MESSAGE,null,agen.darListaPerso(),null);
                nom=eli.toString();
                
                agen.eliminar(nom);
                JOptionPane.showMessageDialog(null,"Se ha eliminado la informacion de "+nom,"Eliminar",JOptionPane.INFORMATION_MESSAGE);

            } else if (opc.equals("Visualizar")) {
                //Vizualizacion de datos
                if (agen.tamAge() > 0) {
                    //Se crea un espacio de salida de texto
                    JTextArea areSal = new JTextArea();
                    areSal.setText(agen.toString());

                    JOptionPane.showMessageDialog(null, areSal, "Directorio Telefonico", JOptionPane.INFORMATION_MESSAGE);
                    //Se limpia el area de salida
                    areSal.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error, la agenda esta vacia...", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                }
            }else if(opc.equals("Salir"))
                JOptionPane.showMessageDialog(null,"Hasta luego!","Mensaje de salida",JOptionPane.INFORMATION_MESSAGE);
        } while (!opc.equals("Salir"));

        System.exit(0);
    }//metodo main

    static boolean valiNum(String numTel) {
        boolean telVal = true;

        for (int i = 0; i < numTel.length(); i++) {
            if (!Character.isDigit(numTel.charAt(i))) {
                i = numTel.length() + 1;
                telVal = false;
            }
        }
        return telVal;
    }

}
