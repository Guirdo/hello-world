package tienda;

public class Persona {
	private String nombre, fechaNacimiento, domicilio, sexo;

	public Persona(String nombre, String sexo, String fechaNacimiento, String domicilio) {
		this.nombre = nombre;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return "Nombre: "+nombre+"\nSexo: "+sexo+"\nFecha de nacimiento: "+fechaNacimiento+"\nDomicilio: "+domicilio+"\n";
	}
}
