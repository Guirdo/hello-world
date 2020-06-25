package mx.edu.itch.seblab.principal;

import mx.edu.itch.seblab.clases.Bola;
import mx.edu.itch.seblab.clases.PVector;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class Manejador implements MouseListener {

    private Ventana ventana;
    private ArrayList<Bola> bolas;

    private Random r = new Random();
    private boolean mouseClicked = false;

    public Manejador() {
        this.ventana = new Ventana();
        bolas = new ArrayList<>();

        for(int i=0;i<5;i++){
            bolas.add(new Bola(r.nextInt(ventana.getWidth()),100, r.nextInt(2)+1,ventana.campo));
        }

        this.ventana.campo.setBolas(bolas);
        this.ventana.campo.addMouseListener(this);

        hilo.start();
        this.ventana.setVisible(true);
    }

    private Thread hilo = new Thread(()->{
       while(true){
            try{
                Thread.sleep(30);

                for(int i =0;i< bolas.size();i++){
                    bolas.get(i).mover();
                    bolas.get(i).aplicarFuerza(new PVector(0,1));
                    bolas.get(i).rebotar();
                }

                ventana.campo.repaint();
            }catch (Exception e){
                e.printStackTrace();
            }
       }
    });

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseClicked = true;
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
