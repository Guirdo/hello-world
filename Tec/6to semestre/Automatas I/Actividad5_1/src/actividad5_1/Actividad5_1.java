/*
 * Hola!
 */
package actividad5_1;

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
import java.util.Collections;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Actividad5_1 extends JFrame {

    private JTextArea archivo;
    private ArrayList<String> lista;
    private DefaultTableModel modelo;
    private JTable tabla;
    private File archivoTexto;
    private JFileChooser selectorArchivos;
    private JButton btnConteo, btnGenerar;
    private JButton btnEnviar;

    public Actividad5_1() {
        this.setTitle("Actividad 6");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        //this.setSize(400,400);

        lista = new ArrayList<>();

        selectorArchivos = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");
        selectorArchivos.setFileFilter(filtro);
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        //Panel del archivo y tabla
        JPanel pnlArchivo = new JPanel();
        pnlArchivo.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 8));
        archivo = new JTextArea(25, 40);
        archivo.setBorder(BorderFactory.createTitledBorder("Archivo de texto"));
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
        JButton btnAbrir = new JButton("Abrir archivo");
        btnConteo = new JButton("Conteo");
        btnConteo.setEnabled(false);
        btnGenerar = new JButton("Generar PDF");
        btnGenerar.setEnabled(false);
        btnEnviar = new JButton("Enviar correo");
        btnEnviar.setEnabled(false);

        btnAbrir.addActionListener((ActionEvent) -> {
            int opcion = selectorArchivos.showOpenDialog(this);

            if (opcion == 0) {
                this.abrirArchivo();
            }

        });

        btnConteo.addActionListener((ActionEvent) -> {

            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }

            this.separarPalabras();
            this.conteo();

            btnGenerar.setEnabled(true);
        });

        btnGenerar.addActionListener((ActionEvent) -> {
            try {
                this.generarPDF();
                this.abrirPDF();
                btnEnviar.setEnabled(true);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        btnEnviar.addActionListener((ActionEvent) -> {
            if (this.enviarCorreo()) {
                JOptionPane.showMessageDialog(null, "Se ha enviado el correo correctamente", "Envio exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Comprueba que tu antivirus y firewall este desactivado.", "Envio fallido", JOptionPane.ERROR_MESSAGE);
            }
        });

        pnlBotones.add(btnAbrir);
        pnlBotones.add(btnConteo);
        pnlBotones.add(btnGenerar);
        pnlBotones.add(btnEnviar);

        pnlArchivo.add(scrollArchivo);
        pnlArchivo.add(scrollTabla);

        this.add(pnlBotones);
        this.add(pnlArchivo);
        this.pack();
        this.setLocationRelativeTo(null);
        new Presentacion().setVisible(true);
    }

    private void separarPalabras() {
        String text = archivo.getText();
        String patronSeparador = "\\W+"; // "[.,;:]?\\s"
        Pattern pattern = Pattern.compile(patronSeparador, Pattern.UNICODE_CHARACTER_CLASS);

        String[] split = pattern.split(text);

        for (String e : split) {
            lista.add(e);
        }
    }

    private void conteo() {
        Collections.sort(lista);
        String palabra = "";
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

            modelo.addRow(new Object[]{palabra, contador});
            contador = 0;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Actividad5_1().setVisible(true);
    }

    private boolean enviarCorreo() {
        try {
            String usuario = "produccionesaldo@gmail.com";
            String contra = "yqbynmvulssdvtqq";
            String destinatario = JOptionPane.showInputDialog(null, "Introduzca el correo a quien se le enviara el archivo PDF: ");

            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", usuario);
            p.setProperty("mail.smtp.auth", "true");

            Session s = Session.getDefaultInstance(p, null);
            BodyPart text = new MimeBodyPart();
            text.setText("Esto es parte de la actividad");
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource("src\\archivos\\resultado.pdf")));
            adjunto.setFileName("resultado.pdf");

            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(text);
            m.addBodyPart(adjunto);

            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(usuario));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mensaje.setSubject("Actividad 5");
            mensaje.setContent(m);

            Transport t = s.getTransport("smtp");
            t.connect(usuario, contra);
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            return true;

        } catch (MessagingException ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
    }

    private void generarPDF() throws FileNotFoundException {
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

        document.add(new Paragraph("Texto").setBold());
        document.add(new Paragraph(archivo.getText()));
        document.add(new Paragraph("\n Tabla de resultados \n").setBold());
        document.add(pdfTable);
        document.close();
    }

    private void abrirPDF() throws IOException {
        Desktop.getDesktop().open(new File("src/archivos/resultado.pdf"));
    }

    private void abrirArchivo() {

        if (!archivo.getText().isEmpty()) {
            archivo.setText("");
            btnGenerar.setEnabled(false);
        }

        try {
            archivoTexto = selectorArchivos.getSelectedFile();
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

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

}
