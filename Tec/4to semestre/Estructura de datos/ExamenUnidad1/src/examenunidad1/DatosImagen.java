package examenunidad1;

public class DatosImagen {
    String tituloImagen;
    int ancho;
    int alto;
    int tamKb;

    public DatosImagen(String tituloImagen, int ancho, int alto, int tamKb) {
        this.tituloImagen = tituloImagen;
        this.ancho = ancho;
        this.alto = alto;
        this.tamKb = tamKb;
    }
    
    @Override
    public String toString(){
        return "Título: "+tituloImagen+"\n"+
                "Ancho: "+ancho+"\n"+
                "Alto: "+alto+"\n"+
                "Tamaño(Kb): "+tamKb+"\n\n";
    }
    
    public String getTitutloImagen(){
        return tituloImagen;
    }
    
    public int getTamKb(){
        return tamKb;
    }
}
