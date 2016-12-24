import javax.swing.*;

public class EntDatos3{
	public static void main (String[] args){
		//Entrada de datos
		String nombre,sexo;
		int edad;
		double sueldo;

		try{
			nombre = JOptionPane.showInputDialog(null,"Nombre: ","Entrada de datos",JOptionPane.INFORMATION_MESSAGE);
			Object sex = JOptionPane.showInputDialog(null,"Sexo: ","Entrada de datos",JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Femenino","Masculino","Indefinido"},"Femenino");
			sexo = sex.toString();
			//sexo = JOptionPane.showInputDialog(null, "Sexo: ","Entrada de datos",JOptionPane.INFORMATION_MESSAGE);
			edad = Integer.parseInt(JOptionPane.showInputDialog(null,"Edad: ","Entrada de datos",JOptionPane.INFORMATION_MESSAGE));
			sueldo = Double.parseDouble(JOptionPane.showInputDialog(null,"Sueldo: ","Entrada de datos",JOptionPane.INFORMATION_MESSAGE));

			//Salida de datos
			JOptionPane.showMessageDialog(null,"Nombre: "+nombre+"\nSexo: "+sexo+"\nEdad: "+edad+"\nSueldo: "+sueldo,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error: el dato deber ser numerico...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
		}
		System.exit(0);
	}
}
