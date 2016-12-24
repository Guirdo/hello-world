Proceso sin_titulo
	definir dia,mes,ano,diasMes Como Entero;
	
	Escribir "Ingrese el dia (dd)";
	Leer ano;
	Escribir "Ingrese mes (mm)";
	Leer mes;
	Escribir "Ingrese el año (aaaa)";
	Leer dia;
	
	Segun mes Hacer
		
		1,3,5,7,8,10,12:
			diasMes <- 31;
		4,6,9,11:
			diasMes<-30;
		2:
			Si ano MOD 4 = 0 Entonces
				diasMes<-29;
			Sino
				diasMes<-28;
			FinSi
		De Otro Modo:
			diasMes<-0;
		
	FinSegun
	
	Si ano >= 1000 y ano <= 9999 y mes >= 1 y mes <= 12 y dia >= 1 y dia <= diasMes Entonces
		
		Escribir dia,"/",mes,"/",ano;
		
	Sino
		Escribir "Error al introducir datos";
	FinSi
	
FinProceso
