/*
 * Hola!
 */
package actividad4;

import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Actividad4 extends JFrame {

    private JTextArea resultado, archivo;
    private JFileChooser selectorArchivos;

    //Variables para el algoritmo RC4
    private int i, j;
    private int[] vectorS;
    private String key;

    public Actividad4() {
        this.setTitle("Actividad 3");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        //this.addWindowListener(this);
        //this.setSize(400,400);

        vectorS = new int[256];
        
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
        resultado = new JTextArea(25, 40);
        resultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        resultado.setEditable(false);
        resultado.setLineWrap(true);
        resultado.setWrapStyleWord(true);

        JScrollPane scrollArchivo = new JScrollPane(archivo);
        JScrollPane scrollResultado = new JScrollPane(resultado);

        //Panel de botones
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JButton btnAbrir = new JButton("Abrir archivo");
        JButton btnCodificar = new JButton("Codificar/Decodificar");
        JButton btnGuardar = new JButton("Guardar");

        btnAbrir.addActionListener((ActionEvent) -> {
            this.abrirArchivo();
        });

        btnCodificar.addActionListener((ActionEvent) -> {
            key = JOptionPane.showInputDialog(null, "Inserte clave", "Clave de cifrado", JOptionPane.QUESTION_MESSAGE);
            this.rc4();
        });
        
        btnGuardar.addActionListener((ActionEvent)->{
            int opcion = selectorArchivos.showSaveDialog(this);
            
            if(opcion==0){
                File archivoGuardado = selectorArchivos.getSelectedFile();
                
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(archivoGuardado));
                    bw.write(resultado.getText());
                    bw.close();
                } catch (IOException ex) {
                    
                }
            }
        });

        pnlBotones.add(btnAbrir);
        pnlBotones.add(btnCodificar);
        pnlBotones.add(btnGuardar);

        pnlArchivo.add(scrollArchivo);
        pnlArchivo.add(scrollResultado);

        this.add(pnlBotones);
        this.add(pnlArchivo);
        this.pack();
        this.setLocationRelativeTo(null);
        new Presentacion().setVisible(true);

    }

    private void rc4() {
        String mensaje = archivo.getText();
        String mensajeCifrado = "";
        i = 0;
        j = 0;
        //Se llena el VectorS
        for (int i = 0; i < 256; i++) {
            vectorS[i] = i;
        }

        this.ksa();
        
        int[] keyStream = this.prga(mensaje);
        int c;

        for (int h = 0; h < mensaje.length(); h++) {
            c = mensaje.charAt(h) ^ keyStream[h];
            mensajeCifrado = mensajeCifrado.concat(Character.toString((char) c));
        }
        
        resultado.setText(mensajeCifrado);
    }

    private void ksa() {
        j = 0;
        int k;
        for (i = 0; i < 256; i++) {
            k = key.charAt(i % key.length());
            j = ((j + vectorS[i] + k) % 256);
            intercambio(i, j);
        }
    }

    private int[] prga(String mensaje) {
        int[] keyStream = new int[mensaje.length()];
        i = 0;
        j = 0;
        int t;

        for(int k = 0; k < mensaje.length();k++){
            i = (i + 1) % 256;
            j = (j + vectorS[i]) % 256;
            intercambio(i, j);
            t = (vectorS[i] + vectorS[j]) % 256;
            keyStream[k] = t;
            k++;
        }

        return keyStream;
    }

    private void intercambio(int a, int b) {
        int aux = vectorS[a];
        vectorS[a] = vectorS[b];
        vectorS[b] = aux;
    }

    private void abrirArchivo() {
        
        int opcion = selectorArchivos.showOpenDialog(this);

        if (opcion == 0) {

            //Si el textArea Archivo tiene texto dentro, se vacia
            if (!archivo.getText().isEmpty()) {
                archivo.setText("");
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

        } 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Actividad4().setVisible(true);
    }

}
