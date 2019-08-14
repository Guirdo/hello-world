//Mota[][] matriz;
Mota m;
int peso = 2105;
int x = 0;
int y = 0;
int i = 0;
int j = 0;

void setup(){
  size(800,600);
  background(255);
  //matriz = new Mota[height/peso][width/peso];
  m = new Mota(peso);
  
}

void draw(){
  
  if(i<height/peso){
    if(j<width/peso){
      //m.paso(x,y);
      m.dibujar(x,y);
      x+=peso;
      j++;
    }else{
      j=0;
      i++;
      x=0;
      y+=peso;
    }
  }
  
}
