public class Carta{
 
  private String numero;
  
  public Carta(){};
  
  public Carta(String numero){
    this.numero=numero;
  }
  
  public String getNumero(){
   return numero; 
  }
  
  //TODO metodo que haga visible o no las cartas, según el tipo de jugador.
  /*
  public boolean esVisible(Jugador ju){
    if(ju.getClass == ){
      
    }
  }
  */
  
  public String imprimir(){
    return numero;
  }
  
}