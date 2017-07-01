package main

import(
  "fmt"
  "strconv"
)

type Usuario struct{
  nombre,nickName,contrasena string
  numEmp int
}

func (this Usuario) toString() string {
  return "Nombre: "+this.nombre+"\nNickname: "+this.nickName+"\nNumero de empleado: "+strconv.Itoa(this.numEmp)
}

type ListaUsus struct{
  lista := make([]Usuario,0,5)
}

func (this *ListaUsus) agregarUsu(per Usuario) {
  this.lista = append(lista,per)
}

func main()  {
    var opc,numEmp int
    var sale bool
    var lista ListaUsus

    for sale != true{
      fmt.Print("\033[H\033[2J")
      fmt.Print("Bienvenido!\n-Iniciar sesión [0]\n-Registro [1]\n-Salir [2]\nR: ")
      fmt.Scanf("%d\n",&opc)
      fmt.Print("\033[H\033[2J")

      if opc==0{

      }else if opc==1{

        var nombre,usuario,contra string
        var sale bool

        for sale != true{
          fmt.Print("Ingrese el nombre: ")
          fmt.Scanf("%v\n",&nombre)

          fmt.Print("Ingrese el nickName: ")
          fmt.Scanf("%v\n",&usuario)

          fmt.Print("Ingrese la contraseña: ")
          fmt.Scanf("%v\n",&contra)

          if comprobacion(nombre,usuario,contra){
            numEmp++
            per := Usuario{nombre,usuario,contra,numEmp}
            lista = append(lista,per)

            fmt.Println("Se ha registrado un nuevo usuario")
            sale=true
            esp1 := ""
            fmt.Scanf("%v\n",&esp1)
          }else{
            fmt.Println("Error, ingrese los datos correctamente...")
          }
        }

      }else if opc==2{

        fmt.Println(lista)

        sale=true
      }else{
        var espera string
        fmt.Println("Error, introducio un valor incorrecto...")
        fmt.Scanf("%v\n",&espera)
      }
    }

}

func comprobacion(nom,usua,contra string) bool {
  if nom != "" && usua != "" && contra != ""{
    return true
  }else{
    return false
  }
}
