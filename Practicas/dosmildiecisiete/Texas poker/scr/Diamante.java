public class Diamante extends Carta{
 
  public Diamante(String numero){
    super(numero);
  }
  
  @Override
  public String imprimir(){
    return super.imprimir()+"D";
  }
  
}