import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class Lienzo extends JPanel implements MouseListener {

    private Vector<Figura> vectorFigura;
    private Vector<Enlace> vectorEnlace;
    private Point punto1,punto2;

    public Lienzo() {
        this.vectorFigura = new Vector<>();
        this.vectorEnlace = new Vector<>();
        addMouseListener(this);
    }

    public void paint(Graphics g){
        for (Figura nodos : vectorFigura){
            nodos.pintar(g);
        }

        for(Enlace enla : vectorEnlace){
            enla.pintar(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            if(!Ventana.linea){
                this.vectorFigura.add(new Figura(e.getX(),e.getY(),Ventana.figura));
                repaint();
            }else{
                for (Figura nodos : vectorFigura){
                    if(new Rectangle(nodos.getX()-Figura.DIAMETRO/2,nodos.getY()-Figura.DIAMETRO/2,
                            Figura.DIAMETRO,Figura.DIAMETRO).contains(e.getPoint())){
                        if(punto1==null){
                            punto1 = new Point(nodos.getX(),nodos.getY());
                        }else{
                            punto2 = new Point(nodos.getX(),nodos.getY());
                            this.vectorEnlace.add(new Enlace(punto1.x,punto1.y,punto2.x,punto2.y));
                            repaint();
                            punto1=null;
                            punto2=null;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
