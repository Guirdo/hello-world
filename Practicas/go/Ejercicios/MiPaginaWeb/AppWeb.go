//Servidor
package main

import (
	. "fmt"
	"io/ioutil"
	"net/http"
)

type Pagina struct {
	titulo string
	cuerpo []byte
}

func (p *Pagina) guardar() error {
	filename := "./data/" + p.titulo + ".txt"
	err := ioutil.WriteFile(filename, p.cuerpo, 0600)
	return err
}

func cargarPagina(titulo string) (*Pagina, error) {
	filename := "./data/" + titulo + ".txt"
	cuerpo, err := ioutil.ReadFile(filename)
	if err != nil {
		return nil, err
	}
	pagina := &Pagina{titulo: titulo, cuerpo: cuerpo}
	return pagina, err
}

func viewHandler(w http.ResponseWriter, r *http.Request) {
	titulo := r.URL.Path[len("/view/"):]
	p, err := cargarPagina(titulo)
	if err != nil {
		Fprintf(w, "<h1>%s</h1>", err)
	}
	Fprintf(w, "<h1>%s</h1><div>%s</div>", p.titulo, p.cuerpo)
}

func cerrarServer(w http.ResponseWriter, r *http.Request) {
	Fprintf(w, "<h1>Hasta luego!</h1>")
	Println("Servidor cerrado!")
}

func main() {
	Println("Servidor iniciado...")
	http.HandleFunc("/view/", viewHandler)
	http.HandleFunc("/salir", cerrarServer)
	http.ListenAndServe(":8080", nil)
}
