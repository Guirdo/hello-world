package tienda;

public class Producto {
	private String nombre;
	private int cantidad;
	private double precio;

	public Producto(String nombre, int cantidad, double precio) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	 public void setPrecio(double precio) {
		this.precio = precio;
	}
	 
	 @Override
	public String toString() {
		return "Nombre: "+nombre+"\nCantidad: "+cantidad+"\nPrecio: "+precio+"\n";
	}
}
