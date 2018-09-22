import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cronometro extends JFrame {

    //Atributos
    private JLabel lblReloj;
    private Timer reloj;
    private int contador;
    private JButton inicar,detener,reiniciar;

    public Cronometro(){
        setTitle("Cronometro");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300,200,350,200);

        contador=0;

        lblReloj = new JLabel("hola");
        lblReloj.setBounds(30,20,100,30);
        lblReloj.setFont(new Font("Times New Roman",1,15));

        reloj = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblReloj.setText(""+contador);
                contador++;
            }
        });

        inicar = new JButton("Iniciar");
        inicar.setBounds(30,70,80,25);
        inicar.addActionListener((ActiveEvent) ->{
            reloj.start();
        });

        detener = new JButton("Detener");
        detener.setBounds(115,70,80,25);
        detener.addActionListener((ActiveEvent) ->{
            reloj.stop();
        });

        reiniciar = new JButton("Reiniciar");
        reiniciar.setBounds(200,70,90,25);
        reiniciar.addActionListener((ActiveEvent) ->{
            contador=0;
            lblReloj.setText(""+contador);
        });

        add(lblReloj);
        add(inicar);
        add(detener);
        add(reiniciar);
    }

    public static void main(String[] args) {
        new Cronometro().setVisible(true);
    }

}
