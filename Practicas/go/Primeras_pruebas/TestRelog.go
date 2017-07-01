package main

import(
  "fmt"
  "time"
  "strconv"
)

func main()  {
  go tiempo()
  var wait string
  fmt.Scanf("%v\n",&wait)
}

func tiempo()  {

  for i:=0;true;i++{
    for j:=0;j < 60;j++{
      for p:=0; p < 60;p++{
        fmt.Print(strconv.Itoa(i)+":"+strconv.Itoa(j)+":"+strconv.Itoa(p))
        time.Sleep(1000 * time.Millisecond)
        fmt.Print("\033[H\033[2J")
      }
    }
  }

}
