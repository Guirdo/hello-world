using System;

class ProgramaUno{
	public static void Main(){
		string nombre;
		int edad;
		Console.WriteLine("Hola, deme su nombre:");
		nombre = Console.ReadLine();
		Console.WriteLine("Ahora su edad: ");
		Console.Read();
		edad=Console.Read();
		Console.Write("Buenos días {0},"+
		"tu edad es {1}",nombre,edad);
	}

}