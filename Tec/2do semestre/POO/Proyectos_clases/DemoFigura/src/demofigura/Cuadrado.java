
package demofigura;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Cuadrado extends Figura {
    private double lado;
    
    public Cuadrado(){
        super();
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public void calcularArea(){
        area = Math.pow(lado, 2);
    }
    
    public void calcularPerimetro(){
        perimetro = lado*4;
    }
    
    public void vizualizarDatos(){
        DecimalFormat dos = new DecimalFormat("0.00");
        String sal = "Datos del objeto Cuadrado:\n\t-Lado: "+dos.format(getLado())+"\n\t-Area: "+dos.format(getArea())+"\n\t-Perimetro: "+dos.format(getPerimetro());
        JOptionPane.showMessageDialog(null,sal,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
    }
}
