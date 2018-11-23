package directorio;

import java.awt.Font;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Cerrando extends JDialog{
    
    private boolean cerrar;
    private JButton guardar,noGuardar,cancelar;
    private JLabel mensaje;
    private DataOutputStream salida;
    private File borrar = new File("src\\datostmp.dat");
    

    public Cerrando() {
        setTitle("Guardar");
        setSize(350,150);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                
        mensaje = new JLabel("¿Desea guardar los cambios?");
        mensaje.setBounds(75,20, 200, 20);
        mensaje.setFont(new Font("Arial",0,14));
        
        guardar = new JButton("Guardar");
        guardar.setBounds(20, 60, 80, 25);
        guardar.addActionListener((ActionEvent)-> {
            try {
                salida = new DataOutputStream(new FileOutputStream("src\\datos.dat"));
                for (int i = 0; i < Directorio.getListaPersona().size(); i++) {
                    salida.writeUTF(Directorio.getListaPersona().get(i).getNombre());
                    salida.writeInt(Directorio.getListaPersona().get(i).getEdad());
                }
                salida.close();  
                borrar.delete();
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            System.exit(0);
        });
        
        noGuardar = new JButton("No guardar");
        noGuardar.setBounds(110,60, 100, 25);
        noGuardar.addActionListener((ActionEvent)->{
            borrar.delete();
            System.exit(0);
        });
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(220, 60, 90, 25);
        cancelar.addActionListener((ActionEvent)->{
            dispose();
        });
        
        add(mensaje);
        add(guardar);
        add(noGuardar);
        add(cancelar);
    }
    
}
