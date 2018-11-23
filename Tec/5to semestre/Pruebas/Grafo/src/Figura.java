import java.awt.*;

public class Figura {
    //Atributos
    private int x,y,figura;
    public static final int DIAMETRO = 50;

    public Figura(int x, int y, int figura) {
        this.x = x;
        this.y = y;
        this.figura=figura;
    }

    public void pintar(Graphics g){
        if(figura==0){
            g.drawOval(this.x - DIAMETRO/2,this.y - DIAMETRO/2,DIAMETRO,DIAMETRO);
        }else if(figura==1){//cuadrado
            g.drawRect(this.x - DIAMETRO/2,this.y - DIAMETRO/2,DIAMETRO,DIAMETRO);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
