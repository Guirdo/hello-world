import java.util.Random;

public class TestNum{
  
  public static void main(String[] args){
    
    Random alea = new Random();
    
    for(int i=51;i>0;i--){
      System.out.println((i+1)+".- "+alea.nextInt(i));
    }
  }
  
}