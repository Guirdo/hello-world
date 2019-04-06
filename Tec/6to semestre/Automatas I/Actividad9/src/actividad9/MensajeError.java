package actividad9;

import javax.swing.JLabel;
import mx.edu.itch.sistemas.seblab.Imagen.Imagen;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Boton;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.DialogoModal;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;
import net.miginfocom.swing.MigLayout;

public class MensajeError extends DialogoModal{

    public MensajeError(String titulo, String defaultExit,String descripcion) {
        super(titulo,defaultExit);
        this.setLayout(new MigLayout("","10[]15[]10","10[]10[]10"));
        this.setIconImage(Imagen.obtenerImagen(this, "/iconos/error.png").getImage());
        this.getContentPane().setBackground(PaletaColores.LINX_WHITE);
        
        JLabel icono = new JLabel();
        icono.setIcon(Imagen.obtenerImagen(this, "/iconos/error.png"));
        
        Boton btnOK = new Boton("Ok", PaletaColores.POMEGRANATE, PaletaColores.LINX_WHITE);
        btnOK.addActionListener((ActionEvent)->{
            this.dispose();
        });
        
        this.add(icono,"");
        this.add(new JLabel(descripcion),"wrap");
        this.add(btnOK,"span 2,right");
        
        this.pack();
        this.setLocationRelativeTo(null);
    }

}
