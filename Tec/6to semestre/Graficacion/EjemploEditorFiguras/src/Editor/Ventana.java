/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editor;


import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author diann
 */
public class Ventana extends JFrame {
    
    public Ventana(){
        this.setBounds(0,0,800,600);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public static void main (String args[]){
        JPanel lienzo= new JPanel();
        lienzo.setLayout(null);
        lienzo.setBounds(100,0,800,600);
        lienzo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        Vertice v1 = new Vertice(0,0, lienzo);
        Ventana ventana= new Ventana();
        //Triangulo triangulo=new Triangulo(400,10,200,100,200,500,lienzo);
        
//        lienzo.add(v1);
        lienzo.add(new Triangulo(50,0,100,100,0,100,lienzo));
        //lienzo.add(new Triangulo(20,10,100,100,200,150,lienzo));
        ventana.add(lienzo);
        ventana.setVisible(true);
    }
    
}
