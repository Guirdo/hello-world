class Bola{

    constructor(x,y,masa){
        this.masa = masa;
        this.posicion = createVector(x,y);
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

    rebotar(){
        if(this.posicion.x > width || this.posicion.x < 0){
            this.velocidad.x = this.velocidad.x*-1;
        }

        if(this.posicion.y > height || this.posicion.y < 0){
            this.velocidad.y = this.velocidad.y * -1;
        }
    }

    dibujar(){
        fill(240,120);
        ellipse(this.posicion.x,this.posicion.y,this.masa*15);
    }

}