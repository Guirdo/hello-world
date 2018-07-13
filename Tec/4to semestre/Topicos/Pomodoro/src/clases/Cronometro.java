package clases;

public class Cronometro extends Thread{

    public void run(){
        while (true){
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
            minutos++;
            segundos=0;
        }

        if(segundos <10){
            salSeg="0"+segundos;
        }else{
            salSeg=segundos+"";
        }

        if(minutos <10){
            salMin="0"+minutos;
        }else{
            salMin=minutos+"";
        }

        if(pomodoro){
            if(minutos==25){
                mensaje="¡Descansa!";
                pomodoro=false;
                minutos=0;
                descanso=true;
            }
        }else if(descanso){
            if(descansos<3){
                if(minutos==5){
                    mensaje="Trabaja";
                    descansos++;
                    pomodoro=true;
                    minutos=0;
                    descanso=false;
                    System.out.println(descansos);
                }
            }else{
                if(minutos==15){
                    mensaje="Trabaja";
                    pomodoro=true;
                    minutos=0;
                    descanso=false;
                    descansos=0;
                }
            }

        }

        salida=salMin+":"+salSeg;
        Ventana.led.setText(salida);

        Ventana.mensaje.setText(mensaje);
    }

    //Declaracion de variables y objetos
    int x=0;
    int segundos =0,minutos=0;
    int descansos=0;
    String salSeg="",salMin="";
    String salida = "",mensaje="¡Trabaja!";
    boolean pomodoro = true;
    boolean descanso = false;
    //Declaracion de variables y objetos
}
