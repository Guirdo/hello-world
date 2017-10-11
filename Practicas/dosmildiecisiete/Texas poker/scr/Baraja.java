import java.util.ArrayList;
import java.util.Random;

public class Baraja{
  
  private ArrayList<Carta> baraja;
  
  public Baraja(){
    this.baraja= new ArrayList<>();
    cargarBaraja();
  }
  
  public ArrayList<Carta> darBaraja(){
   return baraja; 
  }
  
  public void devolverCarta(Carta carta){
    baraja.add(carta);
  }
  
  private void cargarBaraja(){
    String[] numeros = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    
    //Diamantes
    for(int i=0;i<13;i++){
      baraja.add(new Diamante(numeros[i]));
    }
    
    //Picas
    for(int i=0;i<13;i++){
      baraja.add(new Pica(numeros[i]));
    }
    
    //Corazones
    for(int i=0;i<13;i++){
      baraja.add(new Corazon(numeros[i]));
    }
    
    //Trebol
    for(int i=0;i<13;i++){
      baraja.add(new Trebol(numeros[i]));
    }
    
  }//cargarBaraja
  
  public void barajear(){
    ArrayList<Carta> barajaBarajeada = new ArrayList<>();
    Random alea = new Random();
    int num;
    
    for(int i=baraja.size();i>0;i--){
      num = alea.nextInt(i);
      
      barajaBarajeada.add(baraja.get(num));
      
      baraja.remove(num);
    }
    
    /*
    barajaBarajeada.add(baraja.get(0));
    baraja.clear();*/
    
    baraja = barajaBarajeada;
    
  }//barajear
  
  public Carta darCarta(){
    Carta carta = baraja.get(baraja.size()-1);
    baraja.remove(baraja.size()-1);
    
    return carta;
  }
  
  public String imprimir(){
   String salida="";
   
   for(int i=0; i<baraja.size();i++){
     salida+= i + ".- " + baraja.get(i).imprimir() + "\n";
   }
   
   return salida;
  }
  
  
}