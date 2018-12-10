package serverserpienteescalera;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class ConexionCliente extends Thread implements Observer {

    private Socket socket;
    private static String jugador1 = "";
    private static String jugador2 = "";
    private Mensajes mensajes;
    private String mensajeRecibido;
    private DataInputStream entradaDatos;
    private DataOutputStream salidaDatos;

    public ConexionCliente(Socket s, Mensajes m) {
        socket = s;
        mensajes = m;

        try {
            entradaDatos = new DataInputStream(s.getInputStream());
            salidaDatos = new DataOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void run() {
        boolean conectado = true;
        String array[] = new String[2];
        String mensajeEnviado = "";
        // Se apunta a la lista de observadores de mensajes
        mensajes.addObserver(this);

        while (conectado) {
            try {
                // Lee un mensaje enviado por el cliente
                mensajeRecibido = entradaDatos.readUTF();

                array = mensajeRecibido.split("@");

                switch (array[0]) {
                    case "clienteNom":
                        if (ConexionCliente.jugador1.isEmpty()) {
                            ConexionCliente.jugador1 = array[1];
                            mensajeEnviado = "serverTurno@true";
                        } else {
                            ConexionCliente.jugador2 = array[1];
                            mensajeEnviado = "serverTurno@false";
                        }
                        break;
                    case "clientePideNom":
                        mensajeEnviado = "serverDaNom@"+ConexionCliente.jugador1+"#"+ConexionCliente.jugador2;
                        break;
                    default:
                        mensajeEnviado=mensajeRecibido;
                }

                // Pone el mensaje recibido en mensajes para que se notifique 
                // a sus observadores que hay un nuevo mensaje.
                mensajes.setMensaje(mensajeEnviado);
            } catch (IOException ex) {

                conectado = false;
                // Si se ha producido un error al recibir datos del cliente se cierra la conexion con el.
                try {
                    entradaDatos.close();
                    salidaDatos.close();
                } catch (IOException ex2) {

                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            // Envia el mensaje al cliente
            salidaDatos.writeUTF(arg.toString());
        } catch (IOException ex) {

        }
    }

}
