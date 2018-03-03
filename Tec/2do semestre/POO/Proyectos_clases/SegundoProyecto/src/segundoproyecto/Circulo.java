package segundoproyecto;

public class Circulo {

    //Atributos
    public static final double PI = 3.1416;
    public double r;

    //Metodos
    public void asignaValores(double r) {
        this.r = r;
    }

    public double calculoPerimetro() {
        return 2.0 * PI * r;
    }

    public double calculaArea() {
        return PI * r * r;
    }
}
