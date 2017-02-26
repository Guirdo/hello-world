SubProceso edad <- darEdad ( )
	Definir edad Como Entero;
	
	edad<-18;
Fin SubProceso

SubProceso nombre <- nombrar ( )
	Definir nombre Como Caracter;
	nombre <-"Aldo";
Fin SubProceso

SubProceso escuela <- darEscul ()
	Definir escuela Como Caracter;
	
	escuela<-"ITCH";
	
FinSubProceso

SubProceso colo<-darCol()
	Definir colo Como Caracter;
	
	colo<-"PRD";
	
FinSubProceso


Proceso ProbandoFunc
	Definir a,b Como Entero;
	
	Escribir "Vives en el ",darCol;
	Escribir "TU nombre es: ",nombrar;
	Escribir "Tu edad es: ",darEdad;
	Escribir "Vas a clases al ",darEscul;
	Escribir "En la calle ",darCalle;
FinProceso

SubProceso calle<-darCalle()
	Definir calle Como Caracter;
	calle<-"Amalia Garcia";
FinSubProceso
