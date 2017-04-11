/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appuniversitaria;

/**
 *
 * @author aldom
 */
public class Administrativo extends Empleado {
    private String funcion,departamento;

    public Administrativo(String funcion, String departamento, int numEmp, double sueldo, Turno turno, String nombre, int edad) {
        super(numEmp, sueldo, turno, nombre, edad);
        this.funcion = funcion;
        this.departamento = departamento;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFuncion: " + funcion + "\nDepartamento: " + departamento + "\n";
    }
    
    
}
