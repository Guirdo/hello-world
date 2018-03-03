
package demoempre1;

public class Apoyo extends Empleado {
    protected String nombrePuesto;

    public Apoyo(String nombrePuesto,String tipoPuesto, double sueldo, String nombre, String sexo, int edad) {
        super(tipoPuesto, sueldo, nombre, sexo, edad);
        this.nombrePuesto = nombrePuesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    @Override
    public String toString() {
        return super.toString()+ "\n\tNombre del Puesto: " + nombrePuesto+"\n";
    }
    
    
}
