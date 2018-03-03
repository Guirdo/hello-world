Proceso T1S1_3A31
	
	Definir i,num1,num2,pro Como Entero;
	
	i<-1;
	
	Escribir "Ingrese el primer numero";
	Leer num1;
	Escribir "Ingrese el segundo numero";
	Leer num2;
	
	Si num1 >0 y num2 > 0 Entonces
		
		Mientras i <= num2 Hacer
			
			pro<-pro+num1;
			i<-i+1;
			
		FinMientras
		
		Escribir "El producto de los numeros es: ",pro;
		
	Sino
		Escribir "Error: introduzca dos numeros mayores a cero";
	FinSi
	
FinProceso
