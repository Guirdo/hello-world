public class DemoRegistro1{
  public static void main(String[] args) {
    Empleado emple = new Empleado();

    emple.nombre="Juan";
    emple.edad=34;
    emple.salario=3456.78;

    //Salida de datos
    System.out.println("Emplaado "+emple.nombre);
    System.out.println("Edad "+emple.edad);
    System.out.println("Salario "+emple.salario);

    Empleado emple1=new Empleado();
    emple1.nombre="Aldo";
    emple1.edad=18;
    emple1.salario=100;

    //Salida de datos
    System.out.println("Emplaado "+emple1.nombre);
    System.out.println("Edad "+emple1.edad);
    System.out.println("Salario "+emple1.salario);
  }
}

class Empleado{
  public String nombre;
  public int edad;
  public double salario;
}
