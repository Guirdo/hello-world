//Link del problema: http://progra.usm.cl/apunte/ejercicios/1/indice-masa-corporal.html

package main

import(
  "fmt"
  "math"
)

func main()  {
  var peso,altura,imc float64
  var edad int
  var riesgo string

  fmt.Print("Ingrese su peso en kilogramos: ")
  fmt.Scanf("%f\n",&peso)
  fmt.Print("Ingrese su altura en metros: ")
  fmt.Scanf("%f\n",&altura)
  fmt.Print("Ingrese su edad: ")
  fmt.Scanf("%d\n",&edad)

  imc = peso/math.Pow(altura, 2)

  if edad < 45{
    if imc < 22{
      riesgo = "bajo"
    }else{
      riesgo = "medio"
    }
  }else{
    if imc < 22{
      riesgo = "medio"
    }else{
      riesgo = "alto"
    }
  }
  fmt.Printf("Su IMC es: %f.\n",imc)
  fmt.Printf("Su condicion de riesgo es %v.",riesgo)

}
