import java.util.Random;
class Walker {
  Random sen = new Random(); 
  float x, y;
  float t = 0;
  float ty = 1000;

  Walker() {
    y = height/2;
    x = width/2;
  }

  void render() {
    int colour = (int)sen.nextGaussian()*100;

    strokeWeight(5);

    if (colour < 76) {
      stroke(10, 54, 231);
    } else {
      stroke(20, 231, 10);
    }

    point(x, y);
  }

  void step() {
    t += 0.01;
    ty += 0.01;
    
    x = noise(t);
    y = noise(ty);
    
    x = map(x,0,1,0,width);
    y = map(y,0,1,0,height);
  }
}
