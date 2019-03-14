package clases;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Principal extends JFrame {

    private JTextArea archivo;
    private ArrayList<Character> lista;
    private DefaultTableModel modelo;
    private JTable tabla;

    public Principal() {
        this.setTitle("Actividad 2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        //this.setSize(400,400);

        JFileChooser selectorArchivos = new JFileChooser();
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

        modelo = new DefaultTableModel(new Object[]{"Caracter", "Frecuencia"}, 0);
        tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", 1, 15));

        JScrollPane scrollArchivo = new JScrollPane(archivo);
        JScrollPane scrollTabla = new JScrollPane(tabla);

        //Panel de botones
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JButton btnAbrir = new JButton("Abrir archivo");
        JButton btnConteo = new JButton("Conteo");
        btnConteo.setEnabled(false);
        JButton btnGenerar = new JButton("Generar PDF");
        btnGenerar.setEnabled(false);

        btnAbrir.addActionListener((ActionEvent) -> {
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
                    while (modelo.getRowCount() > 0) {
                        modelo.removeRow(0);
                    }
                }
            }

        });

        btnConteo.addActionListener((ActionEvent) -> {
            this.extraerCaracteres();
            this.shellSort();
            this.conteo();

            btnConteo.setEnabled(false);
            btnGenerar.setEnabled(true);
        });

        btnGenerar.addActionListener((ActionEvent) -> {
            try {
                this.generarPDF();
                this.abrirPDF();
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

    /**
     * Metodo que extrae los caracteres del texto y los guarda en una lista
     */
    private void extraerCaracteres() {
        lista = new ArrayList<>();
        String texto = archivo.getText();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                lista.add(c);
            }
        }
    }

    /**
     * Metodo de ordenamiento Shell Sort
     */
    private void shellSort() {
        int intervalo, i, j, k;
        int n = lista.size();
        intervalo = n / 2;
        while (intervalo > 0) {
            for (i = intervalo; i < n; i++) {
                j = i - intervalo;
                while (j >= 0) {
                    k = j + intervalo;
                    if (lista.get(j) <= lista.get(k)) {
                        j = -1; // par de elementos ordenado
                    } else {
                        intercambiar(j, j + 1);
                        j -= intervalo;
                    }
                }
            }
            intervalo = intervalo / 2;
        }
    }

    /**
     * Metodo que intercambia de lugar los elementos en la lista
     *
     * @param i primera posision
     * @param j segunda posicion
     */
    private void intercambiar(int i, int j) {
        char aux = lista.get(i);

        lista.set(i, lista.get(j));
        lista.set(j, aux);
    }

    /**
     * Metodo que cuenta la frecuencia de los caracteres en el texto
     */
    private void conteo() {
        int cont = 0;
        char c = lista.get(0);
        Object[] array = {c, cont};

        for (int i = 0; i < lista.size(); i++) {
            if (Objects.equals(lista.get(i), c)) {
                cont++;
                array[1] = cont;
            } else {
                
                if(Objects.equals(array[0], ' ')){
                    array[0]="(espacio)";
                }else if(Objects.equals(array[0], '\n')){
                    array[0]="(salto de linea)";
                }
                
                modelo.addRow(array);
                cont = 1;
                c = lista.get(i);
                
                array[0] = c;
                array[1] = cont;
            }
        }
        
        cont=0;
        
        
    }

    private void generarPDF() throws FileNotFoundException, IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter("src/archivos/resultado.pdf"));
        Document document = new Document(pdf, PageSize.A4);
        document.setMargins(40,30 ,35, 30);

        Table pdfTable = new Table(new float[]{15, 15});
        pdfTable.setWidthPercent(50);

        pdfTable.addHeaderCell(new Cell().add(tabla.getColumnName(0)));
        pdfTable.addHeaderCell(new Cell().add(tabla.getColumnName(1)));

        for (int filas = 0; filas < tabla.getRowCount(); filas++) {
            for (int cols = 0; cols < tabla.getColumnCount(); cols++) {
                pdfTable.addCell(modelo.getValueAt(filas, cols).toString());
            }
        }

        document.add(new Paragraph("Texto").setBold());
        document.add(new Paragraph(archivo.getText()));
        document.add(new Paragraph("\n Tabla de resultados \n").setBold());
        document.add(pdfTable);
        document.close();
    }

    private void abrirPDF() throws IOException {
        Desktop.getDesktop().open(new File("src/archivos/resultado.pdf"));
        //Runtime.getRuntime().exec("cmd /c start " + ruta);
    }

    public static void main(String[] args) {
        new Principal().setVisible(true);
    }
}
