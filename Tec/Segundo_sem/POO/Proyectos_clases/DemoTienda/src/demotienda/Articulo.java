package demotienda;

public class Articulo {

    private double precio;

    public void setPrecio() {
        precio = 3.5;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double NuePrecio) {
        this.precio = NuePrecio;
    }

    public void setPrecio(double costo, int porcentaje) {
        this.precio = costo + (costo * porcentaje / 100);
    }
}
