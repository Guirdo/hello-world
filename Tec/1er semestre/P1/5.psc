Proceso sin_titulo
	Definir peso,tCam Como Real;
	
	Repetir
		Escribir "Ingrese la cantidad en pesos";
		Leer peso;
		
		Si peso <= 0 Entonces
			Escribir "Error: la cantidad de pesos debe ser mayor a cero";
			Escribir "Presione una tecla para continuar";
			Esperar Tecla;
		Sino
			
			Repetir
				Escribir "Ingrese el tipo de cambio";
				Leer tCam;
				
				Si tCam <= 0 Entonces
					Escribir "Tipo de cambio debe ser mayor a cero";
					Escribir "Presione una tecla para continuar";
					Esperar Tecla;
				FinSi
			Hasta Que tCam > 0
			
		FinSi
	Hasta Que peso > 0
	
	Escribir "$",peso," pesos equivalen a $",darCambio(peso,tCam)," dolares";
	
FinProceso

SubProceso cambio<-darCambio(x,u)
	Definir cambio Como Real;
	
	cambio<-x/u;
FinSubProceso
	