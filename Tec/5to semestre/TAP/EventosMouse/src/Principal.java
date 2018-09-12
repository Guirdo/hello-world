import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Principal extends JFrame implements MouseMotionListener,MouseListener {

    //Atributos inicio
    private JButton boton;
    private JLabel etiqueta;
    //Atributos fin


    public Principal(){
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boton = new JButton("Hola mundo");
        boton.setBounds(100,100,150,40);
        boton.addMouseListener(this);
        boton.addMouseMotionListener(this);

        etiqueta = new JLabel("El mouse ando por ahí");
        etiqueta.setBounds(20,300,300,40);


        this.add(boton);
        this.add(etiqueta);
    }

    public static void main(String[] args){
        new Principal();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        etiqueta.setText("El mouse dio click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        etiqueta.setText("El mouse esta presionando");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        etiqueta.setText("El mouse se solto");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        etiqueta.setText("El mouse esta dentro del boton");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        etiqueta.setText("El mouse esta fuera");
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //etiqueta.setText("El mouse se esta moviendo");
    }
}
