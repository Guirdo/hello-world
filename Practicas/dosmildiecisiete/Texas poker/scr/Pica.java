public class Pica extends Carta{
 
  public Pica(String numero){
   super(numero); 
  }
  
  @Override
  public String imprimir(){
   return super.imprimir()+"P"; 
  }
  
}