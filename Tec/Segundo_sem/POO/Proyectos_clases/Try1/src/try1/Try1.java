/*
 * Hola, mortal. Saludos desde el más paca, o sease, desde el pasado.
 * Sabes, me canse escribriendo (la verdad no, pero me gusta el drama),
 * asi que usalo bien, ponte a estudiar cabron/a.
 */
package try1;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Try1 {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int numero;
        String cadena = " 1";
        try {
            //1Exception e = new Exception("Este es mi propio error...");
            //1throw e;
            numero = Integer.parseInt(cadena);
        } catch (NumberFormatException e) {
            //1System.out.println(excepcion.getMessage());
            System.out.println("Error no es un numero, es una cadena de caracteres...");
        }
    }

}
