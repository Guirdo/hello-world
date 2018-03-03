SubProceso may<-darMa(a,b,c)
	Definir may Como Entero;
	
	Si a > b y a > c Entonces
		may<-a;
	Sino
		si b > a y b > c Entonces
			may<-b;
		FinSi
		Si c > a y c > b Entonces
			may<-c;
		FinSi
	FinSi
FinSubProceso

Proceso sin_titulo
	Definir x,u,z Como Entero;
	
	Escribir "Ingrese un valor entero";
	Leer x;
	Escribir "Ingrese un valor entero";
	Leer u;
	Escribir "Ingrese un valor entero";
	Leer z;
	
	Escribir "El numero mayor de todo es: ",darMa(x,u,z);
FinProceso
