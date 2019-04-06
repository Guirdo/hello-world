package actividad6_1;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;

public class Presentacion extends JDialog{
    
    public Presentacion(){
        this.setModal(true);
        this.setTitle("Presentación");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new MigLayout("wrap","20[]20","20[][::150][]20"));
        
        JLabel titulo = new JLabel("Actividad 6");
        titulo.setFont(new Font("Arial",1,20));
        JTextArea descripcion = new JTextArea(3,20);
        descripcion.setEditable(false);
        descripcion.setLineWrap(true);
        descripcion.setWrapStyleWord(true);
        descripcion.setFont(new Font("Arial",0,14));
        descripcion.setBackground(this.getContentPane().getBackground());
        descripcion.setBorder(null);
        descripcion.setText("Programa divide una cadena segun el separador que el usuario ingrese."
                + "Entonces muestra una lista de las palabras que se obtienen como resultado de la separación.");
        JButton continuar = new JButton("Continuar");
        continuar.setBackground(Color.decode("#32cd32"));
        continuar.setForeground(Color.decode("#f0ffff"));
        continuar.addActionListener((ActionEvent)->{
            this.dispose();
        });
        
        this.add(titulo,"center");
        this.add(descripcion,"pushy,pushx,growx");
        this.add(continuar,"right");
        
        this.pack();
        this.setLocationRelativeTo(null);
    }

}
