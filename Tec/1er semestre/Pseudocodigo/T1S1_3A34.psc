Proceso T1SI1_3A34
	
	Definir numEm,i,may30,men30 Como Entero;
	Definir sueldo,empre Como Real;
	
	i<-1;
	
	Escribir "Ingrese el numero de empleados";
	Leer numEm;
	
	Si numEm >0 Entonces
		
		Mientras i<= numEm Hacer
			
			Si i = 0 Entonces
				i<-1;
			FinSi
			
			Escribir "Ingrese el sueldo del empleado [",i,"]";
			Leer sueldo;
			
			Si sueldo >= 1000 y sueldo <= 5000 Entonces
				empre<-empre+sueldo;
				
				SI sueldo > 3000 Entonces
					may30<-may30+1;
				Sino
					men30<-men30+1;
				FinSi
				
				i<-i+1;
			Sino
				i<-i-1;
				Escribir "Error: introduzca un sueldo entre 1000 y 5000";
			FinSi
		FinMientras
		
		Escribir "Empleados con sueldo mayor o igual a $1000 y menor o igual a 3000: ",men30;
		Escribir "Empleados con sueldo mayor a $3000: ",may30;
		Escribir "Pago total de sueldos que hace la empresa: $",empre;
	Sino
		Escribir "Error: introduzca un numero de empleados mayor a cero";
	FinSi
	
	
FinProceso
