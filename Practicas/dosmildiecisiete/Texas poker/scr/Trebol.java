public class Trebol extends Carta{
 
  public Trebol(String numero){
   super(numero); 
  }
  
  @Override
  public String imprimir(){
    return super.imprimir()+"T";
  }
  
}