package mx.edu.itch.isc.seblab.componentes;

import mx.edu.itch.isc.seblab.figuras.Circulo;
import mx.edu.itch.isc.seblab.figuras.Cuadrado;
import mx.edu.itch.isc.seblab.figuras.Figura;
import mx.edu.itch.isc.seblab.figuras.Rectangulo;
import mx.edu.itch.isc.seblab.principal.Manejador;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AccionMenu extends AbstractAction {

    private String opcion;
    private Figura fig;

    public AccionMenu(String opc, Figura fig) {
        this.opcion = opc;
        this.putValue(Action.NAME,opcion);
        this.fig=fig;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.getValue(Action.NAME).equals("Cambiar tamaño...")){
            if(fig instanceof Cuadrado){
                int lado = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el lado: "));
                ((Cuadrado) fig).cambiarTamano(lado);
            }else if(fig instanceof Rectangulo){
                int ancho = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el ancho: "));
                int alto = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el alto: "));
                ((Rectangulo) fig).cambiarTamano(ancho,alto);
            }else if(fig instanceof Circulo){
                int radio = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el radio: "));
                ((Circulo) fig).cambiarTamano(radio);
            }
        }else if(this.getValue(Action.NAME).equals("Cambiar textura/tramado...")){
            fig.cambiarRelleno(Manejador.rellenoSeleccionado);
            System.out.println(Manejador.rellenoSeleccionado.getClass().getName());
        }
    }
}
