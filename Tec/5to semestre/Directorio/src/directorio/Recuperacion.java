package directorio;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Recuperacion extends JDialog{
    
    private JLabel fecha,mensaje;
    private JButton si,no;
    public static boolean remplazar;

    public Recuperacion(String fechaRe) {
        setModal(true);
        setLayout(null);
        setTitle("Recuperación");
        setSize(275,170);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        
        remplazar = false;
        
        //mensaje
        mensaje = new JLabel("Se encontró un archivo de autoguardado");
        mensaje.setBounds(20, 20,300, 20);
        mensaje.setFont(new Font("Arial",0,12));
        
        //fecha
        fecha = new JLabel(fechaRe);
        fecha.setBounds(35,50, 200, 25);
        fecha.setFont(new Font("Arial",1,13));
        
        //Botones
        si = new JButton("Sí");
        si.setBounds(75, 90,50,25);
        si.addActionListener((ActionEvent)-> {
            remplazar = true;
            dispose();
        });
        
        no = new JButton("No");
        no.setBounds(130, 90, 50, 25);
        no.addActionListener((ActionEvent)-> {
            dispose();
        });
        
        add(mensaje);
        add(fecha);
        add(si);
        add(no);
    }
    
    
    
}
