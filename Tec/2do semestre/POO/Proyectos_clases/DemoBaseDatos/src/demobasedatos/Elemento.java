package demobasedatos;

public class Elemento{
    private String titulo;
    private int duracion;

    public Elemento(String titulo, int duración) {
        this.titulo = titulo;
        this.duracion = duracion;
    }
    
    @Override
    public String toString(){
        return "Titulo: "+titulo+"\nDuración: "+"("+duracion+"minutos)\n"+"Tipo de objeto:"+super.getClass().getSimpleName()+"\n";
    }
}