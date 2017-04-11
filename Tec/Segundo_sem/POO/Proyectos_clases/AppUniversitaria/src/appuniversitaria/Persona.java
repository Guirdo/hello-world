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
public class Persona {
    private String nombre;
    private int edad;
    
    public Persona(){
        edad = 0;
        nombre = "";
    }
    
    public Persona(String nombre){
        edad = 0;
        this.nombre = nombre;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEdad=" + edad;
    }
    
    
}
