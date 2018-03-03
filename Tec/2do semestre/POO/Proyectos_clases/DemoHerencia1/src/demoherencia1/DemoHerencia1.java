/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoherencia1;

/**
 *
 * @author guirdo
 */
public class DemoHerencia1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado emp1 = new Empleado("Dario Madrazo Pintado","Soltero",12345,21,20000.00);
        Programador pro1 = new Programador (123,"JavaScript","Torcuato Código Fácil","Casado",34567,28,30767.88);
        
        System.out.println(emp1.toString());
        System.out.println("\tTipo de empleado: "+emp1.clasificacion());
        System.out.println(pro1.toString());
        System.out.println("\tTipo de empleado: "+pro1.clasificacion());
        
        System.out.println("\tAumento del salario de un 13%...");
        pro1.aumentarSalario(13);
        System.out.println("\tNuevo salario: "+pro1.salario);
    }
    
}
