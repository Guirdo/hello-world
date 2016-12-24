Proceso T1S1_3A35
	
	Definir num,num2,res,a,mcd Como Entero;
	
	res<-1;
	
	Escribir "Ingrese un numero entero";
	Leer num;
	Escribir "Ingrese otro numero entero";
	Leer num2;
	
	si num >0 y num2 >0 Entonces
		
		si num < num2 Entonces
			
			a<-num;
			num<-num2;
			num2<-a;
			
		FinSi
		
		Mientras res > 0 Hacer
			
			res<-num MOD num2;
			
			si res = 0 Entonces
				mcd<-num2;
			Sino
				num<-num2;
				num2<-res;
			FinSi
			
		FinMientras
		
		Escribir "El MCD es: ",mcd;
	Sino
		Escribir "Error: introduzca dos valores mayores a cero";
	FinSi
	
FinProceso
