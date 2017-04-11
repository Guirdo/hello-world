
package appuniversitaria;

public class Alumno extends Persona implements Docente {
    private String grupo;
    private Turno turno;

    public Alumno(String grupo, Turno turno, String nombre, int edad) {
        super(nombre, edad);
        this.grupo = grupo;
        this.turno = turno;
    }

    @Override
    public String getGrupo() {
        return grupo;
    }

    @Override
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nGrupo=" + grupo + "\nTurno=" + turno + "\n";
    }
    
    
}
