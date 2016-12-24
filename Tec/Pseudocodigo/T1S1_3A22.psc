Proceso T1S1_3A22
	Definir nCal,i,cal,menor,nAlum Como Entero;
	Definir suma,prome Como Real;
	
	Escribir "Introduzca el numero de alumnos de un grupo";
	Leer nCal;
	
	Si nCal > 0 Entonces
		
		Para i<-1 Hasta nCal Con Paso 1 Hacer
			Escribir "Ingrese la calificacion para el alumno [",i,"]";
			Leer cal;
			
			Si cal >= 0 y cal <= 100 Entonces
				suma<-suma+cal;
				
				Si i = 1 Entonces
					menor<-cal;
				Sino
					si cal < menor Entonces
						menor<-cal;
					FinSi
				FinSi
			Sino
				i<-i-1;
				Escribir "Vuelva a introducir la califacion";
			FinSi
		FinPara
		
		prome<-suma/nCal;
		
		Escribir "El promedio del grupo de ",nCal," alumnos es de: ",prome;
		Escribir "La menor calificacion es de ",menor;
	Sino
		Escribir "Error: introduzca un numero de alumnos mayor a cero";
	FinSi
	
FinProceso
