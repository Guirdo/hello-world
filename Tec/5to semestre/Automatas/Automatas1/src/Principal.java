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
        System.out.print("Introduzca numero: ");
        int n = sc.nextInt();

        String numero = ""+Math.pow(3+Math.sqrt(5),n);


        System.out.println(numero);
        char aux = 0;

        for(int i=0;i<numero.length();i++){
            aux= numero.charAt(i);
            //System.out.println(aux+"      "+Character.getType(aux));
            if(aux != '.'){
                arreglo.add(aux);
            }else{
                i=numero.length();
            }

        }

        int r=1;
        Stack pila = new Stack();
        for(int j = arreglo.size()-1;j>=0;j--){
            if(r<=3){
                pila.push(arreglo.get(j));
                r++;
            }
        }

        System.out.print(pila.pop());
        System.out.print(pila.pop());
        System.out.print(pila.pop());

        System.exit(0);

    }

    public void calculo(int n){
        long resultado=0;
        for(int i=0;i<n-1;i++){
            resultado=0;
        }
    }

    public void raizCuadrada(long n){
        long cont=0;
        long aux=0;
        while(aux >= cont*cont){
            cont++;
        }

        //return cont;
    }

}
