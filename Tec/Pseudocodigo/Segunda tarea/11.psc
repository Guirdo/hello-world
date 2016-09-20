Proceso sin_titulo
	Definir horas Como Entero;
	Definir salario Como Real;
	
	Escribir "Ingrese el numero de horas de trabajo";
	Leer horas;
	
	Si horas > 0 Entonces
		
		Si horas <= 40 Entonces
			salario<-horas*28.78;
		Sino
			salario<- ((horas-40)*57.56)+(40*28.78);
		FinSi
		
		Escribir "Salario total de la semana: ",salario;
		
	Sino
		Escribir "Error al introducir datos";
	FinSi
FinProceso
