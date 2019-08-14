package mx.edu.itch.isc.seblab.relleno;

import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Relleno {
    protected BufferedImage relleno;

    private JPanel pnlAux;

    public Relleno(String ruta){
        Image imagenAux =new ImageIcon(this.getClass().getResource(ruta)).getImage();
        this.relleno = ((ToolkitImage) imagenAux).getBufferedImage();
    }

    public Relleno(int tipoTramado){
        this.relleno= this.generarRelleno(new Lienzo(tipoTramado));
    }

    private BufferedImage generarRelleno(Lienzo pnl){
        BufferedImage bi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        pnl.paint(g);
        g.dispose();

        return bi;
    }

    public BufferedImage getRelleno() {
        return relleno;
    }
}
