//Si, leiste bien, ler

package main

import(
  "fmt"
)

func main()  {

  //Enteros
  edad := 19
  fmt.Printf("Mi edad es %d\n",edad)

  //String
  nombre := "Aldo"
  fmt.Printf("Mi nombre es %v\n",nombre)
  fmt.Printf("Su nombre es %s\n","Adiel")

  //Booleanos
  flag := true
  fmt.Printf("La luna es hermosa: %t\n",flag)

  //Flotantes o dobles
  precio := 14.5
  fmt.Printf("El precio del arroz es: $%f\n",precio)

  distancia := 1.45234342
  fmt.Printf("La distancia entre A y B es de: %b años luz\n",distancia)

  anosLuz := 4.534233
  fmt.Printf("La distancia entre el Sol y Centaury es de: %e años luz\n\n",anosLuz)


  //LECTURA
  fmt.Println("¡Es hora ler!\n")
  //Los verbos son analogos, funcionan igual en Printf que en Scanf

  //Enteros
  var edad1 int
  fmt.Print("Ingrese su edad: ")
  fmt.Scanf("%d\n",&edad1)

  //Cadenas
  var nombre1 string
  fmt.Print("Ingrese su nombre: ")
  fmt.Scanf("%v\n",&nombre1)

  //Salida de datos
  fmt.Printf("Su edad es: %d\n",edad1)
  fmt.Printf("Su nombre es: %v\n",nombre1)

}
