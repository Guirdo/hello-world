Proceso T1S1_3A29
	Definir nGru,nAlum,i,j,k Como Entero;
	Definir sumaGrus,sumaGru,sumaAlum Como Real;
	Definir cal,promeGrus,promeGru,promeAlum Como Real;
	Escribir 'Ingrese el numero de grupos';
	Leer nGru;
	Si nGru>0 Entonces
		Para i<-1 Hasta nGru Hacer
			Escribir 'Ingrese el numero del alumnos del grupo [',i,']';
			Leer nAlum;
			Borrar Pantalla;
			Si nAlum>0 Entonces
				Para j<-1 Hasta nAlum Hacer
					Escribir 'Ingrese las tres calificaciones del alumno #',j;
					Para k<-1 Hasta 3 Hacer
						Escribir k,'° calificacion: ' Sin Saltar;
						Leer cal;
						Si cal>=0 Y cal<=100 Entonces
							sumaAlum <- sumaAlum+cal;
						Sino
							k <- k-1;
							Escribir 'Error: ingrese un calificacion entre 0 y 100';
							Escribir 'Presione una tecla para continuar';
							Esperar Tecla;
						FinSi
					FinPara // Ciclo para las tres calificaciones
					promeAlum <- sumaAlum/3;
					sumaGru <- sumaGru+promeAlum;
					Escribir 'El promedio del alumno #',j,' es de: ',promeAlum;
					sumaAlum <- 0;
					Escribir 'Presione una tecla para continuar';
					Esperar Tecla;
					Borrar Pantalla;
				FinPara // Ciclo para el alumno N
				promeGru <- sumaGru/nAlum;
				sumaGrus <- sumaGrus+promeGru;
				Escribir 'El promedio del grupo [',i,'] es de: ',promeGru;
				sumaGru <- 0;
				Escribir 'Presiona una tecla para continuar';
				Esperar Tecla;
				Borrar Pantalla;
			Sino
				i <- i-1;
				Escribir 'Error: introduzca un numero de alumnos mayor a cero';
				Escribir 'Presione una tecla para continuar';
				Esperar Tecla;
				Borrar Pantalla;
			FinSi
		FinPara // Ciclo del nGru
		promeGrus <- sumaGrus/nGru;
		Escribir 'El promedio de los ',nGru,' grupos es de: ',promeGrus;
	Sino
		Escribir 'Error: introduzca un numero de grupos mayor a cero';
	FinSi
FinProceso

