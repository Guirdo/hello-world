package calculadora;

public class Score {

    public int sacarPuntos(int x,int y,int z){
        double puntos = 0;
        int matriz[] = new int[4];
        matriz[0]=36;
        matriz[1]=89;
        matriz[2]=163;
        matriz[3]=272;

        switch(y){//Determinada por lugar en el match
            case 0: puntos = matriz[x]*1; break;
            case 1: puntos = matriz[x]*1.05; break;
            case 2: puntos = matriz[x]*1.15; break;
            case 3: puntos = matriz[x]*1.25; break;
            case 4: puntos = matriz[x]*1.1125; break;
        }

        switch(z){//Determinada por el rank del live
            case 0: puntos = puntos*1; break;
            case 1: puntos = puntos*1.05; break;
            case 2: puntos = puntos*1.1; break;
            case 3: puntos = puntos*1.15; break;
            case 4: puntos = puntos*1.2; break;
        }

        puntos = Math.floor(puntos);
        puntos = (int) puntos;

        return (int) puntos;
    }

}
