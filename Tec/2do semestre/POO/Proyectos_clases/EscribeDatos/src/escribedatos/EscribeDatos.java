/*
 * Hola!
 */
package escribedatos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class EscribeDatos {

    /**
     * @param args the command line arguments
     */
    
    //Metodo que rellena las cadenas o las corta
    static String setLongitud(String cadena, int largoCad){
        if(cadena.length() < largoCad){
            for (int i = cadena.length(); i< largoCad;i++){
                cadena+=" ";
            }
        }else{
            cadena = cadena.substring(0, largoCad);
        }
        
        return cadena;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int sel,pos,continuar=0;
        long tamReg = 176;
        String nombre,telefono,eMail,edoCivil;
        int edad;
        
        try{
            RandomAccessFile archivo = new RandomAccessFile("datos.dat","rw");
            
            while(continuar==0){
                do{
                    pos = Integer.parseInt(JOptionPane.showInputDialog(null,"Posicion del registro","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
                }while(pos < 1);
                
                do{
                    nombre = JOptionPane.showInputDialog(null,"Nombre","Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                }while(nombre.isEmpty());
                nombre = setLongitud(nombre,35);
                
                do{
                    telefono = JOptionPane.showInputDialog(null,"Telefono","Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                }while(telefono.isEmpty());
                telefono = setLongitud(telefono,10);
                
                do{
                    eMail = JOptionPane.showInputDialog(null,"eMail","Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                }while(eMail.isEmpty());
                eMail = setLongitud(eMail,30);
                
                do{
                    edoCivil = JOptionPane.showInputDialog(null,"Estado civil","Entrada de datos",JOptionPane.QUESTION_MESSAGE);
                }while(edoCivil.isEmpty());
                edoCivil = setLongitud(edoCivil,11);
                
                do{
                    edad = Integer.parseInt(JOptionPane.showInputDialog(null,"Edad","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
                }while(edad<=0 || edad >120);
                
                archivo.seek(0);
                
                archivo.seek(tamReg*(pos-1));
                archivo.writeChars(nombre);
                archivo.writeChars(telefono);
                archivo.writeChars(eMail);
                archivo.writeChars(edoCivil);
                archivo.writeInt(edad);
                
                
                continuar = JOptionPane.showOptionDialog(null,"Desea ingresar otro dato?","Continuar?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
            }
            
            
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscribeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscribeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
