class Liquido {

    constructor(x_, y_, w_, h_, cd) {
        this.x = x_;
        this.y = y_;
        this.w = w_;
        this.h = h_;
        this.coefiDrag = cd;
    }

    drag(c) {
        let speed = c.velocidad.mag();
        let dragMag = this.coefiDrag * Math.pow(speed,2);

        let dragForce = c.velocidad.copy();
        dragForce.mult(-1);

        dragForce.normalize();
        dragForce.mult(dragMag);

        return dragForce;
    }

    contiene(c) {
        return c.posicion.x > this.x && c.posicion.x < (this.x + this.w) && c.posicion.y > this.y;
    }

    dibujar() {
        fill(this.coefiDrag * 255*2);

        rect(this.x, this.y, this.w, this.h);
    }

}