package demoempre1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DemoEmpre1 {
    
    //Permite aumentar el sueldo a un empleado en particular
    public static void aumentarSueldo(String nombre,ArrayList arrayEmp){
        double aumento=0.0;
        Class[] para = {double.class};
        
        if(arrayEmp.indexOf(nombre)!= -1){
            
            if(arrayEmp.indexOf(nombre). instanceof Directivo){
                
            }
            
            aumento = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el aumento a aplicar al empleado","Aumento",JOptionPane.QUESTION_MESSAGE));
            arrayEmp.get(arrayEmp.indexOf(nombre)).getClass();
        }
        
        System.out.println(arrayEmp.indexOf(nombre));
         
    }
    //Aumentar el sueldo a todos los empleados

    public static void main(String[] args) {
        /*Apoyo aux = new Apoyo("Auxiliar administrativo","","Apoyo",8456.78,"Darío Madrazo Pintado","Masculino",23);
        Directivo jefe = new Directivo ("Auxiliar administrativo",123456.32,"","Apoyo",8456.78,"Darío Madrazo Pintado","Masculino",23);
        
        System.out.println("\n-Datos dempleados: \n"+
                           aux.toString()+"\n"+
                           jefe.toString()+"\n");*/

        String nombre, sexo, tipoPuesto, nomPuesto;
        int edad;
        double sueldo, presupuesto;
        String cadTitulo = "Datos personales";

        ArrayList arrayEmp = new ArrayList<>();
        ArrayList <Apoyo> listaApo = new ArrayList<>();
        ArrayList <Directivo> listaDir = new ArrayList<>();

        try {
            int resp = 0;
            while (resp == 0) {
                nombre = JOptionPane.showInputDialog(null, "Nombre", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
                Object sexos = JOptionPane.showInputDialog(null, "Sexo", "Entrada de datos", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Masculino", "Femenino"}, "Femenino");
                sexo = sexos.toString();
                edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                Object tipoP = JOptionPane.showInputDialog(null, "Tipo de puesto", "Entrada de datos", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Apoyo", "Directivo"}, null);
                tipoPuesto = tipoP.toString();
                sueldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Sueldo", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));

                if (tipoPuesto.equals("Directivo")) {
                    presupuesto = Double.parseDouble(JOptionPane.showInputDialog(null, "Presupuesto", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));

                    Directivo direc = new Directivo(tipoPuesto, presupuesto, tipoPuesto, sueldo, nombre, sexo, edad);

                    if (/*arrayEmp.add(direc)*/listaDir.add(direc)) {
                        JOptionPane.showMessageDialog(null, "El empleado ha sido ingresado...", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    Apoyo apo = new Apoyo(tipoPuesto, tipoPuesto, sueldo, nombre, sexo, edad);

                    if (/*arrayEmp.add(apo)*/listaApo.add(apo)) {
                        JOptionPane.showMessageDialog(null, "El empleado ha sido ingresado...", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                resp = JOptionPane.showOptionDialog(null, "¿Desea ingresar otro empleado?", cadTitulo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, null);
            }
            
            int opc = JOptionPane.showOptionDialog(null,"Seleccione el aumento que desea aplicar","Aumento",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object []{"Empleado en especifico","Todo el personal","Continuar"},null);
            switch(opc){
                case 0:
                    String nom = JOptionPane.showInputDialog(null,"Realice la busqueda del empleado","Busqueda",JOptionPane.QUESTION_MESSAGE);
                    
                    aumentarSueldo(nom,arrayEmp);
                    
                    break;
            }
            
            for(int i=0;i<listaApo.size();i++){
                arrayEmp.add(listaApo.get(i));
            }
            for(int i=0;i<listaDir.size();i++){
                arrayEmp.add(listaDir.get(i));
            }
            
            //Salida de datos
            String sal = "";

            for (Object o : arrayEmp) {
                sal += o.toString();
            }

            JOptionPane.showMessageDialog(null, sal, cadTitulo, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, los datos deben ser numericos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }

}
