//Link del problema: http://progra.usm.cl/apunte/ejercicios/1/triangulos.html

package main

import (
	"fmt"
)

func main() {
	var a, b, c float64

	fmt.Print("Ingrese a: ")
	fmt.Scanf("%f\n", &a)
	fmt.Print("Ingrese b: ")
	fmt.Scanf("%f\n", &b)
	fmt.Print("Ingrese c: ")
	fmt.Scanf("%f\n", &c)

	if a+b > c && b+c > a && c+a > b {
		if a == b || b == c || a == c {
			fmt.Println("El triangulo es isoceles.")
		} else {
			fmt.Println("El triangulo es escaleno.")
		}
	} else {
		fmt.Println("El triangulo no es valido.")
	}
}
