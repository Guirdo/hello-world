Proceso sin_titulo
	Definir x Como Entero;
	
	Repetir
		Limpiar Pantalla;
		Escribir "Ingrese un numero entero";
		Leer x;
		
		Si x < 0 Entonces
			Escribir "Error: numero no valido";
			Escribir "Presion una tecla para continuar";
			Esperar Tecla;
		FinSi
	Hasta Que x >= 0
	
	Escribir "El resultado es: ",sacarFac(x);
	
FinProceso

SubProceso factO <- sacarFac(n)
	
	Definir fact,factO,i Como entero;
	
	fact<-1;
	
	si n = 0 O n = 1 Entonces
		factO<-1;
	Sino
		Para i<-1 hasta n Hacer
			fact<-fact*i;
		FinPara
		factO<-fact;
	FinSi
	
FinSubProceso
