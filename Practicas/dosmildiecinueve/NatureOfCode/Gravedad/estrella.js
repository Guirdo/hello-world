class Estrella{

    constructor(x,y,masa){
        this.posicion = createVector(x,y);
        this.masa = masa;

        this.radio = masa/1000;
        this.G = 0.1;   
    }

    atraer(c){
        let fuerza = p5.Vector.sub(this.posicion,c.posicion);

        let distancia = fuerza.mag();

        //distancia = constrain(distancia, 5, 35)

        fuerza.normalize();
        let esfuerzo = (this.G * this.masa * c.masa) / (distancia * distancia);
        fuerza.mult(esfuerzo);

        return fuerza;
    }

    dibujar(){
        fill(242,214,7);

        ellipse(this.posicion.x,this.posicion.y,this.radio*2,this.radio*2);
    }

}