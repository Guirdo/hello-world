Proceso sin_titulo
	Definir x Como Entero;
	
	Escribir "Ingrese un numero entero";
	Leer x;
	
	Escribir "El numero ",x," es un numero ",determina(x);
FinProceso

SubProceso tipo<-determina(x)
	Definir tipo Como Caracter;
	
	si x = 0 Entonces
		tipo<-"Neutro";
	Sino
		si x MOD 2 = 0 Entonces
			si x > 0 Entonces
				tipo<-"Par positivo";
			Sino
				tipo<-"Par negativo";
			FinSi
		Sino
			si x > 0 Entonces
				tipo<-"Impar positivo";
			Sino
				tipo<-"Impar negativo";
			FinSi
		FinSi
	FinSi
FinSubProceso
