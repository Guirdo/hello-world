package demobasedatos;

public class DVD extends Elemento{
    private String director;

    public DVD(String director, String titulo, int duración) {
        super(titulo, duración);
        this.director = director;
    }
    
    @Override
    public String toString(){
        return super.toString()+"Director (DVD): "+director+"\n"/*super.getClass().getSimpleName()+"\n"*/;
    }
}