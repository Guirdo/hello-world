ArrayList<Bola> bolas;
Bola b;

void setup() {
  size(600, 400);

  bolas = new ArrayList();

  for (int i=0; i<5; i++) {
    bolas.add(new Bola());
  }
}

void draw() {
  background(255);

  for (int i=0; i<bolas.size(); i++) {
    b = bolas.get(i);
    b.aplicarFuerza(new PVector(0, 0.3));

    if (mousePressed) {
      b.aplicarFuerza(new PVector(0.7, 0));
    }

    b.mover();
    b.rebotar();
    b.dibujar();
  }
}
