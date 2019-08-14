package mx.edu.itch.isc.seblab.componentes;

import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;

import javax.swing.*;

public class Boton extends JButton {

    public Boton(String texto) {
        this.setText(texto);
        this.setBackground(PaletaColores.EMERALD);
    }

    public Boton(ImageIcon imagen){
        this.setIcon(imagen);
        this.setBackground(null);
        this.setBorder(BorderFactory.createLineBorder(PaletaColores.IRISH_BLUE));
    }
}
