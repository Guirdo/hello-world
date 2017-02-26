package democliente;

public class Cliente {
    String nombre, nomEmp;
    int edad;
    
    Cliente(){
        nombre = nomEmp = null;
        edad = 0;
    }
    
    Cliente (String nombre, String nomEmp, int edad){
        this.nombre=nombre;
        this.nomEmp=nomEmp;
        this.edad=edad;
    }
    
    Cliente(String nombre, String nomEmp){
        this.nombre=nombre;
        this.nomEmp=nomEmp;
    }
}
