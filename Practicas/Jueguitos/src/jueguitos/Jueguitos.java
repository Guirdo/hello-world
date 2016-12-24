package jueguitos;

import javax.swing.*;
import java.util.*;

public class Jueguitos {

    public static void main(String[] args) {
        
        //Enterios para los menus
        int jue,pptUs,pptJava,conti=0;
        
        String [] juegos = {"JanKenpo","Bola de la fortuna","Adivina el numero","Salir"};
        String [] mano = {"Piedra","Papel","Tijeras"};
        
        //Objetos necesarios
        Random alea = new Random();
        Mensaje mensa = new Mensaje();
        
        JOptionPane.showMessageDialog(null,"¡BIevenido a jueguitos!");
        
        do{
            jue=JOptionPane.showOptionDialog(null,"Eliga el juego", "Seleccion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, juegos, null);
            
            switch (jue){
                
                case 0:
                    
                    JOptionPane.showMessageDialog(null,"¡Bienvenido al juego de Prieda, Papel o Tijeras!");
                    
                    while(conti!=1){
                       //Escoge primero Java
                       pptJava = (int) Math.floor(alea.nextDouble()*(2-0+1)-0);
                       
                       pptUs = JOptionPane.showOptionDialog(null,"Escoge: ","Usuario decide", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,mano, "Piedra");
                       JOptionPane.showMessageDialog(null,"Java escogio "+mano[pptJava]);
                       JOptionPane.showMessageDialog(null,"Haz escogido "+mano[pptUs]);
                       
                       //Envia el mensaje del ganador
                       mensa.mandaMensaje(pptUs, pptJava);
                       
                       conti = JOptionPane.showOptionDialog(null,"Desea continuar?", "La revancha?",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,null, "Yes"); 
                    }     
                break;
                case 1:
                    JOptionPane.showMessageDialog(null,"¡Descubre tu fortuna!");
                    
                    while(conti!=1){
                        JOptionPane.showInputDialog(null,"¡Realiza tu pregunta!");
                        
                        JOptionPane.showMessageDialog(null,"*Sacudes la bola de la fortuna*");
                        
                        conti = JOptionPane.showOptionDialog(null,"¿Desea continuar?", "¿Otra vez?",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,null, "Yes"); 
                    }
                break;    
            }
            JOptionPane.showMessageDialog(null,"¡Hasta luego!");
        }while(jue != 3);
        
        
    }
    
}
