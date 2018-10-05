int x1=125;
int y1=0;
int contador=0;

void setup() {
  size(300, 300);
  background(100);
}

void draw() {
  rectMode(CORNERS);

  do {
    
    if (contador%2==0) {
      beginShape();
      fill(255);
      vertex(x1-(contador*2), y1+(contador*10));//p1
      vertex(x1+70+(contador*2), y1+(contador*10));//p2
      vertex(x1+70+((contador+1)*2), y1+((contador+1)*10));//p3
      vertex(x1-((contador+1)*2), y1+((contador+1)*10));//p4
      vertex(x1-(contador*2), y1+(contador*10));//p1
      endShape();
    } else {
      fill(0);
      rect(x1-(contador*2),y1+((contador)*10),x1+70+(contador*2),y1+((contador+1)*10));
    }

    contador++;
  } while (contador==4);
  
 //line(85,0,85,199);
 //line(115,0,115,199);
 
  
}
