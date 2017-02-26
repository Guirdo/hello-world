Proceso T1S1_3A26
	
	Definir i,j,vends Como Entero;
	Definir venta,suelBas,suelTo,comi Como Real;
	
	Escribir "Ingrese el numero de vendedores";
	Leer vends;
	Escribir "Ingrese el sueldo base";
	Leer suelBas;
	
	Si vends > 0 y suelBas > 0 Entonces
		Para i<-1 Hasta vends Hacer
			
			Escribir "Ventas del vendedor [",i,"]";
			
			Para j<-1 Hasta 3 Hacer
				Escribir "Ingrese el monto de la venta #",j;
				Leer venta;
				
				Si venta > 0 Entonces
					comi<-venta*0.1;
					Si j=1 Entonces
						suelTo<-suelBas+comi;
					Sino
						suelTo<-suelTo+comi;
					FinSi
				Sino
					j<-j-1;
					Escribir "Error: monto de venta invalido";
				FinSi
			FinPara
			
			Escribir "Sueldo total del empleado [",i,"]: $",suelTo;
			
		FinPara
	Sino
		Escribir "Error: vendedores y sueldo base deben ser mayor a cero";
	FinSi
	
FinProceso
