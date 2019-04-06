package graficatabla;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;

public class Lienzo extends JPanel {

    private int tipo_grafica = 0;
    private int[] calificaciones;
    private String[] nombres;
    private Color[] colores = {PaletaColores.ALIZARIN,PaletaColores.CARROT,PaletaColores.EMERALD,
                                PaletaColores.HUMMING_BIRD,PaletaColores.SIENNA_1,PaletaColores.LIGHT_GREEN,
                                PaletaColores.SUN_FLOWER,PaletaColores.TURQUOISE,
                                PaletaColores.CLOUDS,PaletaColores.SIENNA_3};
    private double unidad;
    private int acumCals;
    
    public Lienzo(){
        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        //g.setColor(Color.WHITE);
        //g.fillRect(0, 0, this.getWidth(), this.getHeight());

        switch (tipo_grafica) {
            case 1:
                unidad = (this.getHeight() - 20) / 100;

                g.setColor(Color.BLACK);
                g.drawLine(0, this.getHeight() - 10, this.getWidth(), this.getHeight() - 10);
                g.drawLine(10, 0, 10, this.getHeight());
                g.setFont(new Font("Arial", 0, 9));
                for (int i = 1; i <= 10; i++) {
                    g.drawString("" + (i * 10), 0, this.getHeight() - ((int) unidad * i * 10) - 10);
                    g.drawLine(0, this.getHeight() - ((int) unidad * i * 10) - 10, 15, this.getHeight() - ((int) unidad * i * 10) - 10);
                }

                int x = 30;
                int y = 0;
                int separacion = (this.getWidth() - 50) / calificaciones.length;

                g.setFont(new Font("Arial", 1, 12));

                for (int i = 0; i < calificaciones.length; i++) {

                    y = this.getHeight() - ((int) (unidad * calificaciones[i])) - 10;
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, separacion, ((int) unidad) * calificaciones[i]);

                    g.setColor(colores[i%colores.length]);

                    g.fillRect(x + 1, y + 1, separacion - 1, ((int) unidad) * calificaciones[i] - 1);

                    g.setColor(Color.BLACK);
                    g.drawString(nombres[i], x + 2, y - 5);

                    x += separacion;
                }
                break;
            case 2:
                g.setColor(Color.BLACK);
                int alfa = 0;

                int y1=50;
                
                for (int i = 0; i < calificaciones.length; i++) {
                    unidad = calificaciones[i] * 360 / acumCals;
                    g.setColor(colores[i%colores.length]);
                    g.fillArc(20, 100, 200, 200, alfa, (int) unidad);
                    alfa += (int) unidad;
                    
                    g.fillRect(250, y1,10,10);
                    g.setColor(Color.black);
                    g.drawString(nombres[i], 265, y1+10);
                    
                    
                    y1+=20;
                }  
                break;
            default:
                g.drawString("No hay nada", this.getWidth() / 2, this.getHeight() / 2);
        }
    }

    public void dibujarBarras(int[] calificaciones, String[] nombres) {
        this.setVisible(false);
        this.calificaciones = calificaciones;
        this.nombres = nombres;
        this.tipo_grafica = 1;
        this.setVisible(true);
    }

    public void dibujarPastel(int[] calificaciones, String[] nombres, int acum) {
        this.setVisible(false);
        this.calificaciones = calificaciones;
        this.nombres = nombres;
        this.acumCals = acum;
        this.tipo_grafica = 2;
        this.setVisible(true);
    }

    public void ponerEtiquetas(int[] calificaciones, String[] nombres){
        
        this.calificaciones = calificaciones;
        this.nombres = nombres;
        
        int y1=50;
        for(int i=0;i< nombres.length;i++){
            Etiqueta et = new Etiqueta(colores[i%colores.length], nombres[i]);
            //Etiqueta et = new Etiqueta();
            et.setBounds(230, y1, 100, 13);
            this.add(et);
            y1+=20;
        }
    }
    
    public BufferedImage crearImagen() {
        int w = this.getWidth();
        int h = this.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        this.paint(g);
        g.dispose();
        return bi;
    }
}
