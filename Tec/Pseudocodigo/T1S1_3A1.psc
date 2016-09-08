Proceso T1S1_3A1
	
	Definir a,b,sum,dif,pro,expo,modu Como Entero;
	Definir cocien Como Real;
	
	Escribir "Ingresa un valor entero: ";
	Leer a;
	Escribir "Ingresa otro valor entero: ";
	Leer b;
	
	//Procesos
	sum<-a+b;
	dif<-a-b;
	pro<-a*b;
	expo<-a^b;
	modu<-a MOD b;
	cocien <- a/b;
	
	Escribir a," + ",b," = ",sum;
	Escribir a," - ",b," = ",dif;
	Escribir a," * ",b," = ",pro;
	Escribir a,"^",b," = ",expo;
	Escribir a," % ",b," = ",modu;
	Escribir a," / ",b," = ",cocien;
	
FinProceso
