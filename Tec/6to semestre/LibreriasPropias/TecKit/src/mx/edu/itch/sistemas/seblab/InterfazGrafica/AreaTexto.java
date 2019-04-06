package mx.edu.itch.sistemas.seblab.InterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class AreaTexto extends JTextArea {

    public AreaTexto(int filas, int cols, boolean editable, Font fuente) {
        super(filas, cols);
        this.setEditable(editable);

        if (fuente != null) {
            this.setFont(fuente);
        }

        this.setWrapStyleWord(true);
        this.setLineWrap(true);
    }

    public AreaTexto(int filas, int cols, boolean editable, Font fuente, Color borde) {
        super(filas, cols);

        if (fuente != null) {
            this.setFont(fuente);
        }

        if (borde != null) {
            this.setBorder(BorderFactory.createLineBorder(borde));
        }

        this.setEditable(editable);
        this.setWrapStyleWord(true);
        this.setLineWrap(true);
    }
}
