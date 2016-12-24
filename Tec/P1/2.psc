SubProceso forG<-darFor(b,a,c)
	Definir forg Como Real;
	
	forg<-b^2-(4*(a*c));
FinSubProceso

Proceso sin_titulo
	Definir b,c,a Como Real;
	
	Escribir "Calculo de la formula general de las ecuaciones cuadraticas (d = b^2-4ac)";
	Escribir Sin Saltar "Ingrese el valor de b";
	Leer b;
	Escribir Sin Saltar "Ingrese el valor de a";
	Leer a;
	Escribir Sin Saltar "Ingrese el valor de c";
	Leer c;
	
	Escribir "El resultado de d es: ",darFor(b,a,c);
FinProceso
