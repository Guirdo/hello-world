import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MenuSuperior extends JMenuBar {

    public MenuSuperior(){
        JMenu archivo = new JMenu("Archivo");
        archivo.setMnemonic(KeyEvent.VK_A);
        JMenu ayuda = new JMenu("Ayuda");
        archivo.setMnemonic(KeyEvent.VK_Y);

        ImageIcon iconoCerrar = new ImageIcon("/cancel.png");

        JMenuItem cerrarBoton = new JMenuItem("Cerrar",iconoCerrar);
        cerrarBoton.setMnemonic(KeyEvent.VK_C);
        cerrarBoton.setToolTipText("Cerrar la aplicación");
        cerrarBoton.addActionListener((ActionEvent event) ->{
            System.exit(0);
        });

        JMenuItem reinicar = new JMenuItem("Reinicar");
        reinicar.setMnemonic(KeyEvent.VK_R);
        reinicar.setToolTipText("Cerrar la aplicación");
        reinicar.addActionListener((ActionEvent event) ->{
            Ventana ventana = new Ventana();
            ventana.setVisible(true);
        });

        JMenuItem intrucciones = new JMenuItem("Instrucciones");
        intrucciones.setMnemonic(KeyEvent.VK_I);
        intrucciones.setToolTipText("Como usar el programa");
        intrucciones.addActionListener((ActionEvent event) ->{
            JOptionPane.showMessageDialog(null,"Introduzca las restricciones correspondientes." +
                    "\nSi necesita menos de 4 restricciones, coloce ceros en las que no va utilizar","Instrucciones",JOptionPane.INFORMATION_MESSAGE);
        });

        archivo.add(cerrarBoton);
        archivo.add(reinicar);
        ayuda.add(intrucciones);

        add(archivo);
        add(ayuda);
    }

}
