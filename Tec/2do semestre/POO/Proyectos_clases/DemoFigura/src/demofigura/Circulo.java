
package demofigura;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Circulo extends Figura {
    private double radio;
    
    public Circulo(){
        super();
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void calcularArea(){
        area = Math.PI*Math.pow(this.radio,2.0);
    }
    
    public void calcularPerimetro(){
        perimetro = 2*Math.PI*this.radio;
    }
    
    public void vizualizarDatos(){
        DecimalFormat dos = new DecimalFormat("0.00");
        String sal = "Datos del objeto Circulo:\n\t-Radio: "+dos.format(getRadio())+"\n\t-Area: "+dos.format(getArea())+"\n\t-Perimetro: "+dos.format(getPerimetro());
        JOptionPane.showMessageDialog(null,sal,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
    }
}
