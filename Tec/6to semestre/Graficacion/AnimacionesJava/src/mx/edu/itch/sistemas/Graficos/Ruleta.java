package mx.edu.itch.sistemas.Graficos;

import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ruleta extends JComponent {

    private Color paletaColores[] = {PaletaColores.ALIZARIN,PaletaColores.EMERALD,PaletaColores.IRISH_BLUE
                                        ,PaletaColores.SUN_FLOWER,PaletaColores.SILVER,PaletaColores.TURQUOISE};

    private JPanel panel;
    private int anguloInicial = 0;
    private int angulo = 9;
    private int AVANCE_MINIMO=280;
    private volatile int avance=0;
    private Random rnd;

    public Ruleta(JPanel pnl){
        this.panel=pnl;
         setBounds(0,0,500,500);
         this.rnd=new Random();

         this.avance+=AVANCE_MINIMO+rnd.nextInt(90);

    }

    public void paint(Graphics g){

        g.setColor(PaletaColores.ALIZARIN);
        g.fillPolygon(new int[]{190,210,200},new int[]{80,80,100},3);
        g.setColor(PaletaColores.PROTOSS_PYLON);
        g.drawPolygon(new int[]{190,210,200},new int[]{80,80,100},3);
        g.setColor(Color.BLACK);
        g.drawRect(100,100,200,200);

        for(int i=0;i<37;i++){
            g.setColor(paletaColores[i%6]);
            g.fillArc(100,100,300,300,anguloInicial,angulo);

            if(avance<4){
                if(90>=anguloInicial%360 && 90<(anguloInicial%360+angulo)){
                    g.setColor(paletaColores[i%6]);
                    g.fillRect(400,100,50,50);
                }
            }

            anguloInicial+=angulo;
        }
    }

    Thread hilo = new Thread(() -> {
        int cont=20;

        try{
            while(true){
                if(avance>1){
                    anguloInicial+=avance;
                    panel.repaint();
                    avance-=(int)(10*Math.pow(Math.E,cont))/1000000000;
                    cont++;
                }else{
                    avance=0;
                    cont=20;
                }

                System.out.println(avance);

                Thread.sleep(60);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    public void mover(){
        if(!hilo.isAlive()){
            hilo.start();
        }else{
            this.reiniciar();
        }
    }

    public void reiniciar(){
        this.avance=AVANCE_MINIMO+rnd.nextInt(90);
    }

}
