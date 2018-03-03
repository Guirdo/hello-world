
package appbiblioteca;

public class Revista extends Publicacion {
    private int numTotal;

    public Revista(int numTotal, String titulo, String codigo, int año) {
        super(titulo, codigo, año);
        this.numTotal = numTotal;
    }

    @Override
    public String toString() {
        return super.toString() + "Numero: " + numTotal + "\n";
    }
    
    
}
