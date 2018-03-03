Proceso sin_titulo
	Definir temp Como Real;
	
	Escribir "Ingrese la temperatura del agua en centigrados";
	Leer temp;
	
	Si temp > 0 Y temp < 100 Entonces
		Escribir "El agua esta en estado liquido.";
	Sino
		Si temp >= 100 Entonces
			Escribir "El agua esta en estado gaseoso.";
		Sino
			Escribir "El agua esta en estado solido.";
		FinSi
	FinSi
FinProceso
