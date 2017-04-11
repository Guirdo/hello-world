import javax.swing.*;

public class SexNomEdad {

    public static void main(String[] args) {
        int nPer,edad;
        String nombre,salida="";
        //Arreglo para hacer la lista de seleccion, con valores predefinidos
        String [] sex= {"Masculino","Femenino","Intermedio"};

        //Establece la longitud del arreglo
        nPer=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de personas: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));

        //Comprueba que el arreglo por lo menos tengo un elemento
        if(nPer > 0){
            //Declaracion y creacion de los arreglos
            String [] nombres=new String[nPer];
            int [] edades= new int [nPer];
            String [] sexo= new String[nPer];

            //Ciclo para la obtencion de datos
            for(int ind=0;ind<nombres.length;ind++){

                //Ciclo para validar antes de guarda el dato en el arreglo
                do{
                    nombre=JOptionPane.showInputDialog(null,"Ingrese el nombre de la persona #"+(ind+1)+": ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE);
                    if(nombre == "")
                        JOptionPane.showMessageDialog(null,"Error, debe ingresar por lo menos un caracter...","Error...",JOptionPane.ERROR_MESSAGE);
                }while(nombre == "");
                //Ciclo para validar antes de guarda el dato en el arreglo
                do{
                    edad=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la edad de la persona #"+(ind+1)+": ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));
                    if(edad < 1 && edad > 120)
                        JOptionPane.showMessageDialog(null,"Error, debe ingresar una edad valida (1-120 años)","Error...",JOptionPane.ERROR_MESSAGE);
                }while(edad < 1 && edad > 120);

                //Variable tipo objeto auxiliar para guardar el genero seleccionado
                Object objSex=JOptionPane.showInputDialog(null,"Seleccion el genero: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE,null,sex,"Femenino");

                //Despues de validar los datos ingresados, estos se guardan en los arreglos
                nombres[ind]=nombre;
                edades[ind]=edad;
                sexo[ind]=objSex.toString();
            }

            //Ciclo que va haciendo una lista con los datos
            for(int indi=0;indi<nombres.length;indi++){//(ind+1) es para que muestre a la persona 0 como 1, solo para que se vea "bien"
               salida+=(indi+1)+". "+"   "+nombres[indi]+"   "+edades[indi]+"  "+sexo[indi]+"\n";
            }

            JOptionPane.showMessageDialog(null,salida,"Resultado",JOptionPane.INFORMATION_MESSAGE);

        }else{//Else que muestras cual es el error porque puso numero de elementos menor o igual a 0
            JOptionPane.showMessageDialog(null,"Error... el numero de personas debe ser mayor a cero","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }

}
