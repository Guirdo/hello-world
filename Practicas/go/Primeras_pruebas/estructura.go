package main

import(
  "fmt"
  "strconv"
)

type Persona struct{
  //Las estructuras son como las clases de java
  edad int
  nombre,fecNaci string
}

func (persona Persona) datosOrdenados() string {
  edad := strconv.Itoa(persona.edad)
  return "Nombre: "+persona.nombre+"\nEdad: "+edad+"\nFecha nacimiento: "+persona.fecNaci
}

func main()  {
  persona := Persona{19,"Aldo","03/02/1998"}

  fmt.Println(persona.datosOrdenados())
}
