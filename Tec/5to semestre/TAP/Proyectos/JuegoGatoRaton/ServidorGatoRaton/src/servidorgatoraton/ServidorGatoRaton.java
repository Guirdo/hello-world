/*
 * Hola!
 */
package servidorgatoraton;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class ServidorGatoRaton {

    public static void main(String[] args) {
        ServerSocket server;
        MensajesChat mc = new MensajesChat();
        Scanner sc = new Scanner(System.in);
        int cont=0;
        String comando="";

        try {
            System.out.println("SERVER ENCENDIDO");
            server = new ServerSocket(9000);
            
            while(cont<2){
                System.out.println("Esperando cliente "+cont);
                Socket s = server.accept();
                System.out.println("Cliente "+cont+" conectado");
                
                ConexionCliente h = new ConexionCliente(s,mc);
                h.start();
                cont++;
            }
            
            while(!comando.equals("/s")){
                comando = sc.nextLine();
            }
            
            server.close();
        } catch (IOException e) {

        }

    }

}
