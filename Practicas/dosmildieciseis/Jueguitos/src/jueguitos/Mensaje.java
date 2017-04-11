package jueguitos;

import javax.swing.JOptionPane;

public class Mensaje {
    
    String mandaMensaje(int x, int z){
        
        String mensaje = null;
        
        switch (x){
            
            case 0:
                switch(z){
                    case 0: JOptionPane.showMessageDialog(null, "Empate"); break;
                    case 1: JOptionPane.showMessageDialog(null, "¡Pierdes!"); break;
                    case 2: JOptionPane.showMessageDialog(null, "¡Ganaste!"); break;
                }
            break;
            case 1:
                switch(z){
                    case 0: JOptionPane.showMessageDialog(null, "¡Ganaste!"); break;
                    case 1: JOptionPane.showMessageDialog(null, "Empate"); break;
                    case 2: JOptionPane.showMessageDialog(null, "¡Pierdes!"); break;
                }
            break;
            case 2:
                switch(z){
                    case 0: JOptionPane.showMessageDialog(null, "¡Pierdes!"); break;
                    case 1: JOptionPane.showMessageDialog(null, "¡Ganaste!"); break;
                    case 2: JOptionPane.showMessageDialog(null, "Empate"); break;
                }
            break; 
        
        }
        
        return mensaje;
    }
    
}
