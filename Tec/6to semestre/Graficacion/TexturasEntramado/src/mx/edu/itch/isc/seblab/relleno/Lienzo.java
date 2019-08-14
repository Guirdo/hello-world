package mx.edu.itch.isc.seblab.relleno;

import javax.swing.*;
import java.awt.*;

public class Lienzo extends JPanel {

    private int tipoTramadoSeleccionado;

    public static final int TRAMADO_PUNTOS = 0;
    public static final int TRAMADO_LINEAS=1;
    public static final int TRAMADO_TELAR=2;

    public Lienzo(int tipoTramado) {
        this.tipoTramadoSeleccionado = tipoTramado;
        this.setSize(100,100);
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(0,0,this.getWidth(),this.getHeight());

        int x =0;
        int y = 10;
        g.setColor(Color.decode("#170FBA"));

        switch (tipoTramadoSeleccionado){
            case TRAMADO_LINEAS:
                y = this.getHeight();
                while(x < this.getWidth()){
                    g.drawLine(x,0,x,y);
                    g.drawLine(x+1,0,x+1,y);

                    x+=10;
                }

                break;
            case TRAMADO_PUNTOS:
                while(y<=this.getHeight()){
                    g.fillOval(x,y,5,5);

                    x+=10;

                    if(x == this.getWidth()){
                        x=0;
                        y+=10;
                    }

                    if(y==this.getHeight()){
                        break;
                    }
                }
                break;
            case TRAMADO_TELAR:
                y = this.getHeight();
                while(x < this.getWidth()){
                    g.drawLine(x,0,x,y);
                    g.drawLine(x+1,0,x+1,y);

                    x+=10;
                }

                y= 10;
                x=this.getWidth();

                while(y < this.getHeight()){
                    g.drawLine(0,y,x,y);
                    g.drawLine(0,y+1,x,y+1);

                    y+=10;
                }

                break;
        }
    }
}
