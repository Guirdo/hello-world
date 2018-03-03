package objetos;

import java.util.ArrayList;

public class Persona {
    String nombres,apellidos,sexo,numTel;

    public Persona(String nombres, String apellidos, String sexo, String numTel) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.numTel = numTel;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", sexo=" + sexo + ", numTel=" + numTel + '}';
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
    
    
    
}
