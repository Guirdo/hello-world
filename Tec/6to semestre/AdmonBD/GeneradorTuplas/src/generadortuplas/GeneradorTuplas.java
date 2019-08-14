/*
 * Hola!
 */
package generadortuplas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class GeneradorTuplas {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<String> nombres = cargarLista("C:\\Users\\aldom\\Documents\\Codigo\\hello-world\\Tec\\6to semestre\\AdmonBD\\GeneradorTuplas\\src\\archivos\\nombresPersonas.txt");
        ArrayList<String> apellidos = cargarLista("C:\\Users\\aldom\\Documents\\Codigo\\hello-world\\Tec\\6to semestre\\AdmonBD\\GeneradorTuplas\\src\\archivos\\apellidosPersonas.txt");

//        String[] nombres = {"Pablo","Edgar","Ignacio","Virginia","Octavio","Michael","Carlos",
//                            "Rosario","Jose","Ernest","Juana","Vicente","Juan","Eduardo","Gabriela","Emily",
//                            "Satori","LiPo","Manuel","Isacc","Platon"};
//        String[] apellidos = {"Neruda","Poe","Altamirano","Woolf","Paz","Ende","Pellicer",
//                            "Castellanos","Revueltas","Hemingway","Ibarbourou","Huidobro"};

        String comando = "insert into nomTabla";
        Random rnd = new Random();

        int numIteraciones = 1000;
        boolean iniciado = false;

        int dia,mes;
        String fecha;
        for (int i = 0; i <numIteraciones; i++) {
            
            dia = rnd.nextInt(28)+1;
            mes = rnd.nextInt(3)+1;
            
            fecha = "2019-"+mes+"-"+dia;
            
            comando += generarTupla(iniciado,
                    nombres.get(rnd.nextInt(nombres.size())),
                    apellidos.get(rnd.nextInt(apellidos.size())),
                    generarCadenaAleatoria(10), generarCadenaAleatoria(20)) + 
                    ",\n";
            if(!iniciado){
                iniciado=true;
            }
        }

        System.out.println(comando);
        
        

    }
    
    private static ArrayList<String> cargarLista(String ruta){
        ArrayList<String> lista = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String cadena="";
            
            while((cadena=br.readLine())!=null){
                lista.add(cadena);
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return lista;
    }

    public static String generarTupla(boolean iniciado, String... cadenas) {
        String salida = "";

        if (!iniciado) {
            salida += " (col1";
            if (cadenas.length > 1) {
                for (int i = 1; i < cadenas.length; i++) {
                    salida += ",col" + (i + 1);
                }
                salida += ") values\n";
            } else {
                salida += ") values\n";
            }
        }

        String inicioTupla = "('";
        String finTupla = "')";
        String sep = "','";

        salida += inicioTupla + cadenas[0];

        if (cadenas.length > 1) {
            for (int i = 1; i < cadenas.length; i++) {
                salida += sep + cadenas[i];
            }
            salida += finTupla;
        } else {
            salida += finTupla;
        }

        return salida;
    }
    
    /*
    ----------Trabajador
    nombres[rnd.nextInt(nombres.length)],
                    apellidos[rnd.nextInt(apellidos.length)]+" "+apellidos[rnd.nextInt(apellidos.length)],
                    generarCadenaAleatoria(10)
    -------------Usuario
    nombres[rnd.nextInt(nombres.length)]+" "+nombres[rnd.nextInt(nombres.length)],
                    apellidos[rnd.nextInt(apellidos.length)]+" "+apellidos[rnd.nextInt(apellidos.length)],
                    generarCadenaAleatoria(10), generarCadenaAleatoria(20)
    -----------Autor
    nombres[rnd.nextInt(nombres.length)],
                    apellidos[rnd.nextInt(apellidos.length)]
    ----------Libro
    "titulo",(rnd.nextInt(50)+1)+"",generarCadenaAleatoria(15)
    ---------Presta libro
    ""+(rnd.nextInt(50)+1),fecha,"date '"+fecha+"' + integer '7'",""+(rnd.nextInt(50)+1)
    */

    public static String generarCadenaAleatoria(int tamano) {
        Random ran = new Random();
        String salida = "";
        Pattern pattern = pattern = Pattern.compile("\\w");
        Matcher matcher;

        for (int i = 0; i < tamano; i++) {
            String c = "";
            do {
                c = Character.toString((char) ran.nextInt(91)) + "";
                matcher = pattern.matcher("" + c);
            } while (!matcher.matches());
            salida += c;
        }

        return salida;
    }

}
