package tienda;

public class Empleado extends Persona {
	private String nickName,contrasena,numeroEmpleado;
	private static int empleadoNumero = 0;
	
	public Empleado(String nombre,String sexo,String fechaNacimiento,String domicilio,String nickName,String contrasena) {
		super(nombre,sexo,fechaNacimiento,domicilio);
		this.nickName=nickName;
		this.contrasena=contrasena;
		empleadoNumero++;
		numeroEmpleado=darNumeroEmpleado(empleadoNumero);
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public static int getEmpleadoNumero() {
		return empleadoNumero;
	}
	
	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\nNickname: "+nickName+"\nNumero de empleado: "+numeroEmpleado+"\n";
	}
	
	private String darNumeroEmpleado(int empleadoNumero) {
		String nEmp;
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        if (empleadoNumero <= 9) {
            nEmp = "Emp_0" + empleadoNumero + "/" + sqlDate;
        } else {
            nEmp = "Emp_" + empleadoNumero + "/" + sqlDate;
        }

        return nEmp;
	}
}
