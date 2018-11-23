


import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Reinicio extends JDialog {

    private int segundos;
    private boolean reiniciar;
    
    public Reinicio(String animalJugando, String animalAsignado, int clicks) {
        this.setTitle("Reiniciar juego");
        this.setSize(180, 180);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setModal(true);

        String mensajeGanador;
        segundos=10;
        reiniciar=false;

        JLabel ganador = new JLabel();
        if (clicks < 9) {
            if (animalJugando.equals(animalAsignado)) {
                mensajeGanador = "¡Has ganado!";
            } else {
                mensajeGanador = "Has perdido";
            }
        }else{
            mensajeGanador="Nadie ha ganado...";
        }
        ganador.setText(mensajeGanador);
        ganador.setBounds(20, 15, 120, 20);
        ganador.setHorizontalAlignment((int) JDialog.CENTER_ALIGNMENT);
        
        JLabel pregunta = new JLabel("¿Desea jugar de nuevo?");
        pregunta.setBounds(15, 40, 150, 20);
        
        JLabel tiempo = new JLabel(segundos+"");
        tiempo.setBounds(75, 70, 30, 20);
        //tiempo.setHorizontalAlignment((int) JDialog.CENTER_ALIGNMENT);
        
        Timer reloj = new Timer(1000,(ActionEvent)->{
            segundos--;
            tiempo.setText(segundos+"");
            
            if(segundos==-1){
                this.dispose();
            }
        });
        reloj.start();
        
        JButton si = new JButton("Sí");
        si.setBounds(30,100,50,25);
        si.addActionListener((ActionEvent)->{
            reiniciar=true;
            this.dispose();
        });
        JButton no = new JButton("No");
        no.setBounds(85,100,50,25);
        no.addActionListener((ActionEvent)->{
            this.dispose();
        });
        
        add(ganador);
        add(pregunta);
        add(tiempo);
        add(si);
        add(no);
        
    }

    public boolean isReiniciar() {
        return reiniciar;
    }
    
    public static void main(String[] args) {
        Reinicio r = new Reinicio("gato","gato",9);
        r.setVisible(true);
    }
    

}
