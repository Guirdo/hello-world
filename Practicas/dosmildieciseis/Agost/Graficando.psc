Proceso Graficando
	
	Definir limS,limI,a,m,punto,x Como Real;
	
	Escribir "Ingrese la funcion con el siguiente formato: ax+m";
	Escribir "Ingrese a";
	Leer a;
	Escribir "Ingrese m";
	Leer m;
	Escribir "Ingrese el limite superior";
	Leer limS;
	Escribir "Ingrese el limite inferior";
	Leer limI;
	
	x<-limI;
	
	Mientras x<=limS Hacer
		
		Si a=0 Entonces
			punto<-x+m;
		Sino
			punto<-a*x+m;
		Fin Si
		
		Escribir "X: ",x,"	Y: ",punto;
		
		x<-x+1;
		
	Fin Mientras
	
FinProceso
