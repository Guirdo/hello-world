package demoserializable;

import java.io.Serializable;

public class Persona implements Serializable {
    String nombre, sexo;
    int edad;
    double peso, estatura;

    Persona() {
    }

    public Persona(String nombre, String sexo, int edad, double peso, double estatura) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nSexo: " + sexo + "\nEdad: " + edad + "\nPeso: " + peso + "\nEstatura: " + estatura + "\n";
    }
}
