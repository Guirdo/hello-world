package alumnoexc;

public class AlumnoExce {
    String nombre,apellido;

    public AlumnoExce(String nombre, String apellido) throws Exception {
        if(nombre.isEmpty() && apellido.isEmpty()){
            throw new Exception("Error, los argumentos no son validos, ya que estos estan vacios...");
        }if(nombre.isEmpty()){
            throw new Exception("Error, el nombre esta vacio...");
        }if(apellido.isEmpty()){
            throw new Exception("Error, el apellido esta vacio...");
        }
        this.nombre = nombre;
        this.apellido=apellido;
        System.out.println("El objeto se ha creado con exito");
        System.out.println("Nombre: "+nombre+"\nApellido: "+apellido);
    }
    
    
}
