
package appuniversitaria;

public class Empleado extends Persona {
    private int numEmp;
    private double sueldo;
    public Turno turno;

    public Empleado(int numEmp, double sueldo, Turno turno, String nombre, int edad) {
        super(nombre, edad);
        this.numEmp = numEmp;
        this.sueldo = sueldo;
        this.turno = turno;
    }

    public int getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(int numEmp) {
        this.numEmp = numEmp;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNum Empleado: " + numEmp + "\nSueldo: $" + sueldo + "\nTurno: " + turno ;
    }
    
    
}
