package actividad5_1;

import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EditarDialog extends JDialog{
    private boolean editado=false;
    private String texto;
    
    public EditarDialog(String texto){
        this.setModal(true);
        this.setTitle("Editar texto");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        
        this.texto=texto;
        //this.setSize(400,400);

        //Panel del archivo y tabla
        JPanel pnlArchivo = new JPanel();
        pnlArchivo.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 8));
        JTextArea archivo = new JTextArea(25, 40);
        archivo.setBorder(BorderFactory.createTitledBorder("Archivo de texto"));
        archivo.setText(this.texto);
        archivo.setLineWrap(true);
        archivo.setWrapStyleWord(true);
        pnlArchivo.add(new JScrollPane(archivo));
        
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JButton btnGuardar = new JButton("Guardar cambios");
        JButton btnCancelar = new JButton("Cancelar");
        
        btnGuardar.addActionListener((ActionEvent)->{
            this.texto = archivo.getText();
            editado=true;
            this.dispose();
        });
        
        btnCancelar.addActionListener((ActionEvent)->{
            this.dispose();
        });
        pnlBotones.add(btnGuardar);
        pnlBotones.add(btnCancelar);
        
        this.add(pnlBotones);
        this.add(pnlArchivo);
        this.pack();
    }

    public boolean isEditado() {
        return editado;
    }

    public String getTexto() {
        return texto;
    }
    
    

}
