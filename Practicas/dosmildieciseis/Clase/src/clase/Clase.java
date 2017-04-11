package clase;

import java.util.StringTokenizer;
import javax.swing.*;

public class Clase {

    public static void main(String[] args) {
        int nPer,edad,mas=0,fem=0,indf=0;
        int infan=0,nin=0,adol=0,juv=0,adul=0,adm=0,nom1=0,nom2=0,nom3=0;
        String nombre,salida="",nom=""; 
        //Arreglo para hacer la lista de seleccion, con valores predefinidos
        String [] sex= {"Masculino","Femenino","Intermedio"};
        StringTokenizer st;

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
                    if(nombre.equals(""))//Mensaje de error
                        JOptionPane.showMessageDialog(null,"Error, debe ingresar por lo menos un caracter...","Error...",JOptionPane.ERROR_MESSAGE);
                    else//Se almacena en el arreglo
                        nombres[ind]=nombre;
                }while(nombre.equals(""));
                //Ciclo para validar antes de guarda el dato en el arreglo
                do{
                    edad=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la edad de la persona #"+(ind+1)+": ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE));
                    if(edad < 1 || edad > 120)
                        JOptionPane.showMessageDialog(null,"Error, debe ingresar una edad valida (1-120 años)","Error...",JOptionPane.ERROR_MESSAGE);
                    else
                        edades[ind]=edad;
                }while(edad < 1 || edad > 120);
                
                Object objSex=JOptionPane.showInputDialog(null,"Seleccion el genero: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE,null,sex,"Femenino");
                sexo[ind]=objSex.toString();  
            }
            
            //Ciclo que va haciendo una lista con los datos
            for(int indi=0;indi<nombres.length;indi++){//(ind+1) es para que muestre a la persona 0 como 1, solo para que se vea "bien"
               salida+=(indi+1)+". "+"   "+nombres[indi]+"   "+edades[indi]+"  "+sexo[indi]+"\n";
            }
            
            //Resultado de todas personas en una sola ventana
            JOptionPane.showMessageDialog(null,salida,"Resultado",JOptionPane.INFORMATION_MESSAGE);
            
            //Numero de generos
            for(int c = 0;c<sexo.length;c++){
                if(sexo[c].equals("Masculino"))//SEX[C] =="Masculino"
                    mas++;
                else if(sexo[c].equals("Femenino"))
                    fem++;
                else
                    indf++;
            }
            
            //Contabilizacion de las etapas de vida
            for(int d=0;d<edades.length;d++){
                if(edades[d]>=1 && edades[d]<=6)
                    infan++;
                else if(edades[d]>=7 && edades[d]<=11)
                    nin++;
                else if (edades[d]>=12 && edades[d]<=20)
                    adol++;
                else if (edades[d]>=21 && edades[d]<=25)
                    juv++;
                else if (edades[d]>=26 && edades[d]<=60)
                    adul++;
                else
                    adm++;
            }
            
            //Ciclo que cuenta el numero de nombres que tiene la persona
            for(int f=0;f<nombres.length;f++){
                nom=nombres[f];
                st=new StringTokenizer(nom);
                if(st.countTokens()==3 || st.countTokens()==2)
                    nom1++;
                else if(st.countTokens()==4)
                    nom2++;
                else if(st.countTokens()-2>=3)
                    nom3++;
            }
            
            //Mensaje de resultados
            JOptionPane.showMessageDialog(null,"Masculinos: "+mas+
                                                "\nFemeninas: "+fem+
                                                "\nIntermedio: "+indf,"Resultados",JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null,"- Infantes: "+infan+
                                                "\n- Niños: "+nin+
                                                "\n- Adolecentes: "+adol+
                                                "\n- Jovenes: "+juv+
                                                "\n- Adultos: "+adul+
                                                "\n- Adultos mayores: "+adm,"Resultados...",JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null,"Personas con un solo nombre: "+nom1+
                                                "\nPersonas con dos nombres: "+nom2+
                                                "\nPersonas con tres o más nombres: "+nom3,"Resultados",JOptionPane.INFORMATION_MESSAGE);
            
        }else{//Else que muestras cual es el error porque puso numero de elementos menor o igual a 0
            JOptionPane.showMessageDialog(null,"Error... el numero de personas debe ser mayor a cero","Mensaje de error...",JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }
    
}
