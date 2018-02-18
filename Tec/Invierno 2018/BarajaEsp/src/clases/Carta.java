package clases;

public class Carta {

    int numero;
    String palo;

    public Carta(int num, int index) {
        this.numero = num;
        switch (index) {
            case 0:
                palo = "E";
                break;
            case 1:
                palo = "O";
                break;
            case 2:
                palo = "C";
                break;
            case 3:
                palo = "B";
                break;
        }
    }
    
    public String toString(){
        String valor = numero+""+palo;
        return valor;
    }
}
