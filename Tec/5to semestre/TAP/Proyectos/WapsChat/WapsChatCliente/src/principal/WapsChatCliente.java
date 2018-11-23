package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WapsChatCliente extends JFrame implements WindowListener{
    
    //Atributos
    private JTextArea areaEscribir;
    public static JTextArea chat;
    private JButton enviar;
    private String nombreUsuario,mensaje;
    public static Socket cs;
    public static volatile boolean apagar;
    private DataOutputStream salida;
    
    public WapsChatCliente(){
        setTitle("WapsChat");
        setSize(360,330);
        //this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.addWindowListener(this);
        apagar=false;
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#BBDCC7"));
        
        chat = new JTextArea();
        chat.setEditable(false);
        chat.setLineWrap(true);
        chat.setWrapStyleWord(true);
        
        JScrollPane sclChat = new JScrollPane();
        sclChat.setBounds(12, 10, 320, 220);
        sclChat.setViewportView(chat);
        
        areaEscribir = new JTextArea();
        areaEscribir.setLineWrap(true);
        areaEscribir.setWrapStyleWord(true);
        JScrollPane sclEscribir = new JScrollPane();
        sclEscribir.setBounds(12, 240, 260, 40);
        sclEscribir.setViewportView(areaEscribir);
        
        enviar = new JButton("Enviar");
        enviar.setBounds(272,240,60,40);
        enviar.setFont(new Font("Arial",1,8));
        enviar.addActionListener((ActionEvent)->{
            mensaje = nombreUsuario+": "+areaEscribir.getText();
            areaEscribir.setText("");
            try {
                salida.writeUTF(mensaje);   
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        
        panel.add(sclChat);
        panel.add(sclEscribir);
        panel.add(enviar);
        this.add(panel);
        
        this.setIconImage(new ImageIcon(
                getClass().getResource("/imagenes/icono.png")
        ).getImage()
        );
    }
    
    public void iniciarSesion(){
        //nombreUsuario = JOptionPane.showInputDialog(null,"Ingrese nombre de usuario:","Bienvenido",JOptionPane.QUESTION_MESSAGE);
        LogIn lg = new LogIn();
        lg.setVisible(true);
        try {
            cs = new Socket(lg.getDireccionIP(),3000);
            nombreUsuario = lg.getNickName();
            salida = new DataOutputStream(cs.getOutputStream());            
            salida.writeUTF("Se ha conectado "+nombreUsuario);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void recibirMensajes(){
        DataInputStream entrada = null;
        String mensaje;
        try {
            entrada = new DataInputStream(cs.getInputStream());
        } catch (IOException ex) {
            
        } catch (NullPointerException ex) {
            
        }
        
        // Bucle infinito que recibe mensajes del servidor
        boolean conectado = true;
        while (conectado) {
            try {
                mensaje = entrada.readUTF();
                chat.setText(chat.getText()+mensaje+"\n");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                conectado = false;
            } catch (NullPointerException ex) {
                System.out.println(ex.getMessage());
                conectado = false;
            }
        }
    }
    
    public static void main(String[] args) {
        WapsChatCliente wcc = new WapsChatCliente();
        wcc.setVisible(true);
        wcc.iniciarSesion();
        wcc.recibirMensajes();
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Cerrando");
        apagar=true;
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
}
