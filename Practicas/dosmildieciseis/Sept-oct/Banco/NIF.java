public class NIF{

  int dni;
  char letra;

  public NIF(){}

  public void setDNI(int dni){
    this.dni = dni;
  }

  public int getDNI(){
    return dni;
  }

  public void obtenerNIF(int dni){
      char [] letras = {'T','R','W','A','G','M',
                        'Y','F','P','D','X','B',
                        'N','J','Z','S','Q','V',
                        'H','L','C','K','E'};
      int num;
      char letra;
      num = dni % 23;

      letra = letras[num];

      this.letra = letra;
  }

  public String toString(){
    return dni+"-"+letra+"";
  }
}
