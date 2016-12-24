Proceso T1S1_3A33
	
	Definir inversion Como Real;
	Definir meses,i Como Entero;
	Definir conti Como Caracter;
	
	i<-1;
	
	Escribir "Ingrese el monto a invertir";
	Leer inversion;
	Escribir "Ingrese los meses que desea invertirlo";
	leer meses;
	
	Si meses > 0 y inversion > 0 Entonces
		
		Mientras i<= meses Hacer
			
			inversion<-inversion*1.02;
			
			i<-i+1;
		FinMientras
		
		Escribir "El monto total es de: ",inversion;
	Sino
		Escribir "Error al introducir los datos";
	FinSi
	
FinProceso
