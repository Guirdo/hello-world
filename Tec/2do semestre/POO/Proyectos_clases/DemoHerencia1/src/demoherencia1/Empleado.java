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
public class Empleado {
    String nombre,edoCivil;
    int numEmp,edad;
    double salario;

    public Empleado() {
    }

    public Empleado(String nombre, String edoCivil, int numEmp, int edad, double salario) {
        this.nombre = nombre;
        this.edoCivil = edoCivil;
        this.numEmp = numEmp;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdoCivil() {
        return edoCivil;
    }

    public void setEdoCivil(String edoCivil) {
        this.edoCivil = edoCivil;
    }

    public int getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(int numEmp) {
        this.numEmp = numEmp;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public String clasificacion(){
        String tipoEmp="";
        if(edad <=21)
            tipoEmp="Principiante";
        else{
            if(edad >=22 && edad <=35)
                tipoEmp="Intermedio";
            else
                tipoEmp="Senior";
        }
        return tipoEmp;
    }
    
    public void aumentarSalario(double incremento){
        salario=salario*(1+(incremento/100));
    }
    
    /*@Override
    public String toString(){
        return "Empleado:"+"\n\t-Nombre: "+nombre+"\n\t-NumEmpleado: "+numEmp+"\n\t-Edad: "+edad+"\n\ŧEdoCivil"+edoCivil+"\n\tSalario: "+salario;
    }*/

    @Override
    public String toString() {
        return "Empleado: " + "\n\tNombre=" + nombre + "\nEdoCivil: " + edoCivil + "\n\tNumEmp: " + numEmp + ", edad=" + edad + ", salario=" + salario + '}';
    }
    
    
    
    
}
