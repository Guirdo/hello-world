Proceso T1S1_A21
	Definir diaS,diaM,mes,ano,diasMes Como Entero;
	Definir dia,mesN Como Caracter;
	
	Escribir "Introduzca el año, en cuatro cifras";
	Leer ano;
	
	si ano >= 1000 y ano <= 9999 Entonces
		Escribir "Introduzca el mes";
		Leer mes;
		
		Segun mes Hacer
			1,3,5,7,8,10,12:
				diasMes <- 31;
				Segun mes Hacer
					1: mesN <-"Enero";
					3: mesN<-"Marzo";
					5: mesN <-"Mayo";
					7: mesN<-"Julio";
					8: mesN <-"Agosto";
					10: mesN<-"Octubre";
					12: mesN<-"Diciembre";
				FinSegun
			4,6,9,11:
				diasMes<-30;
				Segun mes Hacer
					4: mesN<-"Abril";
					6: mesN<-"Junio";	
					9: mesN<-"Septiembre";	
					11: mesN<-"Noviembre";		
				FinSegun
			2:
				mesN<-"Febrero";
				
				Si ano MOD 4 = 0 Entonces
					diasMes<-29;
				Sino
					diasMes<-28;
				FinSi
			De Otro Modo:
				diasMes<-0;
		FinSegun
		
		Escribir "Introduzca el dia del mes";
		Leer diaM;
		
		Si diaM >= 1 y diaM <= diasMes Entonces
			Escribir "Introduzca el dia de la semana";
			Leer diaS;
			
			Si diaS > 0 y diaS <= 7 Entonces
				Segun diaS Hacer
					1:
						dia<-"Domingo";
					2:
						dia<-"Lunes";
					3:
						dia<-"Martes";
					4:
						dia<-"Miercoles";
					5:
						dia<-"Jueves";
					6:
						dia<-"Viernes";
					7:
						dia<-"Sabado";
				FinSegun
				
				Escribir dia," ",diaM," de ",mesN," de ",ano;
			Sino
				Escribir "Error al introducir datos";
			FinSi
			
			
		Sino
			Escribir "Error al introducir datos";
		FinSi
	FinSi
	
	
	
FinProceso
