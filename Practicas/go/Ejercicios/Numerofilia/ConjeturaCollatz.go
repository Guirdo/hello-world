// ConjeturaCollatz
package main

import (
	"fmt"
)

func main() {
	var num, i int
	
	num = 23

	for num >= 1 {
		if num%2 == 0 {
			num = num / 2
		}
		if num%2 != 0 {
			num = (num * 3) + 1
		}
		i = i + 1
	}

	fmt.Printf("El ciclo se repitio %d veces.", i)
}
