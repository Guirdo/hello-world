
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boton extends JButton{
   
    //Atributos
    private String rutaCara;
    //TODO linea de codigo que devuelva la ruta relativa en el proyecto
    private final String ESPALDA = "src\\imagenes\\nintendo.jpg";
    private boolean volteado; //false este de espalda, true este de cara
    
    public Boton(String cara){
        this.rutaCara=cara;
        this.volteado=false;
        
        setVolteado(volteado);
    }
    
    public void setVolteado(boolean voltear){
        if(voltear){
            volteado=true;
            this.setIcon(new ImageIcon(rutaCara));
        }else{
            volteado=false;
            this.setIcon(new ImageIcon(ESPALDA));
        }  
    }
    
    public boolean getEstado(){
        return volteado;
    }
    
    public String getCara(){
        return rutaCara;
    }
    
}
