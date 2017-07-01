
package leerarchivo;

import java.io.FileInputStream;
import java.io.IOException;

public class LeerArchivo {

    public static void main(String[] args) {
        
        try(FileInputStream fis=new FileInputStream("C:\\Users\\aldom\\Documents\\Código\\hello-world\\bytes.txt")){
 
            int valor=fis.read();
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fis.read();
            }
 
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
            System.exit(1);
        }  
        System.exit(0);
    }
    
}
