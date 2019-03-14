//int[] puntos = {
//  0, height, width/2, 0, width, height
//};
int grado = 2;

int[] x = new int[3];
int[] y = new int[3];
int cont=0;

color[] colores = {color(255, 34, 172), color(172, 255, 34), color(34, 172, 255), 
  color(0, 0, 255), color(45, 45, 90), color(90, 45, 45)};

void setup() {
  size(600, 600);
  //fullScreen();
  background(150);
  
  x[0]=0;
  x[1]=width/2;
  x[2]=width;
  
  y[0]=height;
  y[1]=0;
  y[2]=height;
  
}

void draw() {
  if(cont==3){
    sierpinski(grado, x[0], y[0],x[1], y[1],x[2], y[2]);
    cont=0;
  }

  //sierpinski(grado, x[0], y[0],x[1], y[1],x[2], y[2]);
}

void mouseClicked() {

  if(cont<3){
    x[cont]=mouseX;
    y[cont]=mouseY;

    point(x[cont],y[cont]);
    cont++;
  }
}

void sierpinski(int grado, int... puntos) {
  //fill(colores[grado]);
  dibujarTriangulo(puntos);

  if (grado>0) {
    sierpinski(grado-1, 
      puntos[0], puntos[1], 
      (puntos[0]+puntos[2])/2, (puntos[1]+puntos[3])/2, 
      (puntos[0]+puntos[4])/2, (puntos[1]+puntos[5])/2
      );
    sierpinski(grado-1, 
      puntos[2], puntos[3], 
      (puntos[2]+puntos[4])/2, (puntos[3]+puntos[5])/2, 
      (puntos[2]+puntos[0])/2, (puntos[3]+puntos[1])/2
      );
    sierpinski(grado-1, 
      puntos[4], puntos[5], 
      (puntos[4]+puntos[0])/2, (puntos[5]+puntos[1])/2, 
      (puntos[4]+puntos[2])/2, (puntos[5]+puntos[3])/2
      );
  }
}

void dibujarTriangulo(int... puntos) {
  triangle(puntos[0], puntos[1], puntos[2], puntos[3], puntos[4], puntos[5]);
}
