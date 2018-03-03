
package appbiblioteca;

public class Publicacion {
    private String titulo,codigo;
    private int año;

    public Publicacion(String titulo, String codigo, int año) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.año = año;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return "\nTitulo: " + titulo + "\nCodigo: " + codigo + "\nAño: " + año;
    }
    
}
