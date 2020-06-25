class Cuerpo{

    constructor(x,y,masa){
        this.posicion = createVector(x, y);
        this.masa = masa;
        this.radio = this.masa/3;

        this.velocidad = createVector(0,0);
        this.aceleracion = createVector(0,0);
    }

    actualizar(){
        this.velocidad.add(this.aceleracion);
        this.posicion.add(this.velocidad);

        this.aceleracion.mult(0);
    }

    aplicarFuerza(fuerza){
        let f = p5.Vector.div(fuerza,this.masa);
        this.aceleracion.add(f);
    }

    atraer(c){
        let fuerza = p5.Vector.sub(this.posicion,c.posicion);

        let distancia = fuerza.mag();

        fuerza.normalize();
        let esfuerzo = (this.G * this.masa * c.masa) / (distancia * distancia);
        fuerza.mult(esfuerzo);

        return fuerza;
    }

    dibujar(){
        fill(255,200);
        ellipse(this.posicion.x, this.posicion.y,this.radio*2,this.radio*2);
    }

}