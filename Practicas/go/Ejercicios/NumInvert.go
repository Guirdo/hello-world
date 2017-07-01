//Programa que inverte un numero de tres digitos
//Link del problema: http://progra.usm.cl/apunte/ejercicios/1/numero-invertido.html

package main

import (
	"fmt"
	"strconv"
)

func main() {
	var num, d1, d2, d3 int
	var mun string

	fmt.Print("Ingrese un numero entero de tres digitos: ")
	fmt.Scanf("%d\n", &num)

	if num < 1000 {
		d1 = num / 100
		num = num - (d1 * 100)
	}
	if num < 100 {
		d2 = num / 10
		num = num - (d2 * 10)
	}
	if num < 10 {
		d3 = num
	}

	//Por si lo quiero pasar a un entero
	mun = strconv.Itoa(d3) + strconv.Itoa(d2) + strconv.Itoa(d1)

	fmt.Println("El numero invertido es: " + mun)

}
