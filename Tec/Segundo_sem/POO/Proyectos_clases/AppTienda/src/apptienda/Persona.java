
package apptienda;

public class Persona {
    private String nombre,sexo,fecNac,domicilio;

    public Persona(String nombre, String sexo, String fecNac, String domicilio) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.fecNac = fecNac;
        this.domicilio = domicilio;
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

    public String getFecNac() {
        return fecNac;
    }

    public void setFecNac(String fecNac) {
        this.fecNac = fecNac;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nSexo: " + sexo + "\nFecha de nacimiento: " + fecNac + "\nDomicilio: " + domicilio + "\n";
    }
    
    
}
