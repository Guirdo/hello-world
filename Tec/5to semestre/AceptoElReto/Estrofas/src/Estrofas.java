import java.util.ArrayList;
import java.util.Scanner;

public class Estrofas {

    String resultados="";

    public static void main(String[] args) {
        int numVersos=0;
        Scanner scNum = new Scanner(System.in);
        Scanner scCadenas = new Scanner(System.in);
        String[] estrofa;

        do{
            numVersos=scNum.nextInt();
            if(numVersos!=0) {
                estrofa=new String[numVersos];
                for(int i=0;i<numVersos;i++){
                    estrofa[i]=scCadenas.nextLine();
                }

            }
        }while (numVersos!=0);

        System.exit(0);
    }

    public void analizarEstrofa(String[] estrofa){

        int vocales=0;
        for(int i=0;i<estrofa.length;i++){
            for(int j=estrofa[i].length();j>=0;j++){

            }
        }
    }

}
