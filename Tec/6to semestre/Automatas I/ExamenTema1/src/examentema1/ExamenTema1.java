/*
 * Usar para cuando me hagan falta puntos.S
 */
package examentema1;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class ExamenTema1 extends JFrame implements WindowListener{

    private JFileChooser selectorArchivos;
    private JTextArea archivo;
    private JTable tabla;
    private DefaultTableModel modelo;

    public ExamenTema1() {
        this.setTitle("Examen Tema 1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.addWindowListener(this);

        selectorArchivos = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");
        selectorArchivos.setFileFilter(filtro);
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        JPanel pnlArchivo = new JPanel();
        pnlArchivo.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 8));
        archivo = new JTextArea(25, 40);
        archivo.setBorder(BorderFactory.createTitledBorder("Archivo de texto"));
        archivo.setEditable(false);
        archivo.setLineWrap(true);
        archivo.setWrapStyleWord(true);
        archivo.setFont(new Font("Arial",0,18));

        modelo = new DefaultTableModel(new Object[]{"Tipo", "Frecuencia"}, 0);
        tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", 1, 15));

        JScrollPane scrollArchivo = new JScrollPane(archivo);
        JScrollPane scrollTabla = new JScrollPane(tabla);
        pnlArchivo.add(scrollArchivo);
        pnlArchivo.add(scrollTabla);

        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        pnlBotones.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JButton btnAbrir = new JButton("Abrir archivo");
        JButton btnContar = new JButton("Contar");
        
        btnAbrir.addActionListener((ActionEvent)->{
            this.abrirArchivo();
        });

        btnContar.addActionListener((ActionEvent) -> {
            this.extraerPalabras();
        });

        pnlBotones.add(btnAbrir);
        pnlBotones.add(btnContar);

        this.add(pnlBotones);
        this.add(pnlArchivo);

        this.pack();
        this.setLocationRelativeTo(null);
        new Presentacion().setVisible(true);
    }

    private void extraerPalabras() {
        //lista = new ArrayList<>();
        String palabra = "";
        String texto = archivo.getText();
        int par=0;
        int impar = 0;
        int multiplo = 0;

        for (int i = 0; i < texto.length(); i++) {
            if (Character.isLetter(texto.charAt(i))) {
                palabra += Character.toLowerCase(texto.charAt(i));
            } else {
                if (!palabra.isEmpty()) {
                    //lista.add(palabra);

                    if (parA(palabra)) {
                        par++;
                    }
                    if (imparVocales(palabra)) {
                        impar++;
                    }
                    
                    if(consonanteMulTres(palabra)){
                        multiplo++;
                    }

                    palabra = "";
                }
            }
        }
        
        modelo.addRow(new Object[]{"Par de A's",par});
        modelo.addRow(new Object[]{"Impar de vocales",impar});
        modelo.addRow(new Object[]{"Consonantes multiplo de 3",multiplo});

    }

    private boolean parA(String palabra) {
        int conteo = 0;
        boolean par = false;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == 'A' || palabra.charAt(i) == 'a') {
                conteo++;
            }
        }

        if (conteo > 0) {
            if (conteo % 2 == 0) {
                par = true;
            }
        }

        return par;
    }

    private boolean imparVocales(String palabra) {
        int conteo = 0;
        boolean impar = false;

        for (int i = 0; i < palabra.length(); i++) {
            if (!this.esConsonante(palabra.charAt(i))) {
                conteo++;
            }
        }

        if (conteo > 0) {
            if (conteo % 2 != 0) {
                impar = true;
            }
        }

        return impar;
    }
    
    private boolean consonanteMulTres(String palabra){
        int conteo = 0;
        boolean multiplo = false;
        
        for(int i=0;i< palabra.length();i++){
            if(this.esConsonante(palabra.charAt(i))){
                conteo++;
            }
        }
        
        if(conteo>0){
            if(conteo % 3 == 0){
                multiplo = true;
            }
        }
        
        return multiplo;
    }

    private boolean esConsonante(char c) {
        c = Character.toUpperCase(c);

        if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
            return true;
        } else {
            return false;
        }
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
        new ExamenTema1().setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.abrirArchivo();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
