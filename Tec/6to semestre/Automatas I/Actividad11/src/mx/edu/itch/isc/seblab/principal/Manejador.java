package mx.edu.itch.isc.seblab.principal;

import mx.edu.itch.isc.seblab.automatas.Nodo;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Manejador implements ActionListener, KeyListener {

    private Pantalla p;

    public Manejador() {
        this.p= new Pantalla();

        p.btnInsertar.addActionListener(this);
        p.tfCadena.addKeyListener(this);

        p.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == p.btnInsertar){
            this.manejaEventoInsertar();
        }
    }

    private void manejaEventoInsertar(){
        String entrada = p.tfCadena.getText().toUpperCase();

        if(entrada.matches("[AB]+")){
            p.tfCadena.setBorder(BorderFactory.createLineBorder(PaletaColores.EMERALD));
            //p.taResultado.setText(new Automata(entrada).estadoIII());

            Nodo nodo = new Nodo(0);
            for(int i=0;i<entrada.length();i++){
                nodo.transicion(entrada.charAt(i));
            }
        }else{
            p.tfCadena.setBorder(BorderFactory.createLineBorder(PaletaColores.ALIZARIN));
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_ENTER){
            this.manejaEventoInsertar();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
