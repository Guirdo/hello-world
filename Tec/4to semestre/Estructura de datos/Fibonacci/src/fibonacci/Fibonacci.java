/*
 * Hola!
 */
package fibonacci;
import javax.swing.JOptionPane;

public class Fibonacci {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero","Entrada de datos",JOptionPane.QUESTION_MESSAGE));
        int numRes = fibonacci(n);
        JOptionPane.showMessageDialog(null,"El resultado es: "+numRes,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int fibonacci(int n){
        if(n> 1){
            System.out.println(n);
            return fibonacci(n-1)+fibonacci(n-2);
        }else if(n==0){
                return 0;
        }else if(n==1){
            return 1;
        }else{
            System.out.println("Ingresa un valor mayor o igual a 1");
            return -1;
        }
    }   
}
