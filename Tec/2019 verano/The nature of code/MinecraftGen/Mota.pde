import java.util.Random;

class Mota{
  
  int colour;
  color colorRGB;
  int x,y,peso;
  final int AZUL = 0;
  final int VERDE = 1;
  
  Random sen = new Random();
  
  Mota(int peso){
    this.peso = peso;
  }
  
  void paso(int x, int y){
    this.x = x;
    this.y=y;
    
   int colorAleatorio = (int)sen.nextGaussian();
   println(colorAleatorio);
    
    if(colorAleatorio < 70){
      colorRGB = color(10,54,231);
    }else if(colorAleatorio < 85){
     colorRGB = color(20,231,10);
    }else{
     colorRGB = color(100,34,43); 
    }
  }
  
  void dibujar(int x, int y){
   paso(x,y);
   stroke(colorRGB);
   strokeWeight(peso);
   point(x,y);
  }
  
}
