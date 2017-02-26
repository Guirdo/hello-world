package depsocial;

public class Empleado {

    String nombre;
    int edad;
    double salario;

    public void asignarDatos(String nombre, int edad, double salario) {
        this.edad = edad;
        this.nombre = nombre;
        this.salario = salario;
    }

    public String vizualizarDatos() {
        String salida = "";

        salida += "Nombre: " + nombre + "\nEdad: " + edad + "\nSalario: " + salario;
        
        return salida;
    }
    
    public boolean incrementarDatos(){
       boolean aumento=false;
       //Incrementa el salario del empleado en un 20% , si este tiene más de 40 años
       if(edad>40){
           salario +=salario*0.2;
           aumento=true;
       }
       return aumento;
    }
}
