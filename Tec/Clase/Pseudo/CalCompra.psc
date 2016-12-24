Proceso CalCompra
	
	Definir resp Como Caracter;
	Definir nArt Como Entero;
	Definir precioArt,totalCompra Como Real;
	
	resp<-"S";
	
	Mientras resp = "S" o resp = "s" Hacer
		Borrar Pantalla;
		Escribir "=Mi calculadora personal=";
		Escribir Sin Saltar "Numero de articulos: ";
		Leer nArt;
		
		Escribir Sin Saltar "Precio del articulo: ";
		Leer precioArt;
		
		Si nArt > 0 y precioArt > 0 Entonces
			totalCompra<-totalCompra+(nArt*precioArt);
		Sino
			Escribir "Error al introducir los datos, pulse cualquier tecla";
			Esperar Tecla;
		FinSi
		Borrar Pantalla;
		
		Escribir Sin Saltar "Desea ingresar otro articulo";
		Leer resp;
	FinMientras
	
	Borrar Pantalla;
	Escribir "El total de su compra es: $",totalCompra," pesos";
	
FinProceso
