public class Libro{

  private String titulo;
  private int ejemplares;
  private String autor;
  private String edicion;


  public Libro(){
  }

  public Libro(String titulo,int ejemplares,String autor,String edicion){

    this.titulo = titulo;
    this.ejemplares = ejemplares;
    this.autor = autor;
    this.edicion = edicion;

  }

  //get's para devolver los valores asignados en las variables
  public String getTitulo(){
    return titulo;
  }

  public int getEjemplares(){
    return ejemplares;
  }

  public String getAutor(){
    return autor;
  }

  public String getEdicion(){
    return edicion;
  }

  //Para poner valores a las variables correspondientes
  public void setTitulo(String titulo){
    this.titulo = titulo;
  }

  public void setEjemplares(int ejemplares){
    this.ejemplares = ejemplares;
  }

  public void setAutor(String autor){
    this.autor = autor;
  }

  public void setEdicion(String edicion){
    this.edicion = edicion;
  }

  @Override
  public String toString(){
    return "titulo: " + titulo + "\nautor: " + autor +
            "\nejemplares: " + ejemplares;
  }

}
