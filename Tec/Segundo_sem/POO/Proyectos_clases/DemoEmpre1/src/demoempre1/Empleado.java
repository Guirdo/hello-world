package demoempre1;

public class Empleado extends Persona {

    protected String numEmpl, tipoPuesto;
    protected double sueldo;
    static private int numEmp = 0;

    public Empleado(String tipoPuesto, double sueldo, String nombre, String sexo, int edad) {
        super(nombre, sexo, edad);
        this.tipoPuesto = tipoPuesto;
        this.sueldo = sueldo;
        ++numEmp;
        numEmpl = generaNumEmp(numEmp);
    }

    public String getNumEmpl() {
        return numEmpl;
    }

    public void setNumEmpl(String numEmpl) {
        this.numEmpl = numEmpl;
    }

    public String getTipoPuesto() {
        return tipoPuesto;
    }

    public void setTipoPuesto(String tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public static int getNumEmp() {
        return numEmp;
    }

    public static void setNumEmp(int numEmp) {
        Empleado.numEmp = numEmp;
    }

    @Override
    public String toString() {
        return "\n\tNum. Empleado: " + numEmpl + super.toString() + "\n\t-TipoPuesto: " + tipoPuesto + "\n\t-Sueldo: $" + sueldo;
    }

    public void aumentarSueldo(double aumento) {
            sueldo += sueldo * aumento / 100;
    }

    private String generaNumEmp(int numEmp) {
        String nEmp;
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        if (numEmp <= 9) {
            nEmp = "Emp_0" + numEmp + "/" + sqlDate;
        } else {
            nEmp = "Emp_" + numEmp + "/" + sqlDate;
        }

        return nEmp;
    }
}
