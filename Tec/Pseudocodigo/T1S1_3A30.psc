Proceso T1S1_3A30
	
	Definir dividendo,divisor,resi,coci Como Entero;
	
	Escribir "Introduzca el dividendo";
	Leer dividendo;
	Escribir "Introduzca el divisor";
	Leer divisor;
	
	resi<-divisor+1;
	
	Si dividendo > 0 y divisor > 0 Entonces
		
		Mientras resi >= divisor Hacer
			dividendo<-dividendo-divisor;
			resi<-dividendo;
			
			coci<-coci+1;
		FinMientras
		
		Escribir "El cociente es: ",coci;
		Escribir "El residuo es: ",resi;
		
	Sino
		Escribir "Error: introduzca valores mayores a cero";
	FinSi
	
FinProceso
