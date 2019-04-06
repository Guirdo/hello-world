package mx.edu.itch.sistemas.seblab.InterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;

public class Presentacion extends JDialog {
    
    public static final String RESTRICCION = "wrap";
    public static final String RESTRICCION_COLS = "20[]20";
    public static final String RESTRICCION_FILAS = "20[][100:150:][]20";
    
    private Boton btnContinuar;
    private JLabel lblTitulo;
    private AreaTexto taDescripcion;
    
    public Presentacion(String titulo, String descripcion, LayoutManager layoutManager) {
        this.setModal(true);
        this.setTitle("Presentación");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(layoutManager);

        lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Arial", 1, 20));
        taDescripcion = new AreaTexto(2, 20, false, new Font("Arial", 0, 14), null);
        taDescripcion.setBackground(this.getContentPane().getBackground());
        taDescripcion.setText(descripcion);
        btnContinuar = new Boton("Continuar", Color.decode("#32cd32"), Color.decode("#f0ffff"));
        btnContinuar.addActionListener((ActionEvent) -> {
            this.dispose();
        });

        this.add(lblTitulo, "center");
        this.add(taDescripcion, "pushy,pushx,growx");
        this.add(btnContinuar, "right");

        this.pack();
        this.setLocationRelativeTo(null);
    }
}
