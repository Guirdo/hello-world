Proceso T1S1_3A25
	Definir cClien,i Como Entero;
	Definir pesoNa,precio,pago,ganancia Como Real;
	
	Escribir "Ingrese la cantidad de clientes que estan por pagar";
	Leer cClien;
	Escribir "Ingrese el precio/kilo de naranja";
	Leer precio;
	
	Si cClien > 0 y precio > 0 Entonces
		Para i<-1 hasta cClien Hacer
			Escribir "Ingrese los kilos de naranja del cliente [",i,"]";
			Leer pesoNa;
			
			Si pesoNa > 0 Entonces
				
				Si pesoNa > 10 Entonces
					pago<-pesoNa*precio*0.85;
				Sino
					pago<-pesoNa*precio;
				FinSi
				
				ganancia<-ganancia+pago;
				
				Escribir "Total de compra del cliente [",i,"]: $",pago;
			Sino
				Escribir "Error: datos invalidos";
				i<-i-1;
			FinSi
		FinPara
		
		Escribir "Ganancia total: $",ganancia;
		
	Sino
		Escribir "Error: ingrese un numero de clientes mayor a cero";
	FinSi
	
FinProceso
