/*
 * Hola!
 */
package solucioncabeceraoos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
class RedefineOOS extends ObjectOutputStream {

    public RedefineOOS(OutputStream out) throws IOException {
        super(out);
    }

    protected RedefineOOS() throws IOException, SecurityException {
        super();
    }

    //Metodo sin emplementar para que no haga. ¡Es magia!
    @Override
    protected void writeStreamHeader() {

    }
}

public class SolucionCabeceraOOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        File archivo = new File("datosPers.dat");
        FileOutputStream salida = null;
        Persona persona;
        Object genero[] = {"Masculino", "Femenino"};

        String nombre, sexo = null;
        int edad, sel = 0;
        double peso, estatura;

        try {
            RedefineOOS sal = new RedefineOOS(new FileOutputStream(archivo));
            
            while (sel != 1) {
            nombre = JOptionPane.showInputDialog(null, "Nombre", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
            Object sex = JOptionPane.showInputDialog(null, "Genero", "Entrada de datos", JOptionPane.QUESTION_MESSAGE, null, genero, null);
            sexo = sex.toString();
            edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
            peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Peso", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
            estatura = Double.parseDouble(JOptionPane.showInputDialog(null, "Estatura", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));

            persona = new Persona(nombre, sexo, edad, peso, estatura);

            sel = JOptionPane.showOptionDialog(null, "Desea continuar?", "Continuar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        }
            
        } catch (IOException ex) {
            Logger.getLogger(SolucionCabeceraOOS.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

}
