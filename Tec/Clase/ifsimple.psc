Proceso sin_titulo
	
	Definir i,x Como Real;
	
	Escribir "Ingrese el valor de x:";
	Leer x;
	Escribir "Ingrese el valor de y: ";
	Leer i;
	
	Si x<0 Y i>0 Entonces
		Escribir "El punto se encuentra en el cuadrante I";
	FinSi
	Si x>0 Y i>0 Entonces
		Escribir "El punto se encuentra en el cuadreante II";
	FinSi
	Si x>0 Y i<0 Entonces
		Escribir "El punto se encuentra en el cuadreante III";
	FinSi
	Si x<0 Y i<0 Entonces
		Escribir "El punto se encuentra en el cuadreante IV";
	FinSi
	
	Si x=0 Y i>0 Entonces
		Escribir "El punto se encuentra en el eje Y+";
	FinSi
	Si x=0 Y i<0 Entonces
		Escribir "El punto se encuentra en el eje Y-";
	FinSi
	Si x>0 Y i=0 Entonces
		Escribir "El punto se encuentra en el eje X+";
	FinSi
	Si x<0 Y i=0 Entonces
		Escribir "El punto se encuentra en el eje X-";
	FinSi
	
	Si x=0 y i=0 Entonces
		Escribir "El punto se encuentra en punto de origen";
	FinSi
	
FinProceso
