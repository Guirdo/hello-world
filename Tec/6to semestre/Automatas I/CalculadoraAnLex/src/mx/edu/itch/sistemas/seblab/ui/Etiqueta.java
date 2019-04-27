package mx.edu.itch.sistemas.seblab.ui;

import javax.swing.*;
import java.awt.*;

public class Etiqueta extends JLabel {

    public Etiqueta(String texto,int estilo,int tam){
        super(texto);
        this.setFont(new Font("Arial",estilo,tam));
    }

}
