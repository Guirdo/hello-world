import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Principal {

    public static void main(String[] args){

        //char = 45
        boolean punto=false;
        ArrayList<Character> arreglo = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        char aux =0;
        System.out.print("Introduzca numero: ");
        int n = sc.nextInt();

        BigDecimal tres = new BigDecimal(3);
        BigDecimal cinco = new BigDecimal(5);
        BigDecimal suma = tres.add(cinco.sqrt(new MathContext(100)));

        BigDecimal numero = suma.pow(n,new MathContext(100));

        System.out.println(numero.toPlainString());

        String numeroBig = numero.toPlainString();

        for (int i=0;i<numeroBig.length();i++){
            aux=numeroBig.charAt(i);
            if(aux !='.'){
                arreglo.add(aux);
            }else{
                break;
            }
        }

        int cont =0;

        for(int i=arreglo.size();i>-1;i--){
            cont--;
            if(cont<=3){
                System.out.println(arreglo.get(i));
            }
        }

        /**
         * String numero = String.valueOf(calculo(n));
         *         System.out.println(raizCuadrada(5));
         *
         *         char aux = 0;
         *         for(int i=0;i<numero.length();i++){
         *             aux= numero.charAt(i);
         *             //System.out.println(aux+"      "+Character.getType(aux));
         *             if(aux != '.'){
         *                 arreglo.add(aux);
         *             }else{
         *                 i=numero.length();
         *             }
         *         }
         *
         *         for(int i=arreglo.size();i<=arreglo.size()-4;i--){
         *             System.out.println(arreglo.get(i));
         *         }
         */


        System.exit(0);

    }


}
