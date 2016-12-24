Proceso T1S1_3A24
	
	Definir numPerso,i,edad Como Entero;
	Definir ni,jov,adult,adultM Como Entero;
	Definir sumaNi,sumaJov,sumaAdult,sumaAdultM Como Real;
	Definir promeNi,promeJov,promeAdul,promeAdulM,peso Como Real;
	
	Escribir "Ingrese la cantidad personas encuestadas";
	Leer numPerso;
	
	Si numPerso > 0 Entonces
		Para i<-1 Hasta numPerso Hacer
			Escribir "Ingrese la edad de la persona [",i,"]";
			Leer edad;
			
			SI edad >=1 y edad <= 120 Entonces
				
				Escribir "Ingrese el peso de la persona";
				Leer peso;
				
				Si peso > 5 Entonces
					Si edad >= 60 Entonces
						sumaAdultM<-sumaAdultM+peso;
						adultM<-adultM+1;
					Sino
						si edad >= 30 y edad <=59 Entonces
							sumaAdult<-sumaAdult+peso;
							adult<-adult+1;
						FinSi
						Si edad >=14 y edad <= 29 Entonces
							sumaJov<-sumaJov+peso;
							jov<-jov+1;
						FinSi
						Si edad >= 1 y edad <= 13 Entonces
							sumaNi<-sumaNi+peso;
							ni<-ni+1;
						FinSi
					FinSi
				Sino
					i<-i-1;
					Escribir "Error: peso incorrecto";
				FinSi
			Sino
				i<-i-1;
				Escribir "Error: la edad de la persona no es valida";
			FinSi
		FinPara
		
		promeNi<-sumaNi/ni;
		promeJov<-sumaJov/jov;
		promeAdul<-sumaAdult/adult;
		promeAdulM<-sumaAdultM/adultM;
		
		Escribir "El promedio de peso de los ",ni," niños es de: ",promeNi;
		Escribir "El promedio de peso de los ",jov,"jovenes es de: ",promeJov;
		Escribir "El promedio de peso de los ",adult,"adultos es de: ",promeAdul;
		Escribir "El promedio de peso de los ",adultM,"adultos mayores es de: ",promeAdulM;
	Sino
		Escribir "Error: numero de personas debe ser más de cero";
	FinSi
	
FinProceso
