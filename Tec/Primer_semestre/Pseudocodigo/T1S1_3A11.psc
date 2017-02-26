Proceso sin_titulo
	Definir min,costo Como Entero;
	
	Escribir "Ingrese el numero de minutos de la llamada";
	Leer min;
	
	Si min > 0 Entonces
		Si min <= 5 Entonces
			Escribir "El costo de la llamada sera: $10";
		Sino
			Escribir "El costo de la llamada sera: $",min*2;
		FinSi
	Sino
		Escribir "Error: introduzca los datos correctamente.";
	FinSi
FinProceso
