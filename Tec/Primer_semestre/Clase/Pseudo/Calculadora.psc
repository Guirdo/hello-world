Proceso sin_titulo
	Definir opc,num1,num2 Como Entero;
	
	Repetir
		Limpiar Pantalla;
		Repetir
			Escribir "Menú de operaciones basicas";
			Escribir "";
			Escribir "[1] Suma";
			Escribir "[2] Resta";
			Escribir "[3] Producto";
			Escribir "[4] Division";
			Escribir "[5] Modulo";
			Escribir "[6] Potencia";
			Escribir "[7] Salir";
			
			Escribir Sin Saltar "Seleccione la opcion deseada";
			Leer opc;
		Hasta Que opc >= 1 O opc <= 7
		
		Segun opc hacer
			1:
				Escribir Sin Saltar "Introduce el primer dato a sumar";
				Leer num1;
				Escribir Sin Saltar "Introduce el segundo dato a sumar";
				Leer num2;
				Escribir "La suma de ",num1," + ",num2," es : ",num1+num2;
			2:
				Escribir Sin Saltar "Introduce el primer dato a restar";
				Leer num1;
				Escribir Sin Saltar "Introduce el segundo dato a restar";
				Leer num2;
				Escribir "La suma de ",num1," - ",num2," es : ",num1-num2;
			3:
				Escribir Sin Saltar "Introduce el primer dato a multiplicar";
				Leer num1;
				Escribir Sin Saltar "Introduce el segundo dato a multiplicar";
				Leer num2;
				Escribir "La suma de ",num1," * ",num2," es : ",num1*num2;
			4:
				Escribir Sin Saltar "Introduce el primer dato a dividr";
				Leer num1;
				Escribir Sin Saltar "Introduce el segundo dato a dividir";
				Leer num2;
				Si num2 = 0 Entonces
					Escribir "Error division por cero";
				Sino
					Escribir "La division de ",num1," / ",num2," es : ",num1/num2;
				FinSi
			5:
				Escribir Sin Saltar "Introduce el primer dato a sacar modulo";
				Leer num1;
				Escribir Sin Saltar "Introduce el segundo dato a sacar modulo";
				Leer num2;
				Escribir "El modulo de ",num1," % ",num2," es : ",num1 MOD num2;
			6:
				Escribir Sin Saltar "Introduce la base para la potencia";
				Leer num1;
				Escribir Sin Saltar "Introduce el exponente";
				Leer num2;
				Escribir "El resultado de ",num1," a la ",num2," es : ",num1^num2;	
		FinSegun
		
		Escribir "Presione una tecla para continuar";
		Esperar Tecla;
		
	Hasta Que opc = 7
FinProceso
