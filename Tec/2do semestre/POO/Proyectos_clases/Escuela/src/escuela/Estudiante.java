
package escuela;

public class Estudiante {
    String nombre,domi,numTel,numControl,carrera,fecNaci;
    
    Estudiante(){
        nombre = domi=numTel=numControl  = null;
    }
    
    Estudiante(String numCotrol){
        nombre="Aldo";
        domi="Calle 13, Col. PRD, Chilpancingo de los Bravo";
        fecNaci="03/02/98";
        numTel="7471429845";
        carrera="Ingenieria en Sistemas Computacionales";
    }
    
    Estudiante(String nombre, int edad,String numControl,String fecNaci){
        this.nombre=nombre;
        this.fecNaci=fecNaci;
        this.numControl=numControl;
    }
    
    Estudiante(String nombre,int edad, String domi,String numControl,String numTel, String fecNaci){
        this.nombre=nombre;
        this.domi=domi;
        this.fecNaci=fecNaci;
        this.numControl=numControl;
        this.numTel=numTel;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomi() {
        return domi;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getNumControl() {
        return numControl;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getFecNaci() {
        return fecNaci;
    }
    
    
}
