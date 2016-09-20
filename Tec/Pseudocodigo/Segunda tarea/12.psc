Proceso sin_titulo
	Definir camisas Como Entero;
	Definir costo,pago Como Real;
	
	Escribir "Ingrese la cantidad de camisas adquiridas";
	Leer camisas;
	Escribir "Ingrese el costo de estas";
	Leer costo;
	
	Si camisas > 0 y costo > 0 Entonces
		
		Si camisas >= 3 Entonces
			pago<- costo*camisas*0.8;
		Sino
			pago<- costo*camisas*0.9;
		FinSi
		
		Escribir "Total a pagar: $",pago;
		
	Sino
		Escribir "Error al introducir datos";
	FinSi
	
FinProceso
