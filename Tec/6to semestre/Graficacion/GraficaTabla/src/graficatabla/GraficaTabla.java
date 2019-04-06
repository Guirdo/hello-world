/*
 * Hola!
 */
package graficatabla;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class GraficaTabla extends JFrame {

    private Lienzo lienzo;

    public GraficaTabla() {
        this.setTitle("GraficaTabla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new MigLayout());

        lienzo = new Lienzo();
        DefaultTableModel modelo = new DefaultTableModel(new String[]{"Nombre", "Promedio"}, 0);
        JTable tabla = new JTable(modelo);

        JTextField tfNombre = new JTextField(18);
        JButton btnIngresar = new JButton("Ingresar");
        SpinnerNumberModel spnModel = new SpinnerNumberModel(70, 0, 100, 1);
        JSpinner spnPromedio = new JSpinner(spnModel);

        JRadioButton rbBarra = new JRadioButton("Barras");
        JRadioButton rbPastel = new JRadioButton("Pastel");
        rbBarra.setBackground(Color.WHITE);
        rbBarra.setSelected(true);
        rbPastel.setBackground(Color.WHITE);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbBarra);
        bg.add(rbPastel);

        btnIngresar.addActionListener((ActionEvent) -> {
            String nombre = tfNombre.getText();
            int promedio = (int) spnModel.getValue();
            modelo.addRow(new Object[]{nombre, promedio});

            tfNombre.setText("");
            tfNombre.requestFocus();
        });

        JButton btnGraficar = new JButton("Graficar");
        btnGraficar.addActionListener((ActionEvent) -> {

            if (modelo.getRowCount() > 0) {

                String[] nombres = new String[modelo.getRowCount()];
                int[] calificaciones = new int[modelo.getRowCount()];
                int acum = 0;

                for (int i = 0; i < modelo.getRowCount(); i++) {
                    nombres[i] = modelo.getValueAt(i, 0).toString();
                    calificaciones[i] = (int) modelo.getValueAt(i, 1);
                    acum += calificaciones[i];
                }

                if (rbBarra.isSelected()) {
                    lienzo.dibujarBarras(calificaciones, nombres);
                } else {
                    lienzo.dibujarPastel(calificaciones, nombres, acum);
                    //lienzo.ponerEtiquetas(calificaciones, nombres);
                }
            }

        });

        JButton btnExportar = new JButton("Exportar grafica");
        btnExportar.addActionListener((ActionEvent) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("Imagenes png", "png"));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            int opcion = chooser.showSaveDialog(this);

            if (opcion == 0) {
                File file = chooser.getSelectedFile();
                try {
                    ImageIO.write(lienzo.crearImagen(), "png", file);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.add(new JLabel("Introduzca datos del alumno"), "span 2");
        this.add(new JLabel("Tabla de datos"), "pushx,wrap");

        JLabel lbl_1 = new JLabel("Nombre: ");
        lbl_1.setFont(new Font("Arial", 0, 13));
        this.add(lbl_1, "left,sg a,split 2");
        this.add(tfNombre, "pushx,growx,sg b");

        this.add(new JScrollPane(tabla),
                "span 2 3,gapleft 15,width 350:350:,height 185:185:,pushx,growx,wrap");

        JLabel lbl_2 = new JLabel("Promedio: ");
        lbl_2.setFont(new Font("Arial", 0, 13));
        this.add(lbl_2, "left,sg a,split 2");
        this.add(spnPromedio, "pushx,growx,sg b,wrap");

        this.add(btnIngresar, "right,top,split 2,wrap");

        JLabel txtGrafica = new JLabel("Grafica");
        txtGrafica.setFont(new Font("Arial", 1, 20));
        this.add(txtGrafica, "wrap");

        this.add(lienzo, "width 375,height 350,span 2 5");

        this.add(new JLabel("Tipo de graficas"), "wrap,center,left,gapy 40");
        this.add(rbBarra, "center,sg c,gapy 10,left,wrap");
        this.add(rbPastel, "center,sg c,left,wrap");
        this.add(btnGraficar, "center,gapy 10,top,wrap");
        this.add(btnExportar, "center,bottom,gapy 10,wrap");

        this.pack();
        this.setLocationRelativeTo(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new GraficaTabla().setVisible(true);
    }

}
