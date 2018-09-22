import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends JFrame {

    //Inicio de declaracion de atributos
    private JLabel saludo;
    private JButton salir;
    private JRadioButton hola;
    //Inicio de declaracion de atributos


    public Tablero(){
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        saludo = new JLabel("¡Hola mundo!");
        saludo.setFont(new Font("Arial",1,15));
        saludo.setBounds(200,200,100,100);

        hola = new JRadioButton("Hola");
        hola.setBounds(10,10,50,50);
        hola.addActionListener((ActionEvent) ->{
            if(hola.isSelected()){
                System.out.println("¡Hola mundo!");
            }else{
                System.out.println("¡Adios mundo!");
            }
        });

        salir = new JButton("Salir");
        salir.setFont(new Font("Times New Roman",1,16));
        salir.setBounds(400,400,100,50);

        //Metodo anonimo
        salir.addActionListener((ActionEvent) ->{
            System.exit(0);
        });

        this.add(saludo);
        this.add(hola);
        this.add(salir);
    }

}
