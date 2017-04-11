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
public class Profesor extends Empleado implements Docente {
    private String grupo;

    public Profesor(String grupo, int numEmp, double sueldo, Turno turno, String nombre, int edad) {
        super(numEmp, sueldo, turno, nombre, edad);
        this.grupo = grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return super.toString() + "\nGrupo=" + grupo + "\n";
    }
    
    
}
