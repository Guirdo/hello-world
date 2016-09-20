Proceso Anidados
	Definir num Como Entero;
	
	Escribir "Ingrese un numero entero";
	Leer num;
	
	Si num = 0 Entonces
		Escribir "El numero es neutro";
	Sino
		Si num > 0 Entonces
			Si num % 2 = 0 Entonces
				Escribir "El numero es par positivo";
			Sino
				Escribir "El numero es impar positivo";
			FinSi
		Sino
			Si num % 2 = 0 Entonces
				Escribir "El numero es par negativo";
			Sino
				Escribir "El numero es impar negativo";
			FinSi
		FinSi
	FinSi
FinProceso
