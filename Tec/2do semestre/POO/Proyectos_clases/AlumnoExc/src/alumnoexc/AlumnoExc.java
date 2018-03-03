/*
 * Hola, mortal. Saludos desde el más paca, o sease, desde el pasado.
 * Sabes, me canse escribriendo (la verdad no, pero me gusta el drama),
 * asi que usalo bien, ponte a estudiar cabron/a.
 */
package alumnoexc;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class AlumnoExc {

    public static void main(String[] args) {
        String nombre,apellido;
        
        try{
            AlumnoExce alum = new AlumnoExce("Juan Pablo","");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
