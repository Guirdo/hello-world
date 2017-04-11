package calculadora;

import javax.swing.*;

public class Tokens {
    
    public int sacarPuntos(int x,int y,int z){
        int puntos = 0;
        int calc[][][]= new int[4][5][5];
        int i,j,k,punts=0;
        
        if(x==0)
            punts = 15;
        if(x==1)
            punts=30;
        if(x==2)
            punts=45;
        if(x==3)
            punts=75;
            
        for(i=0;i<=x;i++){
            for(j=0;j<=y;j++){
                for(k=0;k<=z;k++){
                    calc[i][j][k] = 1;
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, "Punto obtenidos: "+calc[x][y][z]);
        
        return puntos;
    }

}
