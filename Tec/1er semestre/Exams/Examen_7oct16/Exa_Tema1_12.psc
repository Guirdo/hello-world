Proceso Exa_Tema1_12
	
	Definir df,rg,st,ex,cal,nCal,i Como Entero;
	Definir dfP,rgP,stP,exPo Como Real;
	
	Repetir
		Escribir "Introduzca el numero de alumnos";
		Leer nCal;
		
		SI ncal <= 0 Entonces
			Escribir "Error: introduzca un numero de alumnos mayor a cero";
		FinSi
	Hasta Que nCal > 0
	
	Para i<-1 Hasta nCal Hacer
		Escribir Sin Saltar "Introduzca la calificacion del alumno [",i,"]";
		Leer cal;
		
		Si cal >= 0 y cal <= 100 Entonces
			Si cal <= 100 y cal >=91 Entonces
				ex<-ex+1;
			Sino
				SI cal >= 81 y cal<=90 Entonces
					st<-st+1;
				FinSi
				Si cal >= 70 y cal <= 80 Entonces
					rg<-rg+1;
				FinSi
				Si cal < 70 Entonces
					df<-df+1;
				FinSi
			FinSi
		Sino
			Escribir "Error: introduzca una calificacion entre 0 y 100";
			i<-i-1;
		FinSi
	FinPara
	
	dfP<-(df/nCal)*100;
	rgP<-(rg/nCal)*100;
	stP<-(st/nCal)*100;
	exPo<-(ex/nCal)*100;
	
	Escribir "Deficiente: ",dfP,"%";
	Escribir "Regular: ",rgP,"%";
	Escribir "Satisfactorio: ",stP,"%";
	Escribir "Excelente: ",exPo,"%";
	Escribir "Estatus con mayor porcentaje: ",darMayor(dfP,rgP,stP,exPo);
	
FinProceso

SubProceso esMay<-darMayor(d,r,s,e)
	Definir esMay Como Caracter;
	
	Si d = r y d = s y d = e Entonces//1
		esMay<-"Todas son iguales";
	Sino
		Si d = r y d= s y d>e Entonces//2
			esMay<-"Deficiente, Regular y Satisfactorio";
		FinSi
		Si d=r y d>s y d=e Entonces//3
			esMay<-"Deficiente, Regular y Excelente";
		FinSi
		Si d=r y d>s y d>e Entonces//4
			esMay<-"Deficiente y Regular";
		FinSi
		Si d>r y d=s y d=e Entonces
			esMay<-"Deficiente, Satisfactorio y Excelete";
		FinSi
		Si d>r y d=s y d>e Entonces
			esMay<-"Deficiente y Satisfactorio";
		FinSi
		Si d>r y d>s y d=e Entonces
			esMay<-"Deficiente y Excelente";
		FinSi
		Si d>r y d>s y d>e Entonces//8
			esMay<-"Deficiente";
		FinSi
		Si d<r y r=s y r=e Entonces
			esMay<-"Regular, Satisfactorio y Excelente";
		FinSi
		Si d<r y r=s y r>e Entonces//10
			esMay<-"Regular y Satisfactorio";
		FinSi
		Si d<r y r>s y r=e Entonces
			esMay<-"Regular y Exelente";
		FinSi
		Si d<r y r>s y r>e Entonces//12
			esMay<-"Regular";
		FinSi
		Si d<s y r<s y s=e Entonces
			esMay<-"Satisfactorio y Excelente";
		FinSi
		Si s>d y s>r y s>e Entonces//14
			esMay<-"Satisfactorio";
		FinSi
		Si e>d y e>r y e>s Entonces
			esMay<-"Excelente";
		FinSi
	FinSi
FinSubProceso
