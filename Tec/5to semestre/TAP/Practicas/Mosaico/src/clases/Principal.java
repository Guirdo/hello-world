package clases;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

    //Atributos inicio
    private JButton b1,b2,b3;
    //Atributos fin


    public Principal(){
        setLayout(null);
        setBounds(200,200,315,315);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();

        b1.setBounds(0,0,100,100);
        b2.setBounds(100,0,100,100);
        b3.setBounds(200,0,100,100);

        b1.setIcon(new ImageIcon("src\\imagenes\\kylo.jpg"));
        b2.setIcon(new ImageIcon("src\\imagenes\\kylo.jpg"));
        b3.setIcon(new ImageIcon("src\\imagenes\\kylo.jpg"));

        b1.addActionListener((ActionEvent) ->{
            System.out.println("Presionaste el boton 1");
        });

        b2.addActionListener((ActionEvent) ->{
            System.out.println("Presionaste el boton 2");
        });

        b3.addActionListener((ActionEvent) ->{
            System.out.println("Presionaste el boton 3");
        });

        this.add(b1);
        this.add(b2);
        this.add(b3);
        setVisible(true);
    }

    public static void main(String[] args){
        new Principal();
    }
}
