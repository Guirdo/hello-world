/*
 * Hola!
 */
package actividad9;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.io.FileNotFoundException;
import javax.swing.JScrollPane;
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
public class Actividad9 extends Ventana{
    
    private AreaTexto atArchivo;
    
    public Actividad9() {
        super("Actividad 9",new MigLayout());
        
        atArchivo = new AreaTexto(30, 30, true, new Font("Arial",0,15),PaletaColores.PROTOSS_PYLON);
        
        this.add(this.crearBarra(),"growx,pushx,north");
        this.add(new JScrollPane(atArchivo),"growx,pushx,growy,pushy,gap 10,gapright 10,gaptop 10,gapbottom 10");
        this.pack();
        this.setLocationRelativeTo(null);
        
        new Presentacion("Presentación", "Programa que busca y remplaza cadenas en un archivo de texto.", 
                new MigLayout(Presentacion.RESTRICCION,Presentacion.RESTRICCION_COLS,Presentacion.RESTRICCION_FILAS)).setVisible(true);
    }
    
    private JToolBar crearBarra() {
        JToolBar tbBarra = new JToolBar();
        tbBarra.setFloatable(false);
        tbBarra.setBackground(PaletaColores.LINX_WHITE);
        tbBarra.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 2));
        
        Boton btnAbrir = new Boton("", Imagen.obtenerImagen(this, "/iconos/abrir.png"), 
                null, null);
        btnAbrir.setToolTipText("Abrir archivo");
        btnAbrir.setBorder(null);
        btnAbrir.addActionListener((ActionEvent) -> {
            ManejadorArchivoTexto mat = new ManejadorArchivoTexto(this);
            try {
                mat.abrirArchivo(atArchivo);
            } catch (FileNotFoundException ex) {
                
            }
        });
        
        Boton btnRemplazar = new Boton("Remplazar",Imagen.obtenerImagen(this, "/iconos/remplazar.png"),
                null, null);
        btnRemplazar.setToolTipText("Buscar y remplazar");
        btnRemplazar.setBorder(null);
        btnRemplazar.addActionListener((ActionEvent) -> {
            //TODO
            new Remplazar(atArchivo).setVisible(true);
        });
        
        tbBarra.add(btnAbrir);
        tbBarra.add(btnRemplazar);
        return tbBarra;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Actividad9().setVisible(true);
    }

    
    
}
