package graficatabla;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Lienzo extends JPanel {

    private int tipo_grafica = 0;
    private int[] calificaciones;
    private String[] nombres;
    private double unidad;
    private int acumCals;

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

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

                    if (i % 2 == 0) {
                        g.setColor(Color.decode("#f44a41"));
                    } else {
                        g.setColor(Color.decode("#4286f4"));
                    }

                    g.fillRect(x + 1, y + 1, separacion - 1, ((int) unidad) * calificaciones[i] - 1);

                    g.setColor(Color.BLACK);
                    g.drawString(nombres[i], x + 2, y - 5);

                    x += separacion;
                }
                break;
            case 2:
                g.setColor(Color.BLACK);
                unidad = 360 / acumCals;
                int alfa = 0;

                for (int i = 0; i < calificaciones.length; i++) {
                    if (i % 2 == 0) {
                        g.setColor(Color.decode("#f44a41"));
                    } else {
                        g.setColor(Color.decode("#4286f4"));
                    }
                    g.fillArc(20, 100, 200, 200, alfa, (int) unidad * calificaciones[i]);
                    alfa += (int) unidad * calificaciones[i];
                }
                break;
            default:
                g.drawString("No hay nada", this.getWidth() / 2, this.getHeight() / 2);
        }
    }

    public void dibujarBarras(int[] calificaciones, String[] nombres) {
        this.calificaciones = calificaciones;
        this.nombres = nombres;
        this.tipo_grafica = 1;
    }

    public void dibujarPastel(int[] calificaciones, String[] nombres, int acum) {
        this.calificaciones = calificaciones;
        this.nombres = nombres;
        this.acumCals = acum;
        this.tipo_grafica = 2;
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
