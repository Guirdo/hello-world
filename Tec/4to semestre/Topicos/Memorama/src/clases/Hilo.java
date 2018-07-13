package clases;
public class Hilo extends Thread {

    public void run(){
        try{
            Thread.sleep(1000);
        }catch(Exception e){

        }

        Ventana.tarjetas[Ventana.pos1].setVolteado(false);
        Ventana.tarjetas[Ventana.pos2].setVolteado(false);
    }
}
