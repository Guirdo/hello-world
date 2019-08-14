import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class BolaRebota extends PApplet {

ArrayList<Bola> bolas;
Bola b;

public void setup() {
  

  bolas = new ArrayList();

  for (int i=0; i<5; i++) {
    bolas.add(new Bola());
  }
}

public void draw() {
  background(255);

  for (int i=0; i<bolas.size(); i++) {
    b = bolas.get(i);
    b.aplicarFuerza(new PVector(0, 0.3f));

    if (mousePressed) {
      b.aplicarFuerza(new PVector(0.7f, 0));
    }

    b.mover();
    b.rebotar();
    b.dibujar();
  }
}
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

  public void mover() {
    velocidad.add(aceleracion);
    posicion.add(velocidad);
    aceleracion.mult(0);
  }
  
  public void aplicarFuerza(PVector fuerza){
  PVector f = PVector.div(fuerza,masa);
    aceleracion.add(f);
  }
  
  public void rebotar(){
    if(posicion.x > width || posicion.x < 0){
      velocidad.x*=-1;
    }
    
    if(posicion.y > height || posicion.y < 0){
      velocidad.y*=-1;
    }
  }
  
  public void dibujar(){
    stroke(0);
    strokeWeight(2);
    fill(127);
    ellipse(posicion.x,posicion.y,50,50);
  }
}
  public void settings() {  size(600, 400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "BolaRebota" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
