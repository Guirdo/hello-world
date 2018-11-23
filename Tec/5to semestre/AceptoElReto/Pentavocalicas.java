import java.util.Scanner;

public class Pentavocalicas{
  
  static String resultado="";
 
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    
    for(int i=0;i<num;i++){
      analizarPalabra(sc.next());
    }
    
    System.out.print(resultado);
    System.exit(0);
  }
  
  public static void analizarPalabra(String palabra){
    boolean[] estanVocales = {false,false,false,false,false};
    boolean todos = true;
    char aux;
    for(int i=0;i<palabra.length();i++){
      aux = palabra.charAt(i);
      
      switch(aux){
        case 'a': 
          estanVocales[0]=true;
        break;
        case 'e': 
          estanVocales[1]=true;
        break;
        case 'i': 
          estanVocales[2]=true;
          break;
        case 'o': 
          estanVocales[3]=true;
        break;
        case 'u':
          estanVocales[4]=true;
          break;
      }
    }
    
    for(int i=0;i<5;i++){
      if(!estanVocales[i]){
        todos=false;
        break;
      }
    }
    
    if(todos){
      resultado+="SI\n";
    }else{
      resultado+="NO\n";
    }
  }
  
}