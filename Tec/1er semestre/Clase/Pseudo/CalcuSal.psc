Proceso CalculaSal
	Definir salBru,precioH,impues,salNeto Como Real;
	Definir numTrab,i,nHoras Como Entero;
	Definir nombre Como Caracter;
	
	i<-1;
	
	Escribir "Ingrese el numero de empleados";
	Leer numTrab;
	
	si numTrab > 0 Entonces
		Mientras i<= numTrab Hacer
			Borrar Pantalla;
			Escribir "Datos del empleado #",i;
			Escribir Sin Saltar "Nombre: ";
			Leer nombre;
			
			Escribir Sin Saltar "Numero de horas de trabajadas";
			Leer nHoras;
			
			Escribir Sin Saltar "Precio por hora trabajada: ";
			leer precioH;
			
			Si nombre <> "" y nHoras > 0 y precioH > 0 Entonces
				Borrar Pantalla;
				
				salBru<-nHoras*precioH;
				impues<-salBru*0.1;
				salNeto<-salBru-impues;
				
				Escribir "Nombre: ",nombre;
				Escribir "Sal. Bruto: ",salBru;
				Escribir "Impuesto: ",impues;
				Escribir "Sal. neto: ",salNeto;
				
				i<-i+1;
				
				Escribir "Pulse una tecla para continuar";
				Esperar Tecla;
			Sino
				Escribir "Error uno de los datos es incorrecto,pulse una tecla para continuar.";
				Esperar Tecla;
			FinSi
		FinMientras
	Sino
		Escribir "Error el numero de trabajadores es invalido";
	FinSi
FinProceso
