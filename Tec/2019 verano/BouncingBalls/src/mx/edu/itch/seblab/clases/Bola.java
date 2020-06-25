package mx.edu.itch.seblab.clases;

import java.awt.*;

public class Bola {

    private Campo campo;
    private PVector posicion;
    private PVector velocidad;
    private PVector aceleracion;
    private int radio;
    private int mass;

    public Bola(int x,int y, int mass, Campo c){
        posicion = new PVector(x,y);
        velocidad = new PVector(0,0);
        aceleracion = new PVector(0,0);
        this.mass = mass;
        this.radio = mass*15;
        this.campo = c;
    }

    public void mover(){
        velocidad.sumar(aceleracion);
        posicion.sumar(velocidad);
        aceleracion.multiplicar(0);
    }

    public void rebotar(){
        if(posicion.getX() > campo.getWidth() || posicion.getX() < 0){
            velocidad.x*=-1;
        }
        if(posicion.getY() > campo.getHeight() || posicion.getY() < 0){
            velocidad.y*=-1;
        }
    }

    public void aplicarFuerza(PVector fuerza){
        PVector f = PVector.dividir(fuerza,this.mass);
        aceleracion.sumar(f);
    }


    public void dibujar(Graphics g) {
        g.setColor(Color.decode("#b4b4b4"));
        g.fillOval((int)posicion.getX()-radio,(int)posicion.getY()-radio,
                radio*2,radio*2);
    }
}
