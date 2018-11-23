/*
 * Hola!
 */
package serverserpienteescalera;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class ServerSerpienteEscalera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocket ss;
        Socket j;
        Mensajes mc = new Mensajes();
        String comando="";
        Scanner sc = new Scanner(System.in);
        int cont=0;

        try {
            ss = new ServerSocket(4000);
            while(cont<2){
                System.out.println("Esperando cliente #:"+cont);
                j = ss.accept();
                System.out.println("Cliente #"+cont+" conectado");
                
                ConexionCliente cs = new ConexionCliente(j,mc);
                cs.start();
                cont++;
            }
            
            while(!comando.equals("/s")){
                comando = sc.nextLine();
            }
            
            System.exit(0);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
