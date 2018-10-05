int x1=0;
int y1=0;
int x2=399;
int y2=399;
int i=0;

void setup(){
 size(400,400);
 background(255);
 stroke(255,60);
 dibujar();
}

void dibujar(){
  rectMode(CORNERS);
 do{
   
   if(i%2!=0){
     fill(134,127);
   }else{
    fill(255,60); 
   }
   
   i++;
   
   rect(x1,y1,x2,y2);
   
   x1+=20;
   y1+=20;
   
   x2-=20;
   y2-=20;
 }while(x2>200);
}
