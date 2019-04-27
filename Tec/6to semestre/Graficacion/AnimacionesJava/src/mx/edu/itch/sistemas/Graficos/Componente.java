package mx.edu.itch.sistemas.Graficos;

import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;

import javax.swing.*;
import java.awt.*;

public class Componente extends JComponent {

    private static JPanel panel;
    private static int[] positionsBall = new int[2];
    private static volatile int step=15;



    public Componente(JPanel panel){
        this.panel=panel;
        this.positionsBall[0]=20;
        this.positionsBall[1] =20;

        this.setBounds(0,0,500,500);
    }

    @Override
    public void paint(Graphics g){
        g.setColor(PaletaColores.ALIZARIN);

    }

    static Thread hilo = new Thread(() -> {
        try{
            while (true){
                positionsBall[0] +=step;
                positionsBall[1] +=step;

                if(positionsBall[0]+20>=500){
                    step*=-1;
                }else if (positionsBall[0]<=0){
                    step*=-1;
                }

                panel.repaint();

                Thread.sleep(22);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    static public void mover(){
        if(!hilo.isAlive()){
            hilo.start();
        }else{
            if(step==0){
                step=15;
            }else if(step<0){
                step*=-1;
            }
        }
    }

    static public void pausar(){
        step=0;
    }

}
