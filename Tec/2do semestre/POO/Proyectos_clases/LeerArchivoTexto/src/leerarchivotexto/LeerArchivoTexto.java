/*
 * Hola!
 */
package leerarchivotexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class LeerArchivoTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FileReader fr = null;
        String contenido = "", cadena;

        try {
            fr = new FileReader("C:\\Users\\aldom\\Documents\\Código\\hello-world\\bytes.txt");
            BufferedReader entrada = new BufferedReader(fr);

            while ((cadena = entrada.readLine()) != null) {
                contenido += cadena + "\n";
            }
            
            JOptionPane.showMessageDialog(null,contenido,"Contenido",JOptionPane.INFORMATION_MESSAGE);

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }finally{
            try{
                if(fr!=null){
                    fr.close();
                }
            }catch(IOException e){
                JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
            }
        }
    }

}
