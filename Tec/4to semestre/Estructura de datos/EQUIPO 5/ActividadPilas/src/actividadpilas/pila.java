package actividadpilas;

import java.util.Stack;
import javax.swing.JOptionPane;

public class pila {

    Stack pila;
    String nombre, clave;
    double sueldo;
    int tam, cont;

    public pila() {
        this.pila = new Stack();
        this.nombre = "";
        this.clave = "";
        this.sueldo = 0;
        this.tam = 0;
        this.cont = 0;

    }
    public void Alta_Elem() {
        if (cont < tam) {
            nombre = JOptionPane.showInputDialog(null, "Capturar nombre del empleado: ");
            clave = JOptionPane.showInputDialog(null, "Capturar clave del empleado: ");
            sueldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Capturar sueldo del empleado: "));
            pila.push("\n" + (cont + 1) + "\nNombre del empleado: " + nombre + "\nClave del empleado: " + clave + "\nSueldo: " + sueldo + "\n");
            cont++;
        } else {
            JOptionPane.showMessageDialog(null, "ERROR PILA LLENA");
        }
    }
    public void Baja_Elem() {
        pila.pop();
        cont--;

    }
    public void Contenido() {
        JOptionPane.showMessageDialog(null, pila, "Contenido de la pila:", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
    
    public int getTam(){
        return tam;
    }

}
