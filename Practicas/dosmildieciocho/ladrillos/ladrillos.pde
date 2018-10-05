int x1 = 0;
int y1 = 0;
int x2 = 50;
int y2 = 30;
int contador = 0;

void setup() {
  size(300, 300);
}

void draw() {
  rectMode(CORNERS);//Es el modo de dibujo, das las cordenadas de la esquina supeperior izquierda y la esquina inferior derecha respectivamente
  do {
    rect(x1, y1, x2, y2);//Se dibuja el rectángulo
    x1+=50;
    x2+=50;//se mueve de izquierda a derecha
    if (x1>=300) {//Cuando el los rectacgulos salen de la ventana entonces
      contador++;//Aumenta el numero de la fila
      if (contador%2!=0) {//Cuando las filas son impares
        x1=-25; //Empieza desde afuera de la pantalla
        x2=25;
      } else {
        x1=0;//Empieza dentro de la pantalla
        x2=50;
      }
      y1=contador*30;
      y2=(contador+1)*30;
    }
  } while (y2<300);
}
