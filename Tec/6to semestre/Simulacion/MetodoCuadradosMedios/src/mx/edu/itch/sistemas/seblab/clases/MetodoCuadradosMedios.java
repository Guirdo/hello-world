package mx.edu.itch.sistemas.seblab.clases;

/**
 * En este metodo cada numero sucesivo se genera tomando los n
*/

public class MetodoCuadradosMedios{
    private String semilla;
    private int tam1;
    private long numero;
    private double numeroAleatorio;
    private String numAleatorioPrevio;

    public MetodoCuadradosMedios(String semilla){
        this.semilla = semilla;
        this.tam1=semilla.length();
        this.numero=Integer.parseInt(semilla);
        this.numAleatorioPrevio="";
    }

    public boolean findRandomNumber() {
        Long numero2 = (long) Math.pow(numero,2);
        if(numero2>1 && numero!=numero2){
            String semilla2= Long.toString(numero2);

            while(semilla2.length()<(2*tam1)){
                semilla2="0"+semilla2;
            }

            int tam2 = semilla2.length();
            int primerCaracter = (tam2-tam1)/2;
            String numAleatorio = semilla2.substring(primerCaracter,primerCaracter+tam1);

            if(numAleatorio.equals(this.numAleatorioPrevio)){
                return false;
            }

            this.numero= Long.parseLong(numAleatorio);
            this.numeroAleatorio= Double.parseDouble("."+numAleatorio);
            this.numAleatorioPrevio=numAleatorio;

            return true;
        }else{
            return false;
        }
    }

    public double getNumeroAleatorio() {
        return this.numeroAleatorio;
    }
}
