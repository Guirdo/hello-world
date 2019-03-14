package actividad4;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Presentacion extends JDialog{

    public Presentacion(){
        this.setTitle("Presentacion");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setModal(true);
        
        JPanel panelPresentacion = new JPanel();
        panelPresentacion.setLayout(new BoxLayout(panelPresentacion, BoxLayout.Y_AXIS));
        
        JLabel titulo = new JLabel("Actividad 4");
        titulo.setFont(new Font("Arial",1,20));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JTextArea descripcion = new JTextArea(5,22);
        descripcion.setText("Programa que codifica o decodifica un mensaje por medio del algoritmo RC4, permitiendo guardar el archivo codificado.");
        descripcion.setEditable(false);
        descripcion.setFont(new Font("Arial",0,13));
        descripcion.setBackground(this.getBackground());
        descripcion.setBorder(new EmptyBorder(2, 5, 0, 5));
        descripcion.setLineWrap(true);
        descripcion.setWrapStyleWord(true);
        descripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnContinuar.addActionListener((ActionEvent)->{
            this.dispose();
        });
        
        panelPresentacion.add(titulo);
        panelPresentacion.add(Box.createRigidArea(new Dimension(0,15)));
        panelPresentacion.setBorder(new EmptyBorder(10,15,10,15));
        panelPresentacion.add(descripcion);
        panelPresentacion.add(Box.createRigidArea(new Dimension(0,15)));
        panelPresentacion.add(btnContinuar);
        
        this.add(panelPresentacion);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}
