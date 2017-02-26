SubProceso suma<-sumar(a,b,c)
	Definir suma Como Entero;
	
	suma<-a+b+c;
FinSubProceso

Proceso sin_titulo
	Definir x,u,z Como Entero;
	
	Escribir "Ingrese un numero";
	Leer x;
	Escribir "Ingrese un numero";
	Leer u;
	Escribir "Ingrese un numero";
	Leer z;
	
	Escribir "La suma de ",x," + ",u," + ",z," = ",sumar(x,u,z);
FinProceso
