
package apptienda;

public class Usuario extends Persona {
    private String nickName,contrasena,numEmpleado;
    private static int numEmp=0;

    public Usuario(String nickName, String contrasena, String nombre, String sexo, String fecNac, String domicilio) {
        super(nombre, sexo, fecNac, domicilio);
        this.nickName = nickName;
        this.contrasena = contrasena;
        ++numEmp;
        numEmpleado = generaNumEmp(numEmp);
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

    @Override
    public String toString() {
        return super.toString() + "\nNickNacme: " + nickName + "\nContraseña: " + contrasena + "\nNumero de empleado: " + numEmpleado + "\n";
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
