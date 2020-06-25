package dam.practica6;

/**
 * Created by Santiago Avilez Jiménez on junio,2020
 */
class Item {
    String titulo;
    String descripion;
    String imagen;
    public Item(String titulo, String descripion, String imagen) {
        this.titulo = titulo;
        this.descripion = descripion;
        this.imagen = imagen;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripion() {
        return descripion;
    }
    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
