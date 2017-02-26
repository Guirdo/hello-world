package dearregloest1;

public class Persona {

    private String nombre, fechaNac, telefono;

    public Persona(String nombre, String fechaNac, String telefono) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
    }

    public Persona(Persona persona) {
        persona.getNombre();
        persona.getFechaNac();
        persona.getTelefono();
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        String sal = "-Nombre: " + nombre + ", Fecha de nacimiento: " + fechaNac + ", Telefono: " + telefono + "\n\n";
        return sal;
    }

}
