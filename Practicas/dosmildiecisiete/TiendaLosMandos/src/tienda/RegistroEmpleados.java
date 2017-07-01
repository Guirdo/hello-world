package tienda;

import java.util.ArrayList;

public class RegistroEmpleados {
	ArrayList<Empleado> registroEmpleados;
	
	public RegistroEmpleados() {
		registroEmpleados = new ArrayList<>();
	}
	
	public void agregarEmpleado(Empleado emp){
		registroEmpleados.add(emp);
	}
	
	public boolean buscarEmpleado(String nickName,String contrasena){
		boolean seEncuentra = false;
		
		for(int i=0; i <registroEmpleados.size();i++){
			if(registroEmpleados.get(i).getNickName().equals(nickName) && registroEmpleados.get(i).getContrasena().equals(contrasena)){
				seEncuentra=true;
			}
		}
		
		return seEncuentra;
	}
	
	@Override
	public String toString() {
		String salida = "";
		
		for(int i=0; i< registroEmpleados.size(); i++){
			salida+= registroEmpleados.get(i).toString();
		}
		
		return salida;
	}
}
