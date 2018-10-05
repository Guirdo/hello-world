ArrayList<Pasto> patio = new ArrayList();
color tinte = #11D165;

void setup() {
  size(500, 500);
  for (int i=0; i<75; i++) {
    patio.add(i, new Pasto((i*3)+100, 300, 100));
  }
}

void draw() {
  if(mousePressed){
    for(int i=0;i<75;i++){
      patio.get(i).podar(mouseX,mouseY);
    }
  }
}
