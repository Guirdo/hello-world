/*
 * Hola!
 */
package actividad8;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import mx.edu.itch.sistemas.seblab.Imagen.Imagen;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.AreaTexto;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Boton;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Presentacion;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Ventana;
import mx.edu.itch.sistemas.seblab.ManejadorArchivo.ManejadorArchivoTexto;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Actividad8 extends Ventana {
    
    private JTextArea atArchivo;
    
    public Actividad8() {
        super("Actividad 8", new MigLayout());
        this.setIconImage(Imagen.obtenerImagen(this, "/iconos/icono.png").getImage());
        this.getContentPane().setBackground(PaletaColores.BLANCO);
        
        atArchivo = new AreaTexto(25, 30, true, null, PaletaColores.PROTOSS_PYLON);
        
        this.add(this.crearBarra(), "growx,pushx,north");
        this.add(new JScrollPane(atArchivo), "growx,pushx,growy,pushy,gap 10,gapright 10,gaptop 10,gapbottom 10");
        this.pack();
        this.setLocationRelativeTo(null);
        
        new Presentacion("Actividad 8", "Programa que abre un archivo de texto y cambia el formato "
                + "AM/PM de la hora a formato 24 hrs.", new MigLayout(Presentacion.RESTRICCION,Presentacion.RESTRICCION_COLS,
                        Presentacion.RESTRICCION_FILAS)).setVisible(true);
    }
    
    private JToolBar crearBarra() {
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
            } catch (FileNotFoundException ex) {
                
            }
        });
        
        Boton btnRemplazar = new Boton("Cambiar formato", Imagen.obtenerImagen(this, "/iconos/remplazar.png"),
                null, null);
        btnRemplazar.setToolTipText("Cambiar formato de hora");
        btnRemplazar.setBorder(null);
        btnRemplazar.addActionListener((ActionEvent) -> {
            //TODO
            this.cambiarFormatoAM();
        });
        
        tbBarra.add(btnAbrir);
        tbBarra.add(btnRemplazar);
        return tbBarra;
    }
    
    private void cambiarFormatoAM() {
        String texto = atArchivo.getText();
        Pattern pattern = Pattern.compile("((?<hora>\\d{2}):(?<mins>\\d{2})\\s?(?<meridiano>am|pm))");
        Matcher matcher = pattern.matcher(texto);
        
        while (matcher.find()) {
            String hh = matcher.group("hora");
            String mm = matcher.group("mins");
            if (matcher.group("meridiano").equals("am")) {
                if (Integer.parseInt(hh) == 12) {
                    hh = "00";
                }
            }else{
                if(Integer.parseInt(hh) != 12){
                    hh = ""+(Integer.parseInt(hh)+12);
                }
            }
            
            texto = matcher.replaceFirst(hh + ":" + mm + " hrs");
            matcher = pattern.matcher(texto);
        }
        
        atArchivo.setText(texto);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Actividad8().setVisible(true);
    }
    
}
