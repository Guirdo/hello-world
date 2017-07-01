// Figuras
package main

import (
	. "fmt"
	"math"
)

type Figura struct {
	perimetro, area float64
}

type Rectangulo struct {
	base, altura float64
	Figura
}

type Circulo struct {
	radio float64
	Figura
}

func (rec *Rectangulo) darArea() {
	rec.area = rec.altura * rec.base
}

func (cir *Circulo) darArea() {
	cir.area = math.Pi * math.Pow(cir.radio, 2)
}

func (rec *Rectangulo) darPerimetro() {
	rec.perimetro = (rec.altura * 2) + (rec.base * 2)
}

func (cir *Circulo) darPerimetro() {
	cir.perimetro = math.Pi * math.Pow(cir.radio, 2)
}

func main() {
	rec := Rectangulo{base: 12.3, altura: 8}
	cir := Circulo{radio: 3.34}

	cir.darPerimetro()
	cir.darArea()
	rec.darArea()
	rec.darPerimetro()

	Println(rec)
	Println(cir)
}
