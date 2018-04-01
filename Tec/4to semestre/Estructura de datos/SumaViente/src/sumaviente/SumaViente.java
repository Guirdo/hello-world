/*
 * Hola!
 */
package sumaviente;

import javax.swing.JOptionPane;
public class SumaViente {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"¡Comencemos!");
        JOptionPane.showMessageDialog(null,"El resultado: "+suma(20));
    }
    
    public static int suma(int n){
        System.out.println(n);
        if(n>0){
            return n+suma(n-1);
        }else{
            return 0;
        }
    }
    
}
