/**
* Programa no probado, pero intuyo que si funciona xD
* Es una muestra de tipo de excepciones que hay en java y como utilizarlas.
* Escrito en bloc de notas
*/

public class Try1{
	public static void main(String[] args){
		int[] array = new int[20];
		try{	
			//array[-3] = 24;
			//int b = 0;
			//int a = 23/b;

			String s = null;
			s.equals("QQQQ");
		}catch(ArrayIndexOutOfBoundsException exception){
			System.out.println("Error, indice fuera de rango el arreglo");
			System.out.println(exception.toString());
		}catch(AritmeticException exception){
			System.out.println("Error, división por cero");
		}catch(Exception ex){
			System.out.println("Se ha generado un error que no es de indices, ni aritmetico");
			System.out.println("El objeto error es de tipo: "+ex);
		}
	}
 }