package directorio;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;

public class AutoGuardado extends Thread {

    //Atributos
    private DataOutputStream salida;
    private PrintWriter salidaTxt;
    private Calendar tiempo;
    private int hora, minutos, segundos;
    private String salHora, salMin, salSeg;
    private Timer reloj;
    public static volatile boolean detener;

    public AutoGuardado() {
        hora = 0;
        minutos = 0;
        segundos = 0;
        salHora = "";
        salMin = "";
        salSeg = "";
        detener = false;
    }

    public void run() {
        try {
            while (true) {
                if (!detener) {
                    Thread.sleep(37000);
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
                    Thread.sleep(3000);
                    Directorio.mensaje.setText("");
                }
            }
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
