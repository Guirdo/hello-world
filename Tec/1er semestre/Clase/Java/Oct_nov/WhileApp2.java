import javax.swing.*;
public class WhileApp2{
  public static void main(String[] args) {
    int co1=0,co2=1,co3=1,co3a=1,co4=1;
    while (co1<=19) {
      System.out.println(co1+"  "+co2+"  "+co3+"  "+co4 );
      //co3a es una variable de apoyo para conservar el valor anterior de la co3 y sacar el nuevo valor de este
      co3a=co3a+co3;
      //Aqui se demuestra que se debia conservar el antiguo valor de co3
		  co3=co2+co3+co4;
      //co2 es igual a ella misma mas 2
		  co2=co2+2;
      //co4 es igual al antiguo valor de co3 (co3a) más la misma actual co3, menos uno, porque al principio
      //se tuvo que inicializar co3a en 1
		  co4=co3a+co3-1;
      //co1 incrementa solo en uno
		  co1++;
    }
  }
}
