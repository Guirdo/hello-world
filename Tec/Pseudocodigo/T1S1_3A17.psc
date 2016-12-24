Proceso sin_titulo
	Definir pago,pagoT Como Real;
	
	Escribir "Introduzca el monto de compra";
	Leer pago;
	
	Si pago > 0 Entonces
		Si pago > 1000 Entonces
			pagoT<-pago-(pago*0.20);
			Escribir "Monto total a pagar: $",pagoT;
		Sino
			Escribir "Monto total a pagar: $",pago;
		FinSi
		
	Sino
		Escribir "Error al introducir el valor";
	FinSi
	
FinProceso
