class Pasto{
  
  int largo;
  int x1,y1;
  
  Pasto(int x1,int y1,int largo){
    this.x1=x1;
    this.y1=y1;
    this.largo = largo;
    line(x1,y1,x1,y1-largo);
  }
  
  void podar(int x,int y){
   line(x1+30,y1+25,x,y-(largo/2));
  }
  
}
