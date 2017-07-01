package demoserializable;

public class Empleado extends Persona {

    private int numEmp;
    private double sueldo;

    Empleado() {
    }

    public Empleado(int numEmp, double sueldo, String nombre, String sexo, int edad, double peso, double estatura) {
        super(nombre, sexo, edad, peso, estatura);
        this.numEmp = numEmp;
        this.sueldo = sueldo;
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
}
