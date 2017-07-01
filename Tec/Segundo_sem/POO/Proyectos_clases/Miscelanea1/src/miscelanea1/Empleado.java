package miscelanea1;


public class Empleado extends Persona {
    private String nickName,contrasena,numeroEmpleado;
    private static int numEmple = 0;

    public Empleado(String nickName, String contrasena, String numeroEmpleado, String nombre, String sexo, String fechaNacimiento, String domicilio, String numeroTelefonico) {
        super(nombre, sexo, fechaNacimiento, domicilio, numeroTelefonico);
        this.nickName = nickName;
        this.contrasena = contrasena;
        this.numeroEmpleado = numeroEmpleado;
        ++numEmple;
        numeroEmpleado = generaNumEmp(numEmple);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public static int getNumEmple() {
        return numEmple;
    }

    public static void setNumEmple(int numEmple) {
        Empleado.numEmple = numEmple;
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
