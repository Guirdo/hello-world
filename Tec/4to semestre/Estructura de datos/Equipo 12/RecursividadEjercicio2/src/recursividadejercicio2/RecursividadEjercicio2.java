package recursividadejercicio2;
import javax.swing.JOptionPane;

public class RecursividadEjercicio2 {
    public static int suma(int i){
        if(i == 1)
            return 1;
        else
            return i + suma(i-1);
    }
    public static void main(String[] args) {
        int n=20;
        JOptionPane.showMessageDialog(null, "La suma de los primeros 20 números enteros es: "  + suma(n), "Resultado.", JOptionPane.INFORMATION_MESSAGE );
    }
}

