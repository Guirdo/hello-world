/*
  No creo que un huevo se coague a los 12 minutos
  Link del problema: http://progra.usm.cl/apunte/ejercicios/1/huevos-a-la-copa.html
*/

package main

import (
	"fmt"
	"math"
)

func main() {
	var tamañoHuevo int
	var pesoHuevo, tempOriginal, tiempo float64

	fmt.Print("¿Cuál es el tamaño del huevo? Chico[0] o Grande[1] R: ")
	fmt.Scanf("%d\n", &tamañoHuevo)

	if tamañoHuevo == 0 {
		pesoHuevo = 47
	} else if tamañoHuevo == 1 {
		pesoHuevo = 67
	}

	fmt.Print("¿Cuál es la temperatura del huevo, antes de meterla al agua? R: ")
	fmt.Scanf("%f,\n", &tempOriginal)

	tiempo = darTiempo(pesoHuevo, tempOriginal)
	fmt.Println(tiempo)
	fmt.Printf("El tiempo que se tardara para tenerlo listo a la copa es de: %f.\n", tiempo)
}

func darTiempo(pesoHuevo, tempOriginal float64) float64 {
	var primeraParte, segundaParte float64

	primeraParte = (math.Pow(pesoHuevo, 2/3) * math.Pow(3.8406, 1/3)) / ((0.0053 * math.Pow(math.Pi, 2)) * (math.Pow((4*math.Pi)/3, 2/3)))
	segundaParte = math.Log(0.76 * ((tempOriginal - 100) / -30))

	fmt.Println(primeraParte, segundaParte)

	return primeraParte * segundaParte
}
