let bolas = [];

function setup() {
    createCanvas(500, 500);

    for (i = 0; i < 5; i++) {
        bolas[i] = new Bola(random(width), 100, random(1, 4));
    }
}

function draw() {
    background(200);

    for (i = 0; i < bolas.length; i++) {
        let gravedad = createVector(0, 0.3);
        gravedad.mult(bolas[i].masa);
        bolas[i].aplicarFuerza(gravedad);

        if (mouseIsPressed) {
            let viento = createVector(1,0.5);
            bolas[i].aplicarFuerza(viento);
        }

        bolas[i].mover();
        bolas[i].rebotar();
        bolas[i].dibujar();
    }

}