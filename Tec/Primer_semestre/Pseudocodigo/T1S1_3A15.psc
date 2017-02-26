Proceso sin_titulo
	Definir vehi Como Caracter;
	Definir tasa Como Real;
	
	Escribir "Ingrese el tipo de vehiculo";
	Leer vehi;
	Escribir "Ingrese la tasa de alcohol";
	Leer tasa;
	
	Si vehi = 'C' o vehi = 'c' Entonces
		Si tasa >0.3 Entonces
			Escribir "Positivo";
		Sino
			Escribir "Negativo";
		FinSi
	FinSi
	Si vehi = 'A' o vehi = 'a' Entonces
		Si tasa >0.3 Entonces
			Escribir "Positivo";
		Sino
			Escribir "Negativo";
		FinSi
	FinSi
	Si vehi = 'T' o vehi = 't' Entonces
		Si tasa >0.5 Entonces
			Escribir "Positivo";
		Sino
			Escribir "Negativo";
		FinSi
	FinSi
	Si vehi = 'M' o vehi = 'm' Entonces
		Si tasa >0.3 Entonces
			Escribir "Positivo";
		Sino
			Escribir "Negativo";
		FinSi
	FinSi
	
FinProceso
