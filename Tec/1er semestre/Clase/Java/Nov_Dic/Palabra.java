import javax.swing.*;

public class Palabra{

  public static boolean esPalindromo(String cadena){
    boolean regreso;
    String cat1="",cat2="";
    cat1=cadena.toLowerCase();
    cat1=cat1.replace(" ","");

    for (int i=cat1.length()-1;i>=0 ;i-- ) {
      cat2+=cat1.charAt(i);
    }

    if (cat1.equals(cat2))
      regreso=true;
    else
      regreso=false;

    return regreso;
  }

  public static void main(String[] args) {
    String palabra;

    do {
      palabra=JOptionPane.showInputDialog(null,"Ingrese una palabra","Entrada de datos",JOptionPane.INFORMATION_MESSAGE);
    } while (palabra.isEmpty());

    if (esPalindromo(palabra)) {
      JOptionPane.showMessageDialog(null,"Es palindromo","Resultado",JOptionPane.INFORMATION_MESSAGE);
    }else {
      JOptionPane.showMessageDialog(null,"No es palindromo","Resultado",JOptionPane.INFORMATION_MESSAGE);
    }
    System.exit(0);
  }
}
