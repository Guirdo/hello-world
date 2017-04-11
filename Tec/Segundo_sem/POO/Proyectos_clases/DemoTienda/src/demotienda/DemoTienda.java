
package demotienda;

public class DemoTienda {

    public static void main(String[] args) {
        Articulo art = new Articulo();
        art.setPrecio();
        art.setPrecio(23.5);
        System.out.println("El nuevo precio del artículo es: $"+art.getPrecio());
        art.setPrecio(23.5, 15);
        System.out.println("El nuevo precio, con un incremento del 15%, del artículo es: $"+art.getPrecio());
    }
    
}
