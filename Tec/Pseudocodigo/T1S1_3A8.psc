Proceso sin_titulo
	Definir num, num2 Como Entero;
	
	Escribir "Ingrese un numero entero";
	Leer num;
	
	Si num > 0 Entonces
		Escribir "Ingrese otro numero";
		Leer num2;
		
		Escribir num," + ",num2," = ",num+num2;
		Escribir num," - ",num2," = ",num-num2;
		Escribir num," * ",num2," = ",num*num2;
	Sino
		Escribir "ERROR: Introduzca un valor positivo";
	FinSi
	
FinProceso
