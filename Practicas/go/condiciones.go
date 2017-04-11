package main

import(
  "fmt"
)

func main()  {
  var x,y int

  fmt.Printf("Ingrese el valor de x: ")
  fmt.Scanf("%d\n",&x)
  fmt.Printf("Ingrese el valor de y: ")
  fmt.Scanf("%d\n",&y)

  if x > y{
    fmt.Println("x es mayor a y")
    fmt.Printf("%d > %d\n",x,y)
  }else if x < y{
    fmt.Println("y es mayor a x")
    fmt.Printf("%d < %d\n",x,y)
  }else{
    fmt.Println("x y y son iguales")
    fmt.Printf("%d = %d",x,y)
  }
}
