/*
 * Hola!
 */
package deformarfiguras;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import mx.edu.itch.sistemas.seblab.Imagen.Imagen;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Boton;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Ventana;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class DeformarFiguras extends Ventana{
    
    private JPanel lienzo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new DeformarFiguras().setVisible(true);
    }

    public DeformarFiguras() {
        super("Deformar figuras", new MigLayout("wrap 2","10[]15[]10","10[]10[]10[]15[]10"));
        
        this.getContentPane().setBackground(PaletaColores.LINX_WHITE);
        
        lienzo = new JPanel();
        lienzo.setLayout(null);
        lienzo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lienzo.setBackground(PaletaColores.BLANCO);
        
        Boton btnTriangulo = new Boton("", Imagen.obtenerImagen(this, "/imagenes/triangulo.png"), 
                PaletaColores.LINX_WHITE,null );
        btnTriangulo.setBorder(BorderFactory.createLineBorder(PaletaColores.IRISH_BLUE));
        Boton btnCuadrado = new Boton("", Imagen.obtenerImagen(this, "/imagenes/cuadrado.png"), 
                PaletaColores.LINX_WHITE,null );
        btnCuadrado.setBorder(BorderFactory.createLineBorder(PaletaColores.IRISH_BLUE));
        Boton btnEstrella = new Boton("", Imagen.obtenerImagen(this, "/imagenes/estrella.png"), 
                PaletaColores.LINX_WHITE,null );
        btnEstrella.setBorder(BorderFactory.createLineBorder(PaletaColores.IRISH_BLUE));
        
        btnTriangulo.addActionListener((ActionEvent)->{
            int[]x={20,70,20};
            int[]y={20,20,70};
            lienzo.add(new Figura(x,y,Figura.TRIANGULO,PaletaColores.CARROT,lienzo));
            lienzo.repaint();
        });
        
        btnCuadrado.addActionListener((ActionEvent)->{
            int[]x={20,20,90,90};
            int[]y={20,90,90,20};
            lienzo.add(new Figura(x,y,Figura.CUADRADO,PaletaColores.PROTOSS_PYLON,lienzo));
            lienzo.repaint();
        });
        
        btnEstrella.addActionListener((AcionEvent)->{
            int[]x={120,130,160,130,140,115,90,100,80,110};
            int[]y={10,40,50,60,90,70,90,60,50,40};
            lienzo.add(new Figura(x,y,Figura.ESTRELLA,PaletaColores.EMERALD,lienzo));
            lienzo.repaint();
        });
        
        
        this.add(btnTriangulo,"");
        this.add(lienzo,"span 1 4,h 600,w 650");
        this.add(btnCuadrado,"h 100, w 100");
        this.add(btnEstrella,"h 100, w 100");
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
}
