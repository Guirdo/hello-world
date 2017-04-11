public class Empleado{

  private int nif,numHijos,hrsEx;
  private String nombre;
  private boolean casado;
  private double irpff,impHE,suelBa;

  public Empleado(){
  }

  public int getNif(){
    return nif;
  }
  public void setNif(int nif){
    this.nif = nif;
  }

  public int getNumHi(){
    return numHijos;
  }
  public void setNumHi(int numHijos){
    this.numHijos = numHijos;
  }

  public int getHoEx(){
    return hrsEx;
  }
  public void setHoEx(int hrsEx){
    this.hrsEx = hrsEx;
  }

  public String getNom(){
    return nombre;
  }
  public void setNom(String nombre){
    this.nombre = nombre;
  }

  public boolean getCas(){
    return casado;
  }
  public void setCas(char s){

    if (s == 'S') {
      this.casado = true;
    }else{
      this.casado = false;
    }
  }

  public double getIrpff(){
    return irpff;
  }
  public void setIrpff(double irpff){

    double irpffC=irpff-getNumHi();

    this.irpff = irpffC;
  }

  public double getImHE(){
    return impHE;
  }
  public void setImHE(double impHE){
    this.impHE = impHE;
  }

  public double getSuB(double suelBa){
    return suelBa;
  }
  public void setSuB(double suelBa){
    this.suelBa = suelBa;
  }

  public String toString(){
    return nif+" "+nombre+"\n"+
    "Sueldo base: "+suelBa+
    "\nHoras extras: "+hrsEx+
    "\nTipo IRPFF: "+irpff+
    "\nCasado: "+casado+
    "\nNumero de hijos: "+numHijos;
  }

}
