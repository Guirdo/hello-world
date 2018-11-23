package directorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class AutoGuardado extends Thread {

    //Atributos
    private DataOutputStream salida;
    private PrintWriter salidaTxt;
    private Calendar tiempo;
    private int hora, minutos, segundos;
    private String salHora, salMin, salSeg;
    private Timer reloj;
    private DataInputStream entrada;
    public static volatile boolean detener;
    private static volatile int dormir;

    public AutoGuardado() {
        hora = 0;
        minutos = 0;
        segundos = 0;
        salHora = "";
        salMin = "";
        salSeg = "";
        detener = true;
        
        try{
           entrada = new DataInputStream(new FileInputStream("src\\cfg.dat"));
           dormir = entrada.readInt();
           entrada.close();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
        
        reloj = new Timer(3000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Directorio.mensaje.setText("");
            }
        });
        reloj.setRepeats(false);
    }

    public void run() {
        try {
            while (true) {
                if (!detener) {
                    Thread.sleep(dormir*60000);
                    tiempo = new GregorianCalendar();
                    
                    salida = new DataOutputStream(new FileOutputStream("src\\datostmp.dat"));
                    for (int i = 0; i < Directorio.getListaPersona().size(); i++) {
                        salida.writeUTF(Directorio.getListaPersona().get(i).getNombre());
                        salida.writeInt(Directorio.getListaPersona().get(i).getEdad());
                    }
                    
                    salida.close();
                    
                    salidaTxt = new PrintWriter(new FileWriter("src\\datosRecuperacion.txt"));
                    salidaTxt.print(tiempo.getTime().toString());
                    salidaTxt.flush();
                    salidaTxt.close();

                    hora = tiempo.get(Calendar.HOUR_OF_DAY);
                    minutos = tiempo.get(Calendar.MINUTE);
                    segundos = tiempo.get(Calendar.SECOND);

                    if (hora < 10) {
                        salHora = "0" + hora;
                    } else {
                        salHora = "" + hora;
                    }

                    if (minutos < 10) {
                        salMin = "0" + minutos;
                    } else {
                        salMin = "" + minutos;
                    }

                    if (segundos < 10) {
                        salSeg = "0" + segundos;
                    } else {
                        salSeg = "" + segundos;
                    }

                    Directorio.mensaje.setText("Autoguardado: " + salHora + ":" + salMin + ":" + salSeg);
                    reloj.start();
                }
            }
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void setDormir(int segundos){
        AutoGuardado.dormir = segundos;
    }
    
}
