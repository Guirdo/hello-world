package automata_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Manejador implements ActionListener,KeyListener{
    
    private Pantalla p;
    
    public Manejador(){
        this.p = new Pantalla();
        
        p.btnIngresar.addActionListener(this);
        p.tfCadena.addKeyListener(this);
        
        p.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == p.btnIngresar){
            manejaEventoIngresar();
        }
    }

    private void manejaEventoIngresar() {
        int indice = 0;

        String cadena = p.tfCadena.getText();

        Automata automata = new Automata(1,8);

        while (!automata.esFinal() || automata.getEstado() != -1) {
            try {
                automata.transicion(cadena.charAt(indice));
                indice++;
            } catch (StringIndexOutOfBoundsException ex) {
                break;
            }
        }

        String evaluacion= automata.esFinal() ? "Cadena aceptada" : "Cadena no aceptada";
        
       p.lblResultado.setText(evaluacion);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            manejaEventoIngresar();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
