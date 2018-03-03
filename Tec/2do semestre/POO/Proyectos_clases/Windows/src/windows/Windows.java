package windows;

public class Windows {

    public static void main(String[] args) {
        VentanaTitulo venT = new VentanaTitulo("Principal", 0, 0, 20, 30);
        venT.mostrar();
        venT.cambiarDimensiones(10, 15);
        venT.desplazar(4, 3);
        venT.mostrar();
    }

}
