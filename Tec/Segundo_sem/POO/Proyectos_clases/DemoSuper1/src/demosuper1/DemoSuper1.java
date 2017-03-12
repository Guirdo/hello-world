/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosuper1;

/**
 *
 * @author guirdo
 */
public class DemoSuper1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Profesor pro1,pro2;
        pro1 = new Profesor("Maria Melo Sala","Femenino",24,"Prof 12-12-1584");
        System.out.println(pro1.toString());
        pro2 = new Profesor ("Zolia Flor Lopez","Femenino",24);
        System.out.println(pro2.toString());
    }
    
}
