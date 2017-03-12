package demosuper1;

public class Profesor extends Persona {

    private String idProfe;

    public Profesor(String nombre, String sexo, int edad) {
        super(nombre, sexo, edad);
        this.idProfe = "";
    }

    public Profesor(String nombre, String sexo, int edad, String idProfe) {
        super(nombre, sexo, edad);
        this.idProfe = idProfe;
    }

    public String getIdProfe() {
        return idProfe;
    }

    public void setIdProfe(String idProfe) {
        this.idProfe = idProfe;
    }

    @Override
    public String toString() {
        return "\nDatos del profesor(a): " + super.toString() + "\n\tID del Profesor: " + idProfe + "\n";
    }

}
