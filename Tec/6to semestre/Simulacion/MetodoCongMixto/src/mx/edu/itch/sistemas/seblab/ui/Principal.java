package mx.edu.itch.sistemas.seblab.ui;

import mx.edu.itch.sistemas.seblab.InterfazGrafica.Boton;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Ventana;
import mx.edu.itch.sistemas.seblab.clases.MetodoCongruencialMixto;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Principal extends Ventana {

    public Principal(){
        super("Metodo congruencial",new MigLayout("wrap 3",
                                            "10[]15[100,right]15[]"
                                            ,"10[]10[]10[]10[]10[]10[]10[]10"));

        JTextField tfSemilla = new JTextField(20);
        JTextField tfA = new JTextField(20);
        JTextField tfC = new JTextField(20);
        JTextField tfM = new JTextField(20);
        Boton btnGenerar = new Boton("Generar", PaletaColores.PROTOSS_PYLON,PaletaColores.LINX_WHITE);
        DefaultListModel model = new DefaultListModel();
        JList listNumeros = new JList(model);
        SpinnerNumberModel numberModel = new SpinnerNumberModel(5,5,100,1);
        JSpinner spinner = new JSpinner(numberModel);

        btnGenerar.addActionListener((ActionEvent)->{
            double semilla = Double.parseDouble(tfSemilla.getText());
            double a = Double.parseDouble(tfA.getText());
            double c = Double.parseDouble(tfC.getText());
            double m = Double.parseDouble(tfM.getText());

            int iteraciones = (int)spinner.getValue();

            MetodoCongruencialMixto mcm = new MetodoCongruencialMixto(4,5,7,8);
            mcm.generarNumerosAleatorios(iteraciones,model);

        });

        this.add(new JLabel("Semilla: "),"");
        this.add(tfSemilla,"");
        this.add(new JScrollPane(listNumeros),"span 1 7, growy");
        this.add(new JLabel("A: "),"");
        this.add(tfA,"");
        this.add(new JLabel("C: "),"");
        this.add(tfC);
        this.add(new JLabel("M: "));
        this.add(tfM);
        this.add(new JLabel("Iteraciones: "));
        this.add(spinner);
        this.add(btnGenerar,"span 2,grow");

        this.pack();
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        new Principal().setVisible(true);


    }

}
