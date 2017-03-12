package appagenda;

public class Persona {

    private String nombre, fecNa;
    private ListaTelefonos arrayLisTel;

    //Metodos constructores
    public Persona(){
        
    }
    public Persona(String nom, String fechNa) {
        nombre = nom;
        fecNa = fechNa;
        arrayLisTel = new ListaTelefonos();
    }

    public Persona(Persona perso) {
        this(perso.getNombre(), perso.getFecNa());
    }

    //Metodos
    public void agreTel(String nom, String tipo) {
        arrayLisTel.agreDaTel(nom, tipo);
    }

    public void agreTel(Telefono tel) {
        arrayLisTel.agreDaTel(tel);
    }

    public ListaTelefonos getArrayLisTel() {
        return arrayLisTel;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getFecNa() {
        return fecNa;
    }

    @Override
    public String toString() {
        return "Datos personales:\n" + "\t-Nombre: " + nombre + "\n\t-Fecha Nac: " + fecNa + "\nLista de telefonos: " + arrayLisTel.toString();
    }

}
