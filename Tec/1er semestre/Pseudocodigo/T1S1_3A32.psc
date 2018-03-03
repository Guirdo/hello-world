Proceso T1S1_3A32
	
	Definir co1,co2,co3,co3a,co4,i Como Entero;
	
	co1<-0;
	co2<-1;
	co3<-1;
	co4<-1;
	
	i<-1;
	
	Escribir "Presiones una tecla para ver el resultado";
	Esperar Tecla;
	
	Mientras i<=5 Hacer
		
		Escribir co1," ",co2," ",co3," ",co4;
		
		co3a<-co3a+co3;
		
		co3<-co2+co3+co4;
		co2<-co2+(co2*2);
		
		co4<-co3a+co3;
		
		co1<-co1+1;
		
		
		i<-i+1;
		
		
	FinMientras
	
FinProceso
