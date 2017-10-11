public class Corazon extends Carta{
 
  public Corazon(String numero){
    super(numero);
  }
  
  @Override
  public String imprimir(){
    return super.imprimir()+"C";
  }
  
}