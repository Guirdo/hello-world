package ejemplopersona;

public class Persona {

    int edad;
    String nombre;

    public Persona() {
        edad = 17;
        nombre = "Juan López";
    }

    public Persona(String nombre, int edad) {
        this.edad = edad;
        this.nombre = nombre;
    }
    
    public void mostrar(){
        System.out.println("\t-Nombre: "+nombre);
        System.out.println("\t-Edad: "+edad);
    }
}
