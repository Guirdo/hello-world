package empresaagroali;

import java.io.Serializable;

public class Refrigerado extends Producto implements Serializable{
    private String codigoOrganismoSupervision,fechaEnvasado,paisOrigen;
    private double temperatura;

    public Refrigerado(String codigoOrganismoSupervision, String fechaEnvasado, String paisOrigen, double temperatura, String fechaCaducidad, String numeroLote, String nombre) {
        super(fechaCaducidad, numeroLote, nombre);
        this.codigoOrganismoSupervision = codigoOrganismoSupervision;
        this.fechaEnvasado = fechaEnvasado;
        this.paisOrigen = paisOrigen;
        this.temperatura = temperatura;
    }

    

    public String getCodigoOrganismoSupervision() {
        return codigoOrganismoSupervision;
    }

    public void setCodigoOrganismoSupervision(String codigoOrganismoSupervision) {
        this.codigoOrganismoSupervision = codigoOrganismoSupervision;
    }

    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(String fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return super.toString()+"\nFecha de envasado: "+fechaEnvasado+"\nCodigo del organismo de supervision alimentaria: "+codigoOrganismoSupervision+"\nPais de origen: "+paisOrigen
                +"\nTemperatura recomendada: "+temperatura+"\n";
    }
    
    
}
