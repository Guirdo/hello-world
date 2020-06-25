let fluidos = [];
let cuerpos = [];

function setup(){
    createCanvas(700, 500);

    let x = 0;
    let y = height/2;
    for(i = 0; i< 5;i++){
        fluidos[i] = new Liquido(x,y,width/5,height/2,random(0.1,0.6));
        x += width/5;
    }

    for(i = 0; i< 10;i++){
        cuerpos[i] = new Cuerpo(random(width),30,random(4,14));
    }
}

function draw(){
    background(150);
    
    for(i = 0; i<fluidos.length;i++){
        fluidos[i].dibujar();
    }

    for(i = 0; i< cuerpos.length;i++){

        for(j = 0; j < fluidos.length; j++){
            if(fluidos[j].contiene(cuerpos[i])){
                let dragForce = fluidos[j].drag(cuerpos[i]);

                cuerpos[i].aplicarFuerza(dragForce);
            }
        }

        let gravedad = createVector(0, 0.1*cuerpos[i].masa);
        cuerpos[i].aplicarFuerza(gravedad);        

        cuerpos[i].mover();
        cuerpos[i].dibujar();
    }
    
}

function imprimir(){
    
}