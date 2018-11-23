import java.util.Random;
import java.util.Scanner;

public class Muestreo{
 
  public static void main(String[] args){
    Random alea = new Random();
    Scanner sc = new Scanner(System.in);
    int poblacion,muestra,num;
    
    poblacion = sc.nextInt();
    muestra = sc.nextInt();
    
    for(int i=1;i<=muestra;i++){
      num = alea.nextInt(poblacion);
      System.out.println(num);
    }
    
    
  }
  
}