/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demofigura;

public class Figura {
    protected double area,perimetro;
    
    public Figura(){
        area = 0;
        perimetro = 0;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }
    
    public void calcularArea(){}
    public void calcularPerimetro(){}
    public void vizualizarDatos(){}
}
