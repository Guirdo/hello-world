Proceso sin_titulo
	Definir cal1,cal2,cal3 Como Entero;
	
	Escribir "Ingrese la primer calificacion";
	Leer cal1;
	Escribir "Ingrese la segunda calificacion";
	Leer cal2;
	Escribir "Ingrese la tercera calificacion";
	Leer cal3;
	
	Si cal1 >= 0 y cal1 <= 100 y cal2 >= 0 y cal2 <= 100 y cal3 >= 0 y cal3 <= 100 Entonces
		
		Si cal1 >= 70 y cal2 >= 70 y cal3 >= 70 Entonces
			Escribir "Aprobado";
		Sino
			Escribir "Reprobado";
		FinSi
	Sino
		Escribir "Error: introduzca calificaciones validas";
		
	FinSi
FinProceso
