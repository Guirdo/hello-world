Proceso sin_titulo
	definir nD Como Entero;
	
	Repetir
		Escribir sin saltar "Introduce un numero entero mayor o igual a cero";
		Leer nD;
		
		si nD < 0 Entonces
			nD<- -nD;
		FinSi
		nD <- Trunc(nD);
	Hasta Que nD > 0
	Limpiar Pantalla;
	
	Si nD = 0 Entonces
		Escribir "0";
	Sino
		Mientras nD > 0 Hacer
			Escribir Sin Saltar nD MOD 2;
			
			nD<-Trunc(nD/2);
		FinMientras
	FinSi
FinProceso
