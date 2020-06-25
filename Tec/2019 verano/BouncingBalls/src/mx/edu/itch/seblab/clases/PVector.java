package mx.edu.itch.seblab.clases;

public class PVector {

    public int x,y;

    public PVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void sumar(PVector v){
        this.x+=v.getX();
        this.y+=v.getY();
    }

    public void multiplicar(int num){
        this.x*=num;
        this.y*=num;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static PVector dividir(PVector f, int num){
        return new PVector(f.x/num,f.y/num);
    }
}
