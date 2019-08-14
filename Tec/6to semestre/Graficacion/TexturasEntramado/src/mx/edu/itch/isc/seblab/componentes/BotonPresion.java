package mx.edu.itch.isc.seblab.componentes;

import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;

import javax.swing.*;

public class BotonPresion extends JToggleButton {

    public BotonPresion(ImageIcon imagen){
        this.setIcon(imagen);
        this.setBackground(null);
        this.setBorder(BorderFactory.createLineBorder(PaletaColores.IRISH_BLUE));
    }

    public BotonPresion(String text) {
        super(text);
    }
}
