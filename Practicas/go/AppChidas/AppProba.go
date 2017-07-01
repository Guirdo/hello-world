package main

import (
	"fmt"
	"math"
	"strconv"
)

type DatosDiscretos struct {
	clases             [2]int
	frecuencia         int
	punMedio, frePunMe float64
	freAcum            int
}

type DatosContinuos struct {
	clases             [2]float64
	frecuencia         int
	punMedio, frePunMe float64
	freAcum            int
}

/*
func darFormatoDis(arre []DaDis) string {
	var sal string

	for i := 0; i < len(arre); i++ {
		sal = sal + string(arre[i]) + "\n"
	}

	return sal
}
*/

func darFormatoCon(arre []DatosContinuos) string {
	var sal string

	for i := 0; i < len(arre); i++ {
		sal = sal + strconv.FormatFloat(arre[i].clases[0], 'g', -1, 32) + " - " + strconv.FormatFloat(arre[i].clases[1], 'g', -1, 32) +
			"\t" + strconv.Itoa(arre[i].frecuencia) + "\t" + strconv.FormatFloat(arre[i].punMedio, 'g', -1, 32) + "\t" + strconv.FormatFloat(arre[i].frePunMe, 'g', -1, 32) +
			"\t" + strconv.Itoa(arre[i].freAcum) + "\n"
	}

	return sal
}

func main() {
	fmt.Print("\033[H\033[2J")

	var opc int

	fmt.Print("Selecione el tipo de medida de tendencia central para datos...\n-no agrupados [0]\n-agrupados [1]\nR: ")
	fmt.Scanf("%d\n", &opc)
	if opc == 0 {
		fmt.Println("Ahora no sirve esta funcion...")
	} else if opc == 1 {
		fmt.Print("\033[H\033[2J")

		var muestra, tip int

		fmt.Println("\tDatos no agrupados\n")

		for muestra <= 0 {
			fmt.Print("Introduzca el valor de la muestra: ")
			fmt.Scanf("%d\n", &muestra)
		}

		fmt.Print("¿Cual es el tipo de dato? [0]Discreto - [1]Continuos")
		fmt.Scanf("%d\n", &tip)

		if tip == 0 {
			tabla := medsTenAgruDis(muestra)
			fmt.Println(tabla)
		} else if tip == 1 {
			tabla := medsTenAgruCon(muestra)
			fmt.Println(darFormatoCon(tabla))
		} else {
			fmt.Println("Error, error...")
		}

	}
}

func medsTenAgruCon(muestra int) []DatosContinuos {
	datos := make([]float64, muestra, muestra*2)

	fmt.Println("\nIntroducción de los datos\n")

	for i := 0; i < len(datos); i++ {
		fmt.Printf("Dato #%d: ", i+1)
		fmt.Scanf("%f\n", &datos[i])
	}

	vMin, vMay := detMenMayCon(datos)
	nCla := detNumClasesCon(muestra)
	ic := detIntClaseCon(vMin, vMay, nCla)

	fmt.Println(vMin, vMay, nCla, ic)

	tabla := make([]DatosContinuos, nCla, nCla*2)
	li, ls := vMin, vMin+ic
	var fre, freAcum int
	var punMe, frePunMe float64
	var clases [2]float64

	for i := 0; i < nCla; i++ {
		clases[0] = li
		clases[1] = ls
		fre = darFreCon(datos, li, ls)
		punMe = li + ls/2.0
		frePunMe = punMe * float64(fre)
		freAcum = freAcum + fre

		tabla = append(tabla, DatosContinuos{clases, fre, punMe, frePunMe, freAcum})

		li = ls
		ls = ls + ic
	}

	tabla = tabla[nCla:]

	return tabla
}

func detMenMayCon(arre []float64) (float64, float64) {
	min := arre[0]
	may := arre[0]

	for i := 0; i < len(arre); i++ {
		if arre[i] >= may {
			may = arre[i]
		} else if arre[i] <= min {
			min = arre[i]
		}
	}

	return min, may
}

