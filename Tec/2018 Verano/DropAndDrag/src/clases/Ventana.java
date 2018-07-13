package clases;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ventana extends JFrame {

    public Ventana(){
        setTitle("Arrastra y suelta");
        setSize(800,750);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        balon.setBounds(30,30,340,340);
        balon.setIcon(new ImageIcon("C:\\Users\\aldom\\Documents\\Codigo\\hello-world\\Tec\\2018 Verano\\DropAndDrag\\src\\imagenes\\balon.jpg"));
        porteria.setBounds(30,380,640,400);
        porteria.setIcon(new ImageIcon("C:\\Users\\aldom\\Documents\\Codigo\\hello-world\\Tec\\2018 Verano\\DropAndDrag\\src\\imagenes\\porteria.jpg"));

        add(balon);
        add(porteria);
    }

    public static void main(String [] args){
        Ventana ven = new Ventana();
        ven.setVisible(true);
    }


    //Declariacion de variables
    JButton balon = new JButton();
    JButton porteria = new JButton();

}
