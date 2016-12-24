Proceso Promedio
	Definir nCal,cal,sCal,i,prome Como Entero;
	
	i<-1;
	
	Escribir "Introduce la cantidad de calificaciones a capturar";
	Leer nCal;
	
	si nCal>0 Entonces
		Mientras i<=nCal Hacer
			Escribir "Introduce la calificacion [",i,"]";
			Leer cal;
			
			Si cal >= 0 y cal <= 100 Entonces
				sCal <-sCal+cal;
				i<-i+1;
			Sino
				Escribir "Error: vuelva a introducir la califacion";	
			FinSi
		FinMientras
		
		prome<-sCal/nCal;
		
		Escribir "El promedio de las ",nCal," calificaciones es: ",prome;
	Sino
		Escribir "Error";
	FinSi
	
FinProceso
