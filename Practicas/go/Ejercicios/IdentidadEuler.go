package main

import (
	"fmt"
)

func main() {
	var euler float64
	acum := 1.0

	for i := 1.0; i < 200; i++ {
		euler = euler + (1 / acum)
		fmt.Println(euler, 1/i)
		acum = acum * i
	}

	fmt.Println("Ha terminado.")
}
