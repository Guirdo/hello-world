import javax.swing.*;

public class Tarjeta extends JButton {

    private ImageIcon cara, espalda;
    private boolean volteado;

    public Tarjeta(String cara, String espalda,int x, int y){
        this.cara = new ImageIcon(cara);
        this.espalda = new ImageIcon(espalda);
        //true = cara ; false = espalda
        this.setIcon(this.espalda);
        this.setBounds(x,y,100,140);
        volteado = false;
    }

    public void setVolteado(boolean volteado){
        this.volteado = volteado;
        if(volteado){
            this.setIcon(cara);
        }else{
            this.setIcon(espalda);
        }
        System.out.println("Lo volteo");
    }

    public String direccion(){
        return cara.getImage().toString();
    }
}
