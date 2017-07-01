package clasescompuestas;

public class Alumno extends Persona{
    private int nControl;
    public Fecha fechaIngreso;

    public Alumno(int nControl, Fecha fechaIngreso) {
        this.nControl = nControl;
        this.fechaIngreso = fechaIngreso;
    }

    public Alumno(int nControl, Fecha fechaIngreso, String nombre, String sexo, int edad, double peso, double estatura) {
        super(nombre, sexo, edad, peso, estatura);
        this.nControl = nControl;
        this.fechaIngreso = fechaIngreso;
    }

    public int getnControl() {
        return nControl;
    }

    public void setnControl(int nControl) {
        this.nControl = nControl;
    }

    public Fecha getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Fecha fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    
}
