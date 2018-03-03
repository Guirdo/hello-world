package demobasedatos;

public class CD extends Elemento{
    private String interprete;
    private int numTemas;

    public CD(String interprete, int numTemas, String titulo, int duración) {
        super(titulo, duración);
        this.interprete = interprete;
        this.numTemas = numTemas;
    }
    
    @Override
    public String toString(){
        String aux = super.toString();
        aux += "Interprete (CD): "+interprete+"\n";
        aux+= "Numero de temas: "+numTemas+"\n";
        //aux+=super.getClass().getSimpleName()+"\n";
        return aux;
    }
}