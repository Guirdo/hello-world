import javax.swing.*;

public class Hola {

    public static void main(String [] args){
        String mensaje ="Hola mundo";
        int numero= 19;
        double num = 29.9;
        boolean estado = false;
        Object nombre;

        nombre = JOptionPane.showInputDialog(null,"Mete tu nombre: ");

        JOptionPane.showMessageDialog(null,"Este es el nombre "+nombre.toString());
    }

}
