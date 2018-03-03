
package appagenda;

public class Telefono {
    //Atributos
    private final String numTel,tipoTel;
    
    //Metodos constructores
    public Telefono(String numTel, String tipoTel) {
        this.numTel = numTel;
        this.tipoTel = tipoTel;
    }
    
    public Telefono(Telefono telefono){
        numTel=telefono.getNumTel();
        tipoTel=telefono.getTipoTel();
    }

    public String getNumTel() {
        return numTel;
    }

    public String getTipoTel() {
        return tipoTel;
    }

    @Override
    public String toString() {
        return "\n" + "Numero=" + getNumTel() + "\t Tipo= " + getTipoTel();
    }
}
