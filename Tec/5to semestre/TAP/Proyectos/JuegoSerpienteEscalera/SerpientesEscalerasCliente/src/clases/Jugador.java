package clases;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Jugador extends JLabel {

    private int contador;
    private String nombre;
    private int posInicialX,posInicialY;
    public Jugador(int numero,int posX,int posY) {
        Image im = new ImageIcon(getClass().getResource("/imagenes/jugadores/" + numero + ".png")).getImage();
        this.setIcon(new ImageIcon(im));
        this.contador = -1;
        this.nombre=nombre;
        this.posInicialX=posX;
        this.posInicialY=posY;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.setToolTipText(nombre);
    }
    
    public void devolverInicio(){
        this.setLocation(posInicialX,posInicialY);
        contador=-1;
    }

    public void avanzar(int dado) {
        boolean sobrePasa=false;
        int i = 0;
        while (i < dado) {
            if (contador >= 29) {
                sobrePasa=true;
            }
            
            if(sobrePasa){
                contador--;
            }else{
                contador++;
            }
            i++;            
        }
        
        this.setLocation(Mesa.listaRecuadro.get(contador).getX() + 20, Mesa.listaRecuadro.get(contador).getY() + 20);

        if (Mesa.listaRecuadro.get(contador).getSerpEsca() != 0) {
            contador += Mesa.listaRecuadro.get(contador).getSerpEsca();
            this.setLocation(Mesa.listaRecuadro.get(contador).darPosicionX(), Mesa.listaRecuadro.get(contador).darPosicionY());
        }
    }

    public int getContador() {
        return contador;
    }

    public String getNombre() {
        return nombre;
    }
}
