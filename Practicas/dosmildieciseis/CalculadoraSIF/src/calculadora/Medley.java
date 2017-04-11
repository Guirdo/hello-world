package calculadora;

public class Medley {

    public int sacarPunMed(int x,int y,int z,int a1){
        double puntos = 0;
        int matriz[][] = new int[4][3];

        //matriz[Dificultad de medley][numero de canciones]
        matriz[0][0]=31;
        matriz[0][1]=64;
        matriz[0][2]=99;
        matriz[1][0]=72;
        matriz[1][1]=150;
        matriz[1][2]=234;
        matriz[2][0]=126;
        matriz[2][1]=262;
        matriz[2][2]=408;
        matriz[3][0]=241;
        matriz[3][1]=500;
        matriz[3][2]=777;

        switch (z){
            case 0: puntos = matriz[x][y] * 1; break;
            case 1: puntos = matriz[x][y] * 1.02; break;
            case 2: puntos = matriz[x][y] * 1.04; break;
            case 3: puntos = matriz[x][y] * 1.06; break;
            case 4: puntos = matriz[x][y] * 1.08; break;
        }
        switch(a1){
            case 0: puntos = puntos *1; break;
            case 1: puntos = puntos *1.05; break;
            case 2: puntos = puntos *1.1; break;
            case 3: puntos = puntos *1.15; break;
            case 4: puntos = puntos *1.2; break;
        }

        puntos = Math.floor(puntos);
        puntos = (int) puntos;

        return (int) puntos;
    }

    /*public String mostrarMensaje(int x,int y,int z){//x = Dificultad, y = puntos obtenidos
        String mensaje = "";

        if(x==0&&y==3&&z>=126)
            mensaje = "\t¡Sigue así!\n¡Tus puntos son eficientes!";
        else if(x==0&&y==2&&z>=81)
            mensaje = "\t¡Sigue así!\n¡Tus puntos son eficientes!";
        if(x==1&&y==3&&z>=257)
            mensaje = "\t¡Sigue así!\n¡Tus puntos son eficientes!";
        if(x==2&&y>=211)
            mensaje = "\t¡Sigue así!\n¡Tus puntos son eficientes!";
        if(x==3&&y>=393)
            mensaje = "\t¡Sigue así!\n¡Tus puntos son eficientes!";

        return mensaje;
    }*/

}
