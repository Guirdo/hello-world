Proceso AccesoBanco
	Definir clave, cAcceso Como Caracter;
	Definir nVeces Como Entero;
	
	//Inizializacion de la variable con la clave
	clave<-"miclave";
	
	Repetir
		Limpiar Pantalla; 
		Escribir Sin Saltar "Password";
		Leer cAcceso;
		nVeces<-nVeces+1;
	Hasta Que clave = cAcceso o nVeces = 3
	
	Limpiar Pantalla;
	
	SI nVeces <= 3 y clave = cAcceso Entonces
		Escribir "Bienvenid a tu banco...";
	Sino
		Escribir "Su cuenta ha sido bloqueada por demasiados intentos";//Esto es un comentario rapidito
	FinSi
FinProceso
