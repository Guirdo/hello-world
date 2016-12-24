/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

/**
 *
 * @author guirdo
 */
public class NIF {
    int dni;
    char letra;

  public NIF(){}

  public void setDNI(int dni){
    this.dni = dni;
    this.letra = obtenerNIF();
  }

  public int getDNI(){
    return dni;
  }

  private char obtenerNIF(){
      char [] letras = {'T','R','W','A','G','M',
                        'Y','F','P','D','X','B',
                        'N','J','Z','S','Q','V',
                        'H','L','C','K','E'};
      int num;
      char letra;

      letra = letras[dni % 23];

      return letra;
  }

  public String toString(){
    return "El DNI es: "+dni+" - "+letra+"";
  }
}
