package mx.edu.itch.sistemas.seblab.main;

import mx.edu.itch.sistemas.seblab.InterfazGrafica.Ventana;
import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends Ventana {

    public Main() {
        super("Calculadora", new MigLayout());
    }

    public static void main(String[] args) {
        //new Main().setVisible(true);

        String cadena = "(4+110b)101b+4";
        String patron = "(?<parEn>[\\(]?)(?<bino>(?<operando>[01]+[b]|[0-9]+[d]|[0-9]+)(?<operador>[+-/*]))"+
                            "(?<parSa>[\\)]?)";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(cadena);

        while (matcher.find()){
            System.out.print(matcher.group("parEn"));
            System.out.print(matcher.group("operando"));
            System.out.print(matcher.group("operador"));
            System.out.print(matcher.group("operando"));
            System.out.print(matcher.group("parSa"));
            System.out.println();
        }

    }
}
