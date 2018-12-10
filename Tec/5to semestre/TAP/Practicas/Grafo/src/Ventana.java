import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {
    //Atributos
    public static int figura;
    public static boolean linea;
    private JButton circulo,cuadrado,enlace;
    private Lienzo lienzo;

    public Ventana() {
        setTitle("Dibujar figuras");
        setSize(600,600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        linea=false;
        figura=0;

        circulo = new JButton("Circulo");
        circulo.setBounds(10,10,90,25);
        circulo.addActionListener((ActionEvent)->{
            figura = 0;
            linea=false;
        });

        cuadrado = new JButton("Cuadrado");
        cuadrado.setBounds(110,10,90,25);
        cuadrado.addActionListener((ActionEvent)->{
            figura = 1;
            linea=false;
        });

        enlace = new JButton("Enlace");
        enlace.setBounds(210,10,90,25);
        enlace.addActionListener((ActionEvent)->{
            linea=true;
        });

        lienzo = new Lienzo();
        lienzo.setBounds(0,45,this.getWidth(),this.getHeight()-45);

        add(circulo);
        add(cuadrado);
        add(enlace);
        add(lienzo);
    }
}
