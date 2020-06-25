class Cuerpo {

    constructor(x, y, masa) {
        this.posicion = createVector(x, y);
        this.masa = masa;

        this.velocidad = createVector(0, 0);
        this.aceleracion = createVector(0, 0);
    }

    mover() {
        if (this.fondo()) {
            this.velocidad.add(this.aceleracion);
            this.posicion.add(this.velocidad);

            this.aceleracion.mult(0);
        }
    }

    fondo() {
        return this.posicion.y < height;
    }

    aplicarFuerza(fuerza) {
        let f = p5.Vector.div(fuerza, this.masa);
        this.aceleracion.add(f);
    }

    dibujar() {
        fill(50, 0, 220,50);

        ellipse(this.posicion.x, this.posicion.y, this.masa * 3, this.masa * 3);
    }

}