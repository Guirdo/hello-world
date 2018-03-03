package miscelanea1;


public class Persona {
    private String nombre,sexo,fechaNacimiento,domicilio,numeroTelefonico;

    public Persona(String nombre, String sexo, String fechaNacimiento, String domicilio, String numeroTelefonico) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+"\nSexo: "+sexo+"\nFecha de nacimiento: "+fechaNacimiento+"\nDomicilio: "+domicilio+"\nNumero telefonico: "+numeroTelefonico+"\n";
    }
    
    
}
