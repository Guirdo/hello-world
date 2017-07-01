package main

import (
  "fmt"
  "strconv"
)

func main(){
  edad := 19
  //convertir edad a String
  edad_String := strconv.Itoa(edad)

  fmt.Println("Mi edad es "+edad_String)
  fmt.Println("Tambien se puede así: \n Mi edad es de "+strconv.Itoa(edad)+"\n\n")

  fmt.Println("Ahora convirtamos un int a string\n")

  anos := "20"
  anos_int,_ := strconv.Atoi(anos)

  fmt.Println(anos_int)
  fmt.Println("\n")

  //Que devuelve el segundo valor de la funcion Atoi
  esto,otro := strconv.Atoi(anos)
  fmt.Println(esto)
  fmt.Println(otro)
}
