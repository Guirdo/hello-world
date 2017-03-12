/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoherencia1;

/**
 *
 * @author guirdo
 */
public class Programador extends Empleado{
    int lineadCodigoPorHora;
    String lenguajeDominante;

    public Programador() {
    }

    public Programador(int lineadCodigoPorHora, String lenguajeDominante, String nombre, String edoCivil, int numEmp, int edad, double salario) {
        super(nombre, edoCivil, numEmp, edad, salario);
        this.lineadCodigoPorHora = lineadCodigoPorHora;
        this.lenguajeDominante = lenguajeDominante;
    }

    public int getLineadCodigoPorHora() {
        return lineadCodigoPorHora;
    }

    public void setLineadCodigoPorHora(int lineadCodigoPorHora) {
        this.lineadCodigoPorHora = lineadCodigoPorHora;
    }

    public String getLenguajeDominante() {
        return lenguajeDominante;
    }

    public void setLenguajeDominante(String lenguajeDominante) {
        this.lenguajeDominante = lenguajeDominante;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tLineas de Codigo Por Hora: " + lineadCodigoPorHora + "\n\tLenguaje Dominante: " + lenguajeDominante +"\n";
    }

    
    
    
}
