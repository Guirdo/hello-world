package main

import (
	"fmt"
)

func main() {
	var cal, suma, promedio float64
	var num,i int

	fmt.Print("Ingrese el numero de calificaciones a ingresar: ")
	fmt.Scanf("%d\n", &num)

	for i < num {

		fmt.Printf("Ingrese la califición #%d: ", i+1)
		fmt.Scanf("%f\n", &cal)

		if cal >= 0 && cal <= 100 {
			suma = suma + cal
			i++
		} else {
			fmt.Println("Error, el dato no esta dentro del rango permitido")
		}

	}

	promedio = suma / float64(i)

	fmt.Printf("El promedio es de: %f\n", promedio)

}
