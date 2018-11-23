package directorio;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;

public class Configuracion extends JDialog implements WindowListener{
    
    private JButton aceptar,cancelar;
    private JSpinner spnMinutos;
    private JLabel texto1;
    private File archivoCFG = new File("src\\cfg.dat");
    private DataInputStream entrada;
    private DataOutputStream salida;
    private int minutos;
    
    public Configuracion(){
        this.setTitle("Configuración");
        this.setSize(300,160);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setModal(true);
        
        try{
            entrada = new DataInputStream(new FileInputStream(archivoCFG));
            minutos = entrada.readInt();
            entrada.close();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
        
        //Label
        texto1 = new JLabel("Autoguardar información cada: ");
        texto1.setBounds(20, 25, 185, 25);
        
        //Spinner
        spnMinutos = new JSpinner();
        spnMinutos.setBounds(210, 25, 50, 25);
        spnMinutos.setModel(new SpinnerNumberModel(minutos,1,30,1));
        spnMinutos.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                minutos = (int) spnMinutos.getValue();
            }
        });
        
        //Boton aceptar
        aceptar = new JButton("Aceptar");
        aceptar.setBounds(40, 75, 90, 25);
        aceptar.addActionListener((ActionEvent)->{
            try{
                salida = new DataOutputStream(new FileOutputStream(archivoCFG));
                salida.writeInt(minutos);
                salida.close();
                AutoGuardado.setDormir(minutos);
                dispose();
            }catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            }
        });
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(140,75, 90, 25);
        cancelar.addActionListener((ActionEvent)->{
            dispose();
        });
        
        add(spnMinutos);
        add(texto1);
        add(aceptar);
        add(cancelar);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
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
