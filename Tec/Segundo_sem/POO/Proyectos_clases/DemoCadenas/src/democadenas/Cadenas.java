package democadenas;

public class Cadenas {

    String cad1, cad2;

    public void asginaValor(String cad1, String cad2) {
        this.cad1 = cad1;
        this.cad2 = cad2;
    }

    public boolean comparaCad(String cad1, String cad2) {
        return cad1.equals(cad2);
    }

    public void imprimeCad() {
        System.out.println("El valor del primer atributo es: " + cad1);
        System.out.println("El valor del segundo atributo es: " + cad2);
    }
}
