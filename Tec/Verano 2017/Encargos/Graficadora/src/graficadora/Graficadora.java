/*
 * Hola!
 */
package graficadora;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import graficadora.Graficadora;

/**
 *
 * @author jorge
 */
public class Graficadora {

    //Importante, plano debe ser publico y estatico
    public static plano plano;

    public static void main(String[] args) {

        //Creando la ventana y el plano de dibujo
        Ventana frame = new Ventana();
        frame.setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
        frame.setBounds(300, 300, 510, 600);
        frame.setLayout(new BorderLayout());
        plano = new plano();

        //Configuración del Boton
        JButton start = new JButton("Iniciar");
        start.addActionListener(frame);
        start.setText("Iniciar");

        //Bordes al panel
        frame.add(plano, BorderLayout.CENTER);
        frame.add(start, BorderLayout.SOUTH);

        frame.setVisible(true);

    }
}

/**
 *
 * @author jorge
 */
class plano extends JPanel {

    public plano() {
        init();
    }

    public void init() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);
        //x, y, longitud,y
        g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
        g.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());

    }

    // y=c*x2 +c*x +c
    public void paintSQRFunc(Graphics g) {
        
        for(double p=-5;p<5;p++){
            double y=(Math.exp(-Math.pow(p, 2)/2))/(Math.sqrt(2*Math.PI));
            double xp = p+1;
            double yp = (Math.exp(-Math.pow(xp, 2)/2))/(Math.sqrt(2*Math.PI));
            y = y*200;
            xp = xp*200;
            yp = yp*200;
            g.drawLine((int) coord_x(p*200), (int) coord_y(y), (int) coord_x(xp), (int) coord_y(yp));
            
        }
        
        /*for (double i = x1; i < x2; i++) {
            double y = ((double) Math.pow(i, 2) * x2mult) + i * x1mult + cons;
            double xp = i + 1;
            double yp = ((double) Math.pow(xp, 2) * x2mult) + xp * x1mult + cons;
            g.drawLine((int) coord_x(i), (int) coord_y(y), (int) coord_x(xp), (int) coord_y(yp));

        }*/
    }

    private double coord_x(double x) {
        double real_x = x + this.getWidth() / 2;
        return real_x;
    }

    private double coord_y(double y) {
        double real_y = -y + this.getHeight() / 2;

        return (real_y);
    }
}

/**
 *
 * @author jorge
 */
class Ventana extends JFrame implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        Graficadora.plano.paintSQRFunc(Graficadora.plano.getGraphics());
    }

}
