package main

import "fmt"

func main() {
	var num, numEle, busqueda int
	esta := false

	fmt.Print("Introduzca el numero de elementos a introducir: ")
	fmt.Scanf("%d/n", &numEle)
	
	nums := [numEle]int

	for i := 0; i < numEle; i++ {
		fmt.Printf("Elemento #%d", i)
		fmt.Scanf("&d\n", &nums[i])
	}

	fmt.Print("Introduzca el elemento a buscar: ")
	fmt.Scanf("%d\n", &busqueda)

	for i := 0; i < numEle; i++ {
		if busqueda == nums[i] {
			esta = true
			num = i
			break
		}
	}

	if esta {
		fmt.Printf("El elemento %d se encuentra en la posicion %d", busqueda, num)
	} else {
		fmt.Print("El elemento no se encuentra en el arreglo.")
	}

}
