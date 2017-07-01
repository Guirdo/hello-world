/*
 * Hola!
 */
package escribematriz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class EscribeMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        DataInputStream dis = null;
        
        int filas,col,i,j;
        
        try{
            fos = new FileOutputStream("C:\\Users\\aldom\\Documents\\Código\\hello-world\\matriz.dat");
            salida = new DataOutputStream(fos);
            
            do{
                System.out.print("Numero de filas: ");
                filas = sc.nextInt();
            }while(filas <= 0);
            
            do{
                System.out.print("Numero de columnass: ");
                col = sc.nextInt();
            }while(col <= 0);
            
            double[][] matriz = new double[filas][col];
            
            for(i=0;i<filas;i++){
                for(j=0;j<col;j++){
                    System.out.print("Matriz["+i+"]["+j+"]: ");
                    matriz[i][j]=sc.nextDouble();
                }
            }
            
            salida.writeInt(filas);
            salida.writeInt(col);
            
            for(i=0;i<filas;i++){
                for(j=0;j<col;j++){
                    salida.writeDouble(matriz[i][j]);
                }
            }
            
            System.out.print("La matriz ha sido guardada en el archivo binario.");
            
           dis = new DataInputStream(new FileInputStream("C:\\Users\\aldom\\Documents\\Código\\hello-world\\matriz.dat"));
           
           int filas1 = dis.readInt();
           int col1 = dis.readInt();
           
           double [][] matrizLeida = new double[filas1][col1];
           
           for(int r = 0; r<filas;r++){
               for(int m=0;m<col1;m++){
                   matrizLeida[r][m]=dis.readDouble();
               }
           }
           
          for(int r = 0; r<filas;r++){
               for(int m=0;m<col1;m++){
                   System.out.println("["+r+"]["+m+"]"+matrizLeida[r][m]);
               }
           }
           
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error: "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: "+ex.getMessage());
        } catch(InputMismatchException ex){
            System.out.println("Error: "+ex.getMessage());
        }finally{
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException ex) {
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        }
    }
    
}
