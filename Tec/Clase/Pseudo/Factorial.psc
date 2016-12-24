Proceso Factorial
	Definir num,i,fact Como Entero;
	
	Escribir "Introduce un valor mayor o igual a cero";
	Leer num;
	
	Si num >=0 Entonces
		Si num = 0 O num = 1 Entonces
			Escribir "El factorial de ",num," es 1";
		Sino
			
			fact<-num;
			Para i<-num-1  hasta 1 Con Paso -1 Hacer
				fact<-fact*i;
			FinPara
			
			Escribir "El factorial de ",num," es ",fact;
			
		FinSi
	Sino
		Escribir "Error el numero debe ser mayor o igual a cero";
	FinSi
FinProceso
