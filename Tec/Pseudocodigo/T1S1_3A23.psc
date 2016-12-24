Proceso sin_titulo
	Definir cNum,num,i,men15,may55,entre4555 Como Entero;
	
	Escribir Sin Saltar "Ingrese la cantidad de numeros enteros que desea introducir: ";
	Leer cNum;
	
	Si cNum > 0 Entonces
		Para i<-1 Hasta cNum Hacer
			Escribir "Ingrese el dato [",i,"]";
			Leer num;
			
			Si num < 15 Entonces
				men15<-men15+1;
			Sino
				Si num >= 45 y num <= 55 Entonces
					entre4555<-entre4555+1;
				FinSi
				Si num > 55 Entonces
					may55<-may55+1;
				FinSi
			FinSi
		FinPara
		
		Escribir "La cantidd de numeros menores a 15 son: ",men15;
		Escribir "La cantidd de numeros mayores a 55 son: ",may55;
		Escribir "La cantidad de numeros entre 45 y 55 son: ",entre4555;
	Sino
		Escribir "Error: el conjunto de numeros debe ser mayor a cero elementos";
	FinSi
	
	
FinProceso
