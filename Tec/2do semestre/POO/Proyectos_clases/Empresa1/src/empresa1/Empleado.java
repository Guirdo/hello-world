package empresa1;

import java.util.*;

public class Empleado {

    private String nombre;
    private String sexo;
    private String departamento;
    private int edad;
    private int tiemTraba;

    public Empleado() {
    }

    public Empleado(String nombre, String sexo, String departamento, int edad, int tiemTraba) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.departamento = departamento;
        this.edad = edad;
        this.tiemTraba = tiemTraba;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getEdad() {
        return edad;
    }

    public int getTiemTraba() {
        return tiemTraba;
    }

    @Override
    public String toString() {
        return "Empleado" + "nombre: " + nombre + ", sexo: " + sexo + ", departamento=" + departamento + ", edad=" + edad + ", tiemTraba=" + tiemTraba + "\n\n";
    }

}
