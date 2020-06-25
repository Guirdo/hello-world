let estrellas = [];
let cuerpos = [];

function setup() {
    createCanvas(1300, 670);

    for (i = 0; i < 2; i++) {
        estrellas[i] = new Estrella(random(width), random(height), random(10000, 20000));
    }

    for (i = 0; i < 5; i++) {
        cuerpos[i] = new Cuerpo(random(width), random(height), random(25, 40));
    }
}

function draw() {
    //background(12,56,82);

    for (i = 0; i < estrellas.length; i++) {
        estrellas[i].dibujar();
    }

    for (i = 0; i < cuerpos.length; i++) {

        for (j = 0; j < estrellas.length; j++) {
            let f = estrellas[j].atraer(cuerpos[i]);

            cuerpos[i].aplicarFuerza(f);
        }

        //atraerTodos();

        cuerpos[i].actualizar();
        cuerpos[i].dibujar();

    }
}

function atraerTodos(){
    for (j = 0; j < cuerpos.length; j++) {
        if (i != j) {
            let f = cuerpos[j].atraer(cuerpos[i]);
            cuerpos[i].aplicarFuerza(f);
        }
    }
}