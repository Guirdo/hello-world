Proceso T1S1_3A28
	
	Definir i,dig,num Como Entero;
	Definir ama,rosa,roja,verde,azul Como Entero;
	
	Escribir "Ingrese el numero de autos que circulan por las vias principales de la ciudad";
	Leer num;
	
	Si num > 0 Entonces
		
		Para i<-1 Hasta num Hacer
			Escribir "Ingrese el ultimo digito de la matricula del auto [",i,"]";
			Leer dig;
			
			Segun dig hacer
				1,2:
					ama<-ama+1;
				3,4:
					rosa<-rosa+1;
				5,6:
					roja<-roja+1;
				7,8:
					verde<-verde+1;
				9,0:
					azul<-azul+1;
				De Otro Modo:
					i<-i-1;
					Escribir "Error: introduzca un solo digito";
			FinSegun
		FinPara
		
		Escribir "El numero de autos que obtendra calcomania amarilla son: ",ama;
		Escribir "El numero de autos que obtendra calcomania rosa son: ",rosa;
		Escribir "El numero de autos que obtendra calcomania roja son: ",roja;
		Escribir "El numero de autos que obtendra calcomania verde son: ",verde;
		Escribir "El numero de autos que obtendra calcomania azul son: ",azul;
		
	Sino
		Escribir "Error: introduzca un numero de autos mayor a cero";
	FinSi
	
FinProceso
