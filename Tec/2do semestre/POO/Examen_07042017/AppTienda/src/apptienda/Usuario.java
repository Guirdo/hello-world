package apptienda;

public class Usuario {

    private String nombre, sexo, fecNac, domicilio;
    private String nickName, contrasena, numEmpleado;
    private static int numEmp = 0;

    public Usuario(String nickName,String nombre, String fecNac, String domicilio,String sexo,String contrasena) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.fecNac = fecNac;
        this.domicilio = domicilio;
        this.nickName = nickName;
        this.contrasena = contrasena;
        ++numEmp;
        numEmpleado = generaNumEmp(numEmp);
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickNacme(String nickName) {
        this.nickName = nickName;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "\nNickNacme: " + nickName + "\nContraseña: " + contrasena + "\nNumero de empleado: " + numEmpleado + "\n";
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
