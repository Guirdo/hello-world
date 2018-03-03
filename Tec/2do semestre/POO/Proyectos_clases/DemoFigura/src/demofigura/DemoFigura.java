/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demofigura;

/**
 *
 * @author aldom
 */
public class DemoFigura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circulo cir = new Circulo();
        cir.setRadio(22.8);
        
        cir.calcularArea();
        cir.calcularPerimetro();
        cir.vizualizarDatos();
        
        Cuadrado cua = new Cuadrado();
        cua.setLado(12.3);
        cua.calcularArea();
        cua.calcularPerimetro();
        cua.vizualizarDatos();
        
        System.exit(0);
    }
    
}
