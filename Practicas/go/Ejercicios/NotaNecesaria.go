/*
  Aunque no se vea bonita la operación de la linea 23, funciona.
  Link del problema: http://progra.usm.cl/apunte/ejercicios/1/que-nota-necesito.html
*/

package main

import (
	"fmt"
)

func main() {
	var nota1, nota2, nota3, notaLab, y float64

	fmt.Print("Introduzca la nota del certamen 1: ")
	fmt.Scanf("%f\n", &nota1)
	fmt.Print("Introduzca la nota del certamen 2: ")
	fmt.Scanf("%f\n", &nota2)
	fmt.Print("Introduzca la nota del laboratorio: ")
	fmt.Scanf("%f\n", &notaLab)

	y = 60 - ((((nota1 / 3) + (nota2 / 3)) * 0.7) + (notaLab * 0.3))
	nota3 = (y / 7) * 30

	if nota3 > 100 {
		fmt.Println("Lo siento, aunque saques 100 en el certamen 3, no apruebas. \n¡Mejor suerte para la proxima!")
	} else {
		fmt.Printf("La nota necesaria para el certamen 3 es %f.\n", nota3)
	}

}
