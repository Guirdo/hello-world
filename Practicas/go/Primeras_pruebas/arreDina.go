//Son arreglos dinamicos(?)

package main

import(
  "fmt"
)

func main()  {
  matriz := []int{1,2,3,4,5,6,7}

  fmt.Println(matriz)

  //Slice
  array := [4]int{4,6,8,1}
  slice := array[:1]
  fmt.Println(slice)

  nombres := make([]string,0,5)
  var nombre string
  var boton int

  for boton == 0{
    fmt.Print("Ingrese un nombre: ")
    fmt.Scanf("%v\n",&nombre)

    nombres = append(nombres,nombre)

    fmt.Print("Desea continuar?")
    fmt.Scanf("%d\n",&boton)
  }

  fmt.Println(nombres)

}
