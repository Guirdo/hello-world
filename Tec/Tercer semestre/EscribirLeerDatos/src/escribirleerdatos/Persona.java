package escribirleerdatos;

public class Persona {
    String nombre;
    int edad;
    
    public Persona(String nombre,int edad){
        this.edad=edad;
        this.nombre=nombre;
    }
    
    @Override
    public String toString(){
        return "Nombre: "+nombre+"\nEdad: "+edad;
    }

}
