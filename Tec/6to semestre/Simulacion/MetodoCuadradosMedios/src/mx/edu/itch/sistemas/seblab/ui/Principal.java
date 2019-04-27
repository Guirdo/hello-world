package mx.edu.itch.sistemas.seblab.ui;

import mx.edu.itch.sistemas.seblab.InterfazGrafica.AreaTexto;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Boton;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Ventana;
import mx.edu.itch.sistemas.seblab.clases.MetodoCuadradosMedios;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import java.awt.*;

public class Principal extends Ventana {

    private MetodoCuadradosMedios mcm;

    public Principal() {
        super("Metodo cuadraros medios",new MigLayout("wrap 3"
                            ,"10[]10[]15[150]10","10[]5[]10[]10[]15[]10"));

        JTextField tfSemilla = new JTextField(16);
        Boton btnGenerar = new Boton("Generar", PaletaColores.PROTOSS_PYLON,PaletaColores.BLANCO);
        btnGenerar.setEnabled(false);
        DefaultListModel listModel = new DefaultListModel();
        JList list = new JList(listModel);
        SpinnerNumberModel numberModel = new SpinnerNumberModel(5,5,100,1);
        JSpinner spnIteraciones = new JSpinner(numberModel);
        AreaTexto atSalida = new AreaTexto(3,20,false,new Font("Arial",0,10)
                                                        ,PaletaColores.HUMMING_BIRD);
        atSalida.setBackground(PaletaColores.LINX_WHITE);

        //Manejo de eventos
        tfSemilla.addCaretListener((CaretEvent event)->{
            JTextField tf = (JTextField) event.getSource();
            int posicionCaret = tf.getCaretPosition();

            if(posicionCaret>=3){
                btnGenerar.setEnabled(true);
            }else{
                btnGenerar.setEnabled(false);
            }
        });

        btnGenerar.addActionListener((ActionEvent)->{
            int iteraciones = (int) spnIteraciones.getValue();
            String mensajeSalida="Se han generado los "+iteraciones+" aleatorios.";
            mcm = new MetodoCuadradosMedios(tfSemilla.getText());
            listModel.clear();

            for (int i=0;i<iteraciones;i++){
                if(mcm.findRandomNumber()){
                    listModel.addElement(mcm.getNumeroAleatorio());
                }else{
                    mensajeSalida="Solo se han podido generar "+i+" numeros de los "+iteraciones+" esperados.";
                    break;
                }
            }

            atSalida.setText(mensajeSalida);

        });


        this.add(new JLabel("Introduzca una semilla"),"span 2");
        this.add(new JLabel("Numeros generados"),"");
        this.add(tfSemilla,"span 2");
        this.add(new JScrollPane(list),"span 1 4");
        this.add(new JLabel("Iteraciones:"));
        this.add(spnIteraciones,"right");
        this.add(btnGenerar,"span 2,grow");
        this.add(new JScrollPane(atSalida),"span 2");

        this.pack();
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Principal().setVisible(true);
    }
}
