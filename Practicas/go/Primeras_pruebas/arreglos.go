package main

import (
	"fmt"
)

func main() {
	array := [3]int{1, 2, 3}
	var array1[5] int

	fmt.Print(len(array))

	for i:=0;i<len(array1);i++{
		fmt.Printf("Ingrese el dato #%d: ",i)
		fmt.Scanf("%d\n",&array1[i])
	}

	fmt.Println("El primer arreglo: ",array)
	fmt.Println("El segundo arreglo",array1)
}
