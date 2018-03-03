Proceso sin_titulo
	Definir presta, interes,mensua Como Real;
	Definir meses Como Entero;
	
	Escribir "Ingrese la cantidad del prestamo realizado";
	Leer presta;
	
	//Comprueba que sea mayor a cero
	Si presta > 0 Entonces
		//Determina cuantas mensualidades seran aplicadas
		Si presta > 5000 Entonces
			meses<-3;
		Sino
			Si presta > 1000 y presta<2000 o presta > 3000 y presta <= 5000 Entonces
				meses <-5;
			Sino
				Si presta >= 2000 y presta <= 3000 Entonces
				meses<-2;
				Sino
				meses<-1;
				FinSi
			FinSi
		FinSi
		
		//Determina el interes a aplicar
		Si presta < 4000 Entonces
			interes<-1.12;
		Sino
			interes<-1.1;
		FinSi
		
		//Realiza la operacion necesaria para determinar el costo de cada mensualidad
		mensua<-(presta*interes)/meses;
		
		//Imprime datos
		Escribir meses," mes(es) a pagar";
		Escribir "El costo de cada mensualidad es de: $",mensua;
		
	Sino
		//Manda error cuando el valor introducido es menor a cero
		Escribir "Error: introduzca valores validos";
	FinSi
	
FinProceso
