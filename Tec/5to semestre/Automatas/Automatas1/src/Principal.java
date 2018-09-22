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

        String numero = String.valueOf(calculo(n));
        System.out.println(raizCuadrada(5));

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

        for(int i=arreglo.size();i<=arreglo.size()-4;i--){
            System.out.println(arreglo.get(i));
        }

        System.exit(0);

    }

    public static double calculo(int n){
        double resultado=elevar(3+raizCuadrada(5),n);
        return resultado;
    }

    public static double raizCuadrada(int num){
        double x = num,x1;
        int i;
        do{
            x1=x;
            x = (((x * x) + num) / (2 * x));
            System.out.println(" La raiz de"+num+" es: "+ x);
        }while (x!=x1);
        return x;

    }

    public static double elevar(double m,int n){
        if(n!=0){
            return m * elevar(m,n-1);
        }else{
            return 1;
        }
    }

}
