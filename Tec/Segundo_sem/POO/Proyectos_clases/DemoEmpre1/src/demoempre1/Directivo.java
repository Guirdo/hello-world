
package demoempre1;

public class Directivo extends Empleado {
    protected String nombrePuesto;
    protected double presupuesto;

    public Directivo(String nombrePuesto, double presupuesto, String tipoPuesto, double sueldo, String nombre, String sexo, int edad) {
        super(tipoPuesto, sueldo, nombre, sexo, edad);
        this.nombrePuesto = nombrePuesto;
        this.presupuesto = presupuesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\t-Nombre del Puesto: " + nombrePuesto + "\n\t-Presupuesto: $" + presupuesto+"\n";
    }
    
    
}
