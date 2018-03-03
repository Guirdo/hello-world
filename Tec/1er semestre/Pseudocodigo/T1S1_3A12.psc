Proceso sin_titulo
	Definir precio,precioV Como Real;
	
	Escribir "Ingrese el precio del producto";
	Leer precio;
	
	Si precio > 0 Entonces
		si precio < 3 Entonces
			Escribir "El precio de venta es de: $",precio*1.15;
		Sino
			si precio > 6 Entonces
				Escribir "El precio de venta es de: $",precio*1.25;
			Sino
				Escribir "El precio de venta es de: $",precio+0.5;
			FinSi
		FinSi
	Sino
		Escribir "Error: introduzca un valor valido";
	FinSi
FinProceso
