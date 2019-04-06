package mx.edu.itch.sistemas.seblab.ManejadorArchivo;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ManejadorArchivoTexto {

    /**
     * Filtro para archivos de texto {@code txt}.
     */
    private final FileNameExtensionFilter FILTRO = new FileNameExtensionFilter("Archivos de texto", "txt");

    /**
     * Selector de archivos grafico.
     */
    private JFileChooser chooser;

    /**
     * Objeto que necesita {@code chooser} para funcionar. Vease la
     * documentación {@code JFileChooser}.
     */
    private Component parent;

    /**
     * Una nueva instancia crearia una interfaz grafica para buscar entre los
     * archivos del sistema los que sean de extención {@code txt}.
     */
    public ManejadorArchivoTexto(Component parent) {
        this.parent = parent;
        chooser = new JFileChooser();
        chooser.setFileFilter(FILTRO);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    }

    /**
     * Metodo que recibe el TextArea donde sera mostrado el contenido de un
     * archivo de texto.
     *
     * @param jta JTextArea donde se mostrara el contenido del archivo de texto.
     * @throws java.io.FileNotFoundException Si el archivo seleccionado no se
     * encuentra
     */
    public void abrirArchivo(JTextArea jta) throws FileNotFoundException {
        if (chooser.showOpenDialog(parent) == 0) {

            if (!jta.getText().isEmpty()) {
                jta.setText("");
            }

            try {
                File archivoTexto = chooser.getSelectedFile();
                String cadena;
                BufferedReader b = new BufferedReader(new FileReader(archivoTexto));
                while ((cadena = b.readLine()) != null) {
                    jta.append(cadena + "\n");
                }
                b.close();
            } catch (IOException ex) {
                //El ciclo infinito termino.
            }
        }
    }

    /**
     * Metod que guarda el contenido de un JTextArea.
     * @param jta JTextArea de donde sacara el contenido.
     * @throws IOException Si ocurre una excepción.
     */
    public void guardarArchivo(JTextArea jta) throws IOException {
        if (chooser.showSaveDialog(parent) == 0) {
            File archivoGuardado = chooser.getSelectedFile();

            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoGuardado));
            bw.write(jta.getText());
            bw.close();
        }
    }

}
