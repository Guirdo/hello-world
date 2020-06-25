package servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Santiago Avila Jimenez
 */

public class MainServer {

    public static void main(String[] args) {
        int PORT = 5000;
        try {
            //Socket de servidor para esperar peticiones de la red
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor> Servidor iniciado");
            System.out.println("Servidor> En espera de cliente...");
            //Socket de cliente
            Socket clientSocket;

            while (true) {
                clientSocket = serverSocket.accept();
                //Para leer lo que envie el cliente
                System.out.println("Cliente conectado");
                //Se obtiene el flujo entrante desde el cliente
                DataInputStream input1 = new DataInputStream(clientSocket.getInputStream());
                //Se obtiene el flujo de salida del cliente para enviarle mensajes
                DataOutputStream salidaCliente = new DataOutputStream(clientSocket.getOutputStream());

                //se lee peticion del cliente
                String clienteDice = input1.readUTF();
                System.out.println("Cliente:" + clientSocket.getInetAddress().getHostAddress() + "> dice ["
                        + clienteDice + "]");

                salidaCliente.flush();//vacia contenido

                switch (clienteDice) {
                    case "Como estas":
                        salidaCliente.writeUTF("Bien y tu");
                        break;
                    case "Saludos":
                        salidaCliente.writeUTF("gracias");
                        break;
                    case "Nos vemos":
                        salidaCliente.writeUTF("Ok");
                        break;
                    case "Quien eres":
                        salidaCliente.writeUTF("Santiago Avila Jimenez");
                        break;
                    default:
                        salidaCliente.writeUTF(clienteDice);
                        break;
                }

                // cierra conexion
                clientSocket.close();
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
