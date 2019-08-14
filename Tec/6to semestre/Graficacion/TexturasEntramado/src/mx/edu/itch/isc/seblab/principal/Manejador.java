package mx.edu.itch.isc.seblab.principal;

import mx.edu.itch.isc.seblab.componentes.AccionMenu;
import mx.edu.itch.isc.seblab.figuras.*;
import mx.edu.itch.isc.seblab.relleno.Lienzo;
import mx.edu.itch.isc.seblab.relleno.Relleno;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Manejador implements ActionListener, MouseListener {

    private Pantalla p;

    private ArrayList<Figura> arrayFiguras;
    public static Relleno rellenoSeleccionado;

    public Manejador() {
        p = new Pantalla();
        arrayFiguras = new ArrayList<>();

        p.btnCuadrado.addActionListener(this);
        p.btnCirculo.addActionListener(this);
        p.btnRectangulo.addActionListener(this);

        p.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.setRellenoSeleccionado();

        if(e.getSource() == p.btnCuadrado){
            this.manejaEventoCuadrado();
        }else if(e.getSource()== p.btnRectangulo){
            this.manejaEventoRectangulo();
        }else if(e.getSource()==p.btnCirculo){
            this.manejaEventoCirculo();
        }else if(e.getSource() == p.btnBorrar){
            this.manejaEventoLimpiarLienzo();
        }
    }

    private void manejaEventoLimpiarLienzo() {
        this.arrayFiguras = new ArrayList<>();
        p.lienzo.removeAll();
        p.lienzo.repaint();
    }

    private void setRellenoSeleccionado(){
        if(p.btnTextura1.isSelected()){
            rellenoSeleccionado=new Relleno("/mx/edu/itch/isc/seblab/texturas/t1.png");
        }else if(p.btnTextura2.isSelected()){
            rellenoSeleccionado=new Relleno("/mx/edu/itch/isc/seblab/texturas/t2.png");
        }else if(p.btnTextura3.isSelected()){
            rellenoSeleccionado=new Relleno("/mx/edu/itch/isc/seblab/texturas/t3.png");
        }else if(p.btnTextura4.isSelected()){
            rellenoSeleccionado=new Relleno("/mx/edu/itch/isc/seblab/texturas/t4.png");
        }else if(p.btnPunto.isSelected()){
            rellenoSeleccionado = new Relleno(Lienzo.TRAMADO_PUNTOS);
        }else if(p.btnLineas.isSelected()){
            rellenoSeleccionado = new Relleno(Lienzo.TRAMADO_LINEAS);
        }else if(p.btnTelar.isSelected()){
            rellenoSeleccionado = new Relleno(Lienzo.TRAMADO_TELAR);
        }
    }

    private void manejaEventoCirculo() {
        Circulo c = new Circulo(p.lienzo,rellenoSeleccionado,50);
        this.agregarFigura(c);
    }

    private void manejaEventoRectangulo() {
        Rectangulo r = new Rectangulo(p.lienzo,rellenoSeleccionado,150,75);
        this.agregarFigura(r);
    }

    private void manejaEventoCuadrado() {
        Cuadrado c = new Cuadrado(p.lienzo,rellenoSeleccionado,100);
        this.agregarFigura(c);
    }

    private void agregarFigura(Figura fig){
        fig.addMouseListener(this);

        JPopupMenu pop = new JPopupMenu();
        pop.add(new AccionMenu("Cambiar tamaño...",fig));
        //pop.add(new AccionMenu("Cambiar textura/tramado...",fig));
        fig.setComponentPopupMenu(pop);

        arrayFiguras.add(fig);
        this.redibujarLienzo();
    }

    private void redibujarLienzo(){
        p.lienzo.removeAll();

        for (Figura fig: arrayFiguras){
            p.lienzo.add(fig);
        }

        p.lienzo.revalidate();
        p.lienzo.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.isPopupTrigger()){
            for(Figura fig: arrayFiguras){
                if(e.getSource()==fig){
                    this.setRellenoSeleccionado();
                    fig.getComponentPopupMenu().setLocation(e.getLocationOnScreen());
                    fig.getComponentPopupMenu().setVisible(true);
                }
            }
        }
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
