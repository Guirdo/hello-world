Proceso T1S1_3A4
	
	Definir cal,suma,prome,i Como Real;
	
	Para i<-1 Hasta 5 Con Paso 1 Hacer
		Escribir "Ingrese la calificacion [",i,"]";
		Leer cal;
		
		suma <- suma+cal;
	Fin Para
	
	prome<-suma/5;
	
	Escribir "El promedio es de: ",prome;
	
	
FinProceso
