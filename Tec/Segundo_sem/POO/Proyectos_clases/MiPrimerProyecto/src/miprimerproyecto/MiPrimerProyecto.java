package miprimerproyecto;

public class MiPrimerProyecto {

    public static void main(String[] args) {
        Caja cajita = new Caja();
        Caja refCajita = cajita; //Declaracion de la referencia
        //Asignacion de valores a las variables de instacncia por medio de la referencia refCajita
        refCajita.alto = 10;
        refCajita.ancho = 20;
        refCajita.largo = 15;
        //Vizualizacion
        System.out.println("El valor del atributo alto es: "+refCajita.alto);
        System.out.println("El valor del atributo ancho es: "+refCajita.ancho);
        System.out.println("El valor del atributo largo es: "+refCajita.largo);
        
        //Modificacion de una variable por la referencia
        refCajita.largo+=60;
        System.out.println("\nEl nuevo valor del atributo largo es: "+refCajita.largo);
        
        //Caja cajita1 = new Caja();
        //double vol;
        //Asignacion de valores a las variables de instancia
        /*
        cajita.alto = 10;
        cajita.ancho = 20;
        cajita.largo = 15;
        
        cajita1.alto = 3;
        cajita1.ancho = 6;
        cajita1.largo = 9;*/
        //Calculo del volmen de lacaja
        //vol = cajita.alto * cajita.ancho + cajita.largo;
        //System.out.println("El volumen de la primera caja es: " + vol);

        //vol = cajita1.alto * cajita1.ancho + cajita1.largo;
        //System.out.println("El volumen de la segunda caja es: " + vol);
    }

}
