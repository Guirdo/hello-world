
package apptienda;

public class Producto {
    private String nombre,prove;
    private int cantidad;
    private double precio;
    //private final Proveedor prove;

    public Producto(String nombre, int cantidad, double precio, String prove) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.prove = prove;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String getProve() {
        return prove;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProve(String prove) {
        this.prove = prove;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n\t-Cantidad: " + cantidad + "\n\tPrecio: $" + precio + "\n\tProveedor: " + prove+"\n\n";
    }
    
    
    
}
