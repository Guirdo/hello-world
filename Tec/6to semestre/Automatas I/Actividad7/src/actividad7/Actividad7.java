/*
 * Hola!
 */
package actividad7;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.text.DocumentException;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import mx.edu.itch.sistemas.seblab.Graficas.GraficaBarras;
import mx.edu.itch.sistemas.seblab.Imagen.Imagen;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.AreaTexto;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Boton;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Presentacion;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Tabla;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Ventana;
import mx.edu.itch.sistemas.seblab.ManejadorArchivo.ManejadorArchivoTexto;
import net.miginfocom.swing.MigLayout;

/**
 * Iconos hechos por Freepik from www.flaticon.com
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Actividad7 extends Ventana {

    private String texto;
    private AreaTexto atArchivo;
    private Tabla tabla;
    private GraficaBarras grafica;
    private final String[] columnas = {"Consonantes", "Vocales", "Separadores", "Caracteres especiales"};

    public Actividad7() {
        super("Actividad 7", new MigLayout());
        this.setIconImage(Imagen.obtenerImagen(this, "/iconos/icono.png").getImage());

        atArchivo = new AreaTexto(30, 45, true, null, PaletaColores.PROTOSS_PYLON);
        tabla = new Tabla(new String[]{"Tipo de caracter", "Frecuencia"}, 0, PaletaColores.PROTOSS_PYLON);
        grafica = new GraficaBarras();

        this.getContentPane().add(this.darToolBar(), "growx,pushx,north,wrap");
        this.getContentPane().add(this.darPanel(), "growx,pushx,pushy,growy,center");
        this.pack();
        this.setLocationRelativeTo(null);

        new Presentacion("Actividad 7", 
                "Programa que cuenta las consonantes, vocales, "
                        + "separadores y caracteres especiales de un archivo de texto.", 
                new MigLayout(Presentacion.RESTRICCION,Presentacion.RESTRICCION_COLS,
                        Presentacion.RESTRICCION_FILAS))
                .setVisible(true);
    }

    private JPanel darPanel() {
        JPanel panel = new JPanel(new MigLayout("", "15[]20[]15", "5[][::20]5[]20:30:[]10[]15"));
        panel.setBackground(PaletaColores.BLANCO);

        grafica = new GraficaBarras();

        panel.add(new JLabel("Archivo de texto"), "span 2,wrap");
        panel.add(new JScrollPane(atArchivo), "grow,push,span 1 4");
        panel.add(new JLabel("Tabla de frecuencias"), "top,wrap");
        panel.add(tabla, "pushy,height 95,width 470,top,center,wrap");
        panel.add(new JLabel("Grafica de barras"), "wrap");
        panel.add(grafica, "h 470,w 470,growx,growy");

        return panel;
    }

    private JToolBar darToolBar() {
        JToolBar tbBarra = new JToolBar();
        tbBarra.setFloatable(false);
        tbBarra.setBackground(PaletaColores.LINX_WHITE);
        tbBarra.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 2));

        Boton btnAbrir = new Boton("", Imagen.obtenerImagen(this, "/iconos/abrir.png"), null, null);
        btnAbrir.setToolTipText("Abrir archivo");
        btnAbrir.setBorder(null);
        btnAbrir.addActionListener((ActionEvent) -> {
            ManejadorArchivoTexto mat = new ManejadorArchivoTexto(this);
            try {
                mat.abrirArchivo(atArchivo);
                tabla.vaciarTabla();
                grafica.limpiarGrafica();
            } catch (FileNotFoundException ex) {

            }
        });

        Boton btnConteo = new Boton("Conteo", Imagen.obtenerImagen(this, "/iconos/conteo.png"), null, null);
        btnConteo.setToolTipText("Conteo");
        btnConteo.setBorder(null);
        btnConteo.addActionListener((ActionEvent) -> {
            texto = atArchivo.getText();
            if (!texto.isEmpty()) {
                int[] frecuencias = {
                    this.encontrarGrupo("[b-df-hj-np-tv-z]"),
                    this.encontrarGrupo("[aeiou]"),
                    this.encontrarGrupo("[[\\.]\\s,;:()]"),
                    this.encontrarGrupo("\\W")
                };

                tabla.vaciarTabla();
                tabla.agregarFila(new Object[]{"Consonantes", frecuencias[0]});
                tabla.agregarFila(new Object[]{"Vocales", frecuencias[1]});
                tabla.agregarFila(new Object[]{"Separadores", frecuencias[2]});
                tabla.agregarFila(new Object[]{"Caracteres especiales", frecuencias[3]});

                grafica.dibujarBarras(frecuencias, columnas);
            }else{
                new MensajeError("Mensaje de error", "dispose", "La cadena se encuentra vacia...").setVisible(true);
            }
        });

        Boton btnPDF = new Boton("", Imagen.obtenerImagen(this, "/iconos/pdf.png"), null, null);
        btnPDF.setToolTipText("Generar PDF");
        btnPDF.setBorder(null);
        btnPDF.addActionListener((ActionEvent) -> {
            if (tabla.getTabla().getRowCount() > 0) {
                try {
                    ImageIO.write(grafica.crearImagen(), "png", new File("src/archivos/barchart.png"));
                    this.generarPDF();
                } catch (IOException ex) {

                } catch (DocumentException ex) {

                }
            } else {
                new MensajeError("Mensaje error", "dispose","¡Aun no has hecho el conteo!").setVisible(true);
            }
        });

        tbBarra.add(btnAbrir);
        tbBarra.add(btnConteo);
        tbBarra.add(btnPDF);

        return tbBarra;
    }

    private void generarPDF() throws FileNotFoundException, IOException, DocumentException {
        PdfDocument pdf = new PdfDocument(new PdfWriter("src/archivos/resultado.pdf"));
        Document document = new Document(pdf, PageSize.A4);
        document.setMargins(40, 30, 35, 30);

        Table pdfTable = new Table(new float[]{15, 15});
        pdfTable.setWidthPercent(50);

        pdfTable.addHeaderCell(new Cell().add(tabla.getTabla().getColumnName(0)));
        pdfTable.addHeaderCell(new Cell().add(tabla.getTabla().getColumnName(1)));

        for (int filas = 0; filas < tabla.getTabla().getRowCount(); filas++) {
            for (int cols = 0; cols < tabla.getTabla().getColumnCount(); cols++) {
                pdfTable.addCell(tabla.getModelo().getValueAt(filas, cols).toString());
            }
        }

        Image image = new Image(ImageDataFactory.create("src/archivos/barchart.png"));
        image.scaleAbsolute(450, 450);

        document.add(new Paragraph("Texto").setBold());
        document.add(new Paragraph(atArchivo.getText()));
        document.add(new Paragraph("\n Tabla de resultados \n").setBold());
        document.add(pdfTable);
        document.add(new Paragraph("\n Grafica de barras \n").setBold());
        document.add(image);
        document.close();

        Desktop.getDesktop().open(new File("src/archivos/resultado.pdf"));
    }

    private int encontrarGrupo(String patron) {
        int conteo = 0;
        Pattern pattern = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            conteo++;
        }

        return conteo;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Actividad7().setVisible(true);
    }

}
