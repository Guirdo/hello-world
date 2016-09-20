Proceso sin_titulo
	Definir codigo Como Entero;
	
	Escribir "Ingrese codigo de tres cifras";
	Leer codigo;
	
	Si codigo / 100 >= 1 Y codigo / 100 < 10 Entonces
		
		Si codigo MOD 5 = 0 Y codigo MOD 3 = 0 y codigo MOD 2 = 0 Entonces
			Escribir "Director general";
		Sino
			Si codigo MOD 5 = 0 Y codigo MOD 3 = 0 Entonces
				Escribir "Director";
			FinSi
			Si codigo MOD 2 = 0 Entonces
				Escribir "Staff";
			Sino
				Escribir "Seguridad";
			FinSi
		FinSi
	Sino
		Escribir "Error: introduzca el codigo de tres cifras.";
	FinSi
FinProceso
