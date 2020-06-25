let c;

function setup(){
    createCanvas(700,500);

    c = new Cuerpo(0,height/2,4);

    let empuje = createVector(13,0);
        c.aplicarFuerza(empuje);
}

function draw(){
    background(200);

    fill(200,0,50);
    rect(0,0,width/2,height);

    if(c.posicion.x > width/2){
        let friccion = c.velocidad.copy();
        friccion.normalize();
        let mu = -0.1;
        friccion.mult(mu);
        c.aplicarFuerza(friccion);
    }

    c.mover();
    c.dibujar();
    
}