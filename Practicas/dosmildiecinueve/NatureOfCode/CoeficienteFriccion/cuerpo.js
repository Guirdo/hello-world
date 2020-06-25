class Cuerpo{

    constructor(x,y,masa){
        this.masa = masa;
        this.posicion = createVector(x, y);
        this.velocidad = createVector(0,0);
        this.aceleracion = createVector(0,0);
    }

    mover(){
        this.velocidad.add(this.aceleracion);
        this.posicion.add(this.velocidad);

        this.aceleracion.mult(0);
    }

    aplicarFuerza(fuerza){
        let f = p5.Vector.div(fuerza,this.masa);

        this.aceleracion.add(f);
    }

    dibujar(){
        fill(50,0,200);
        rect(this.posicion.x, this.posicion.y, this.masa*10, this.masa*10);
    }

}