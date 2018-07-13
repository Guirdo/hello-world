package clases;

import javax.swing.*;

public class Ventana extends JFrame {

    public Ventana(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(200,200);
        setLocationRelativeTo(null);
        setTitle("Pomodoro");
        setLayout(null);

        led.setBounds(75,70,50,30);
        mensaje.setBounds(60,30,80,30);
        add(led);
        add(mensaje);
        cro.start();
    }

    public static void main(String[] args){
        Ventana ven = new Ventana();
        ven.setVisible(true);
    }

    //Declaracion de variables y objetos
    static JLabel led = new JLabel();
    static JLabel mensaje = new JLabel();
    Cronometro cro = new Cronometro();
    //Declaracion de variables y objetos

}
