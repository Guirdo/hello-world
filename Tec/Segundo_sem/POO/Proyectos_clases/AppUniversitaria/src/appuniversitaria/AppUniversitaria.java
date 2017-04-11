
package appuniversitaria;

public class AppUniversitaria {

    public static void main(String[] args) {
        Alumno alu = new Alumno("D-1",Turno.MATUTINO,"Carlos Alberto",19);
        System.out.println("Alumno: ");
        System.out.println(alu.toString());
        
        Profesor pro = new Profesor("D-2",125,8745.43,Turno.MATUTINO,"José Alberto",45);
        System.out.println("Profesor: ");
        System.out.println(pro.toString());
        
        System.out.println("Profesor modificado del grupo");
        pro.setGrupo("F-5");
        System.out.println(pro.toString());
        
        Administrativo admin = new Administrativo ("Jefe de departamento","Recursos humanos",120,6578.67,Turno.MATUTINO,"María",32);
        System.out.println("Administrativo: ");
        System.out.println(admin.toString());
    }
    
}
