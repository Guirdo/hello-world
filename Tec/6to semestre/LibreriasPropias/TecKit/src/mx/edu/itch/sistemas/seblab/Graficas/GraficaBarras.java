package mx.edu.itch.sistemas.seblab.Graficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;

public class GraficaBarras extends Grafica {

    private int[] datos;
    private String[] nombreDatos;
    private Color[] paletaColores = {PaletaColores.ALIZARIN, PaletaColores.LIGHT_GREEN, PaletaColores.PROTOSS_PYLON, PaletaColores.UNMELLOW_YELLOW,
        PaletaColores.TURQUOISE, PaletaColores.SIENNA_4, PaletaColores.TURQUOISE, PaletaColores.LIGHT_GREEN};
    private int unidad;
    private int numMayor;
    private boolean dibujar;

    public GraficaBarras() {
        super();
        this.dibujar = false;
    }

    public void paint(Graphics g) {
        g.setColor(PaletaColores.LINX_WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        g.drawLine(0, this.getHeight() - 10, this.getWidth(), this.getHeight() - 10);
        g.drawLine(10, 0, 10, this.getHeight());
        if (dibujar) {
            unidad = (this.getHeight() - 25) / numMayor;

            g.setFont(new Font("Arial", 0, 9));
            for (int i = 1; i <= numMayor; i++) {
                g.drawString("" + (i * (numMayor / 10)), 0, this.getHeight() - ((int) unidad * i * (numMayor / 10)) - 10);
                g.drawLine(0, this.getHeight() - ((int) unidad * i * (numMayor / 10)) - 10, 15, this.getHeight() - ((int) unidad * i * (numMayor / 10)) - 10);
            }

            int x = 30;
            int y = 0;
            int separacion = (this.getWidth() - 50) / datos.length;

            g.setFont(new Font("Arial", 0, 10));

            for (int i = 0; i < datos.length; i++) {

                y = this.getHeight() - ((int) (unidad * datos[i])) - 10;
                g.setColor(Color.BLACK);
                g.drawRect(x, y, separacion, ((int) unidad) * datos[i]);

                g.setColor(paletaColores[i % paletaColores.length]);

                g.fillRect(x + 1, y + 1, separacion - 1, ((int) unidad) * datos[i] - 1);
                g.setColor(Color.BLACK);
                g.drawString(nombreDatos[i], x + 2, y - 5);

                x += separacion;
            }
        } else {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", 1, 16));
            g.setColor(PaletaColores.ALIZARIN);
            g.drawString("No hay datos", this.getWidth() / 2 - 50, this.getHeight() / 2);
        }

    }

    public void dibujarBarras(int[] datos, String[] nombres) {
        this.datos = datos;
        this.nombreDatos = nombres;
        this.numMayor = this.darMayor();
        this.setVisible(false);
        this.dibujar = true;
        this.setVisible(true);
    }

    public void limpiarGrafica() {
        this.setVisible(false);
        this.dibujar = false;
        this.setVisible(true);
    }

    private int darMayor() {
        int sum = 0;
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] > sum) {
                sum = datos[i];
            }
        }
        return sum;
    }

}
