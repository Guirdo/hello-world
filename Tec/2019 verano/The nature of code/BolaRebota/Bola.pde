class Bola {
  PVector posicion;
  PVector velocidad;
  PVector aceleracion;
  float masa;

  Bola() {
    posicion = new PVector(random(width), height/2);
    velocidad = new PVector(0,0);
    aceleracion = new PVector(0,0);
  }

  void mover() {
    velocidad.add(aceleracion);
    posicion.add(velocidad);
    aceleracion.mult(0);
  }
  
  void aplicarFuerza(PVector fuerza){
  PVector f = PVector.div(fuerza,masa);
    aceleracion.add(f);
  }
  
  void rebotar(){
    if(posicion.x > width || posicion.x < 0){
      velocidad.x*=-1;
    }
    
    if(posicion.y > height || posicion.y < 0){
      velocidad.y*=-1;
    }
  }
  
  void dibujar(){
    stroke(0);
    strokeWeight(2);
    fill(127);
    ellipse(posicion.x,posicion.y,50,50);
  }
}
