package principal;

class Respuesta {
    private String texto;
    private boolean correcta;

    public Respuesta(String texto, boolean correcta) {
        this.texto = texto;
        this.correcta = correcta;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public String getTexto() {
        return texto;
    }
    
    
    
}
