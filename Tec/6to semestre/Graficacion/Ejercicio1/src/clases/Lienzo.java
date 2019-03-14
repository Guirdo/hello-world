package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Lienzo extends JFrame {

    public Lienzo() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {

        //g.drawLine(0,250,500,250);
        //g.drawLine(250, 0, 250, 500);
        int x1, x2, y1, y2;

        x1 = 250;
        y1 = 0;
        x2 = 275;
        y2 = 250;

        g.setColor(Color.red);
        do {
            g.drawLine(x1, y1, x2, y2);
            y1 += 25;
            x2 += 25;
        } while (x2 <= 500);

        g.setColor(Color.blue);
        do {
            g.drawLine(x1, y1, x2, y2);
            y1 += 25;
            x2 -= 25;
        } while (y1 < 501);

        g.setColor(Color.red);
        do {
            g.drawLine(x1, y1, x2, y2);
            y1 -= 25;
            x2 -= 25;
        } while (x2 >= 0);

        g.setColor(Color.blue);
        do {
            g.drawLine(x1, y1, x2, y2);
            x2 += 25;
            y1 -= 25;
        } while (y1 >= -30);

    }

    public static void main(String[] args) {
        new Lienzo().setVisible(true);
    }
}
