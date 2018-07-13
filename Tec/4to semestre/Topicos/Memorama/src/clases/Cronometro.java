package clases;

public class Cronometro extends Thread {

    int x = 0;
    int min=0, segundos=0;
    String salSeg="",salMin="";

    public void run(){
        while (Ventana.estado){
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
            manecilla();
            x++;
        }
    }

    public void manecilla(){
        segundos++;

        if(segundos >59){
            min++;
            segundos=0;
        }

        if(segundos <10){
            salSeg = "0"+segundos;
        }else{
            salSeg = segundos+"";
        }

        if(min <10){
            salMin = "0"+min;
        }else{
            salMin = min+"";
        }

        String salida = salMin+":"+salSeg;

        Ventana.cronometro.setText(salida);
    }

}
