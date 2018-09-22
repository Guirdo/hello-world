public class Escuela {

    private String clave;
    private String nombre;
    private Director dic;

    public Escuela(String clave,String nombre, Director dic){
        this.clave=clave;
        this.nombre=nombre;
        this.dic=dic;
    }

    public String getNombre() {
        return nombre;
    }

    public Director getDic() {
        return dic;
    }

    public String getClave() {
        return clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setDic(Director dic) {
        this.dic = dic;
    }

    public String imprimir(){
        return "Escuela "+nombre+" \n"+
                "Clave: "+clave+"\n"+
                "-----------\n"+
                "Director: "+dic.getNombre()+"\n"+
                "Edad: "+dic.getEdad();
    }
}
