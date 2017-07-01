package main

//No me quedo tan chida como lo esperaba, seguire trabjando en ella, ahora solo queda ir a comer ;)

import(
  "fmt"
  "time"
  "strconv"
)

func main()  {
  sale := false

  for sale != true{
    go pomodo()

    var wait string
    fmt.Scanf("%v\n",&wait)

    if wait == ""{
      var conti string
      fmt.Println("Haz detenido el pomodoro")
      fmt.Print("¿Deseas continuar? ")
      fmt.Scanf("%v\n",&conti)
      if conti == "si"{
        var wait1 string
        fmt.Println("Inicia otro pomodoro")
        fmt.Scanf("%v\n",&wait1)
      }else{
        sale = true
      }
    }
  }

  fmt.Println("Hasta luego!")

}

func pomodo()  {
  tempo := 100 * time.Millisecond
  for j:=0;j < 60;j++{
    for p:=0; p < 60;p++{
      fmt.Print(strconv.Itoa(j)+":"+strconv.Itoa(p))
      if j==25{
        break
      }
      time.Sleep(tempo)
      fmt.Print("\033[H\033[2J")
    }
    if j == 25{
      break
    }
  }
}
