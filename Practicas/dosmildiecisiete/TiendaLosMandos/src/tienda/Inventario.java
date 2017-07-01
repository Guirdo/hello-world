package tienda;

import java.util.ArrayList;

public class Inventario {
	ArrayList<Producto> inventario;
	
	public Inventario() {
		inventario = new ArrayList<>();
	}
	
	public void agregarProducto(Producto pro) {
		inventario.add(pro);
	}
	
	public int busqueda(String nombre) {
		int num = 0;
		
		for(int i=0; i < inventario.size();i++){
			if(inventario.get(i).getNombre().equals(nombre)){
				num = i;
			}else{
				num = -1;
			}
		}
		
		return num;
	}
	
	@Override
	public String toString() {
		String salida = "";
		
		for(int i=0; i< inventario.size(); i++){
			salida += inventario.get(i).toString();
		}
		
		return salida;
	}
}