func detIntClaseCon(men, may float64, nCla int) float64 {
	return (may - men) / float64(nCla)
}

func darFreCon(datos []float64, li, ls float64) int {
	var num int

	for i := 0; i < len(datos); i++ {
		if datos[i] >= li && datos[i] < ls {
			num++
		}
	}

	return num
}

func detNumClasesCon(muestra int) int {
	num := 0.0
	i := 0.0

	for float64(muestra) >= num {
		i = i + 1.0
		num = math.Pow(2, i)
	}

	return int(i)
}

func medsTenAgruDis(muestra int) []DatosDiscretos {
	datos := make([]int, muestra, muestra*2)

	fmt.Println("\nIntroducción de los datos\n")

	for i := 0; i < len(datos); i++ {
		fmt.Printf("Dato #%d: ", i+1)
		fmt.Scanf("%d\n", &datos[i])
	}

	vMin, vMay := detMenMay(datos)
	nCla := detNumClases(muestra)
	ic := detIntClase(vMin, vMay, nCla)

	fmt.Println(vMin, vMay, nCla, ic)

	tabla := make([]DatosDiscretos, nCla, nCla*2)
	li, ls := vMin, vMin+ic
	var fre, frecuenciaAcumulada int
	var punMe, frePunMe float64
	var clases [2]int

	for i := 0; i < nCla; i++ {
		clases[0] = li
		clases[1] = ls
		fre = darFrecuencia(datos, li, ls)
		punMe = (float64(li) + float64(ls)) / 2.0
		frePunMe = punMe * float64(fre)
		frecuenciaAcumulada = frecuenciaAcumulada + fre

		tabla = append(tabla, DatosDiscretos{clases, fre, punMe, frePunMe, frecuenciaAcumulada})

		li = ls
		ls = ls + ic
	}

	tabla = tabla[nCla:]

	return tabla
}

func darFrecuencia(datos []int, li, ls int) int {
	var num int

	for i := 0; i < len(datos); i++ {
		if datos[i] >= li && datos[i] < ls {
			num++
		}
	}

	return num
}

func detMenMay(arre []int) (int, int) {
	min := arre[0]
	may := arre[0]

	for i := 0; i < len(arre); i++ {
		if arre[i] >= may {
			may = arre[i]
		} else if arre[i] <= min {
			min = arre[i]
		}
	}

	return min, may
}

func detIntClase(men, may, nCla int) int {
	return int(((float64(may) - float64(men)) / float64(nCla)) + 1)
}

func detNumClases(muestra int) int {
	num := 0.0
	i := 0.0

	for float64(muestra) >= num {
		i = i + 1.0
		num = math.Pow(2, i)
	}

	return int(i)
}

//Código que después podria servir
/*
  for {
  fmt.Print("\033[H\033[2J")
  fmt.Print("¿En cuantos grupos lo dividira? R: ")
  fmt.Scanf("%d\n",&numDiv)

  if muestra % numDiv == 0{
    break
  }else{
    fmt.Print("\033[H\033[2J")
    fmt.Println("Error, division por modulo distinto a 0...")
  }
}

var array[numDiv][muestra/numDiv] int
var menMay[2][numDiv] int
var men,may int

for i:=0;i < numDiv ; i++{
  fmt.Print("\033[H\033[2J")
  fmt.Printf("Columna #%d\n",i)
  for j:=0; j < muestra/numDiv; j++ {
    fmt.Printf("Ingrese el dato #%d: ",j)
    fmt.Scanf("%d\n",&array[i][j])
    if j == 0{
      men=array[i][j]
      may=array[i][j]
    }else if array[i][j] <= men && array[i][j] >= may{
      men=array[i][j]
      may=array[i][j]
    }
  }
  //menMay[0][]
}
*/
