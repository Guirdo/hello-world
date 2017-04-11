package demobasedatos;

/**
 * ¡Saludos, mortal! Espero te sirva copiar este programa.
 * Así que, espero que lo aproveches.
 * @author Sebastián Méndez <ITCH>
 */
public class DemoBaseDatos {

    public static void main(String[] args) {
       BaseDatos bd = new BaseDatos();
       Elemento elem;
       
       elem = new CD("Pajaros en la Cabeza",14,"Amairani",35);
       bd.addElemento(elem);
       
       elem = new CD("One Chance",10,"Paul Pots",30);
       bd.addElemento(elem);
       
       elem = new DVD("One Chance","Paul Pots",30);
       bd.addElemento(elem);
       elem = new DVD("Second Chance","Paul Pots",30);
       bd.addElemento(elem);
       
       elem = new Libro("El señor de los anillos",5000);
       bd.addElemento(elem);
       elem = new Libro("El retrato de Dorian Gray",5000);
       bd.addElemento(elem);
       
       System.out.println(bd.toString());
    }

}
