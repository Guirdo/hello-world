Proceso T1S1_3A7
	
	Definir nombre Como Caracter;
	Definir costo,costoIva Como Real;
	
	Escribir "Ingrese el nombre del producto";
	Leer nombre;
	Escribir "Ingrese el costo del producto";
	Leer costo;
	
	costoIva<-costo*1.15;
	
	Escribir "Informacion del producto:";
	Escribir " - Nombre del producto: ",nombre;
	Escribir " - Costo(sin IVA): ",costo;
	Escribir " - Costo(IVA incluido): ",costoIva;
	
FinProceso
