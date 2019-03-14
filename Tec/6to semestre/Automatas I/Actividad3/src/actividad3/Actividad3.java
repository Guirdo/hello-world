/*
 * Hola!
 */
package actividad3;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Actividad3 extends JFrame implements WindowListener {

    private JTextArea archivo;
    private ArrayList<String> lista;
    private DefaultTableModel modelo;
    private JTable tabla;
    private JFileChooser selectorArchivos;
    private JButton btnConteo, btnGenerar;
    private DefaultCategoryDataset dataset;
    private ChartFrame frame;

    public Actividad3() {
        this.setTitle("Actividad 3");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.addWindowListener(this);
        //this.setSize(400,400);

        selectorArchivos = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");
        selectorArchivos.setFileFilter(filtro);
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        //Panel del archivo y tabla
        JPanel pnlArchivo = new JPanel();
        pnlArchivo.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 8));
        archivo = new JTextArea(25, 40);
        archivo.setBorder(BorderFactory.createTitledBorder("Archivo de texto"));
        archivo.setEditable(false);
        archivo.setLineWrap(true);
        archivo.setWrapStyleWord(true);

        modelo = new DefaultTableModel(new Object[]{"Palabra", "Frecuencia"}, 0);
        tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", 1, 15));

        JScrollPane scrollArchivo = new JScrollPane(archivo);
        JScrollPane scrollTabla = new JScrollPane(tabla);

        //Panel de botones
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        btnConteo = new JButton("Conteo");
        btnConteo.setEnabled(false);
        btnGenerar = new JButton("Generar PDF");
        btnGenerar.setEnabled(false);
        JButton btnAbrir = new JButton("Abrir archivo");
        
        btnAbrir.addActionListener((ActionEvent)->{
            this.abrirArchivo();
        });

        btnConteo.addActionListener((ActionEvent) -> {
            this.extraerPalabras();
            Collections.sort(lista);
            this.conteo();
            this.mostrarGrafica();

            btnConteo.setEnabled(false);
            btnGenerar.setEnabled(true);
        });

        btnGenerar.addActionListener((ActionEvent) -> {
            try {
                this.generarPDF();
                btnGenerar.setEnabled(false);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        pnlBotones.add(btnAbrir);
        pnlBotones.add(btnConteo);
        pnlBotones.add(btnGenerar);

        pnlArchivo.add(scrollArchivo);
        pnlArchivo.add(scrollTabla);

        this.add(pnlBotones);
        this.add(pnlArchivo);
        this.pack();
        this.setLocationRelativeTo(null);
        new Presentacion().setVisible(true);
    }

    private void extraerPalabras() {
        lista = new ArrayList<>();
        String palabra = "";
        String texto=archivo.getText();

        for (int i = 0; i < texto.length(); i++) {
            if (Character.isLetter(texto.charAt(i))) {
                palabra += Character.toLowerCase(texto.charAt(i));
            } else {
                if (!palabra.isEmpty()) {
                    lista.add(palabra);
                    palabra = "";
                }
            }
        }

    }

    private void conteo() {
        dataset = new DefaultCategoryDataset();
        String palabra;
        int contador = 0;

        while (!lista.isEmpty()) {
            palabra = lista.get(0);

            while (palabra.equals(lista.get(0))) {
                contador++;
                lista.remove(0);
                if (lista.isEmpty()) {
                    break;
                }
            }

            if (esCorrecta(palabra) && palabra.length() > 1) {
                modelo.addRow(new Object[]{palabra, contador});
                dataset.setValue(contador, "Frecuencia", palabra);
            }

            contador = 0;
        }
    }

    private boolean esCorrecta(String palabra) {
        char c = 'A';

        for (int i = 0; i < palabra.length(); i++) {
            if (esConsonante(palabra.charAt(i))) {
                if (c == 'A') {
                    c = palabra.charAt(i);
                } else {
                    if (palabra.charAt(i) >= c) {
                        c = palabra.charAt(i);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean esConsonante(char c) {
        c = Character.toUpperCase(c);

        if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
            return true;
        } else {
            return false;
        }
    }

    private void mostrarGrafica() {
        JFreeChart chart = ChartFactory.createBarChart("Grafica de barras", "Palabra", "Frecuencia", dataset, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeCrosshairPaint(Color.black);

        final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
        final File file = new File("src/archivos/barchart.png");
        try {
            ChartUtilities.saveChartAsPNG(file, chart, 700, 600, info);
        } catch (IOException ex) {

        }

        frame = new ChartFrame("Grafica de barras", chart);
        frame.setBounds(100, 100, 700, 600);
        frame.setVisible(true);
    }

    private void generarPDF() throws FileNotFoundException, IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter("src/archivos/resultado.pdf"));
        Document document = new Document(pdf, PageSize.A4);
        document.setMargins(40, 30, 35, 30);

        Table pdfTable = new Table(new float[]{15, 15});
        pdfTable.setWidthPercent(50);

        pdfTable.addHeaderCell(new Cell().add(tabla.getColumnName(0)));
        pdfTable.addHeaderCell(new Cell().add(tabla.getColumnName(1)));

        for (int filas = 0; filas < tabla.getRowCount(); filas++) {
            for (int cols = 0; cols < tabla.getColumnCount(); cols++) {
                pdfTable.addCell(modelo.getValueAt(filas, cols).toString());
            }
        }

        Image image = new Image(ImageDataFactory.create("src/archivos/barchart.png"));
        image.scaleAbsolute(500, 500);
        
        document.add(new Paragraph("Texto").setBold());
        document.add(new Paragraph(archivo.getText()));
        document.add(new Paragraph("\n Tabla de resultados \n").setBold());
        document.add(pdfTable);
        document.add(new Paragraph("\n Grafica de barras \n").setBold());
        document.add(image);
        document.close();

        Desktop.getDesktop().open(new File("src/archivos/resultado.pdf"));
    }
    
    private void abrirArchivo(){
        int opcion = selectorArchivos.showOpenDialog(this);

        if (opcion == 0) {

            if (!archivo.getText().isEmpty()) {
                    archivo.setText("");
                    btnGenerar.setEnabled(false);
                }

                try {
                    File archivoTexto = selectorArchivos.getSelectedFile();
                    String cadena;
                    BufferedReader b = new BufferedReader(new FileReader(archivoTexto));
                    while ((cadena = b.readLine()) != null) {
                        archivo.append(cadena + "\n");
                    }
                    b.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                btnConteo.setEnabled(true);

                if (modelo.getRowCount() > 0) {
                    frame.dispose();
                    
                    while (modelo.getRowCount() > 0) {
                        modelo.removeRow(0);
                    }
                }

        } else {
            JOptionPane.showMessageDialog(null, "No has seleccionado un archivo.", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Actividad3 act = new Actividad3();

        act.setVisible(true);

    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.abrirArchivo();
    }

    @Override
    public void windowClosing(WindowEvent e) {

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
