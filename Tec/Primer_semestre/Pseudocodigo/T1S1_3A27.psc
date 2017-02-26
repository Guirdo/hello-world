Proceso T1S1_3A27
	
	Definir i,nAlum,fem,mas Como Entero;
	Definir porcenM,porcenF Como Real;
	Definir sexo Como Caracter;
	
	Escribir "Ingrese el numero de alumnos";
	Leer nAlum;
	
	Si nAlum > 0 Entonces
		Para i<-1 Hasta nAlum Hacer
			Escribir "Ingrese el sexo [F ó M] del alumno [",i,"]";
			Leer sexo;
			
			Segun sexo Hacer
				"F","f":
					fem<-fem+1;
				"M","m":
					mas<-mas+1;
				De Otro Modo:
					Escribir "Error: introduzca el caracter correcto";
					i<-i-1;
			FinSegun
		FinPara
		
		porcenF<-fem/nAlum*100;
		porcenM<-mas/nAlum*100;
		
		Escribir "El porcentaje de mujeres es de: ",porcenF,"%";
		Escribir "El porcentaje de hombres es de: ",porcenM,"%";
	Sino
		Escribir "Error: introduzca un numero de alumnos mayor a cero";
	FinSi
	
FinProceso
