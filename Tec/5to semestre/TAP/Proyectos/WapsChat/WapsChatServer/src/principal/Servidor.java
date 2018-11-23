package principal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    //Atributos

    public static void main(String[] args) {
        ServerSocket server;
        MensajesChat mensajes = new MensajesChat();
        String comando="";
        Scanner sc = new Scanner(System.in);
        int contador;

        try {
            server = new ServerSocket(3000);
            
            contador = 0;

            while (contador<2) {
                System.out.println("Esperando conexion entrante...");
                Socket cs = server.accept();
                System.out.println("Cliente #" + contador + " conectado");
                
                ConexionCliente cc = new ConexionCliente(cs,mensajes);
                cc.start();
                contador++;
            }
            
            while(!comando.equals("/s")){
                comando=sc.nextLine();
                
            }
            
            server.close();
            System.exit(0);
        } catch (IOException ex) {

        }

    }

}
