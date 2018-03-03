package ventanas;

public class Saludo {
    
    static String saludo;
    
    public Saludo(){
        
        this.saludo = "No hay ningun saludo";
        
    }
    
    public Saludo(String saludo){
        this.saludo = saludo;
    }

    @Override
    public String toString() {
        return this.saludo;
    }
    
    

}
