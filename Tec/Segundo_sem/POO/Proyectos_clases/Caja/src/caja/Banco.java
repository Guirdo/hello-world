package caja;

public class Banco {
    private final String nombre;
    private ListaCuentaHabientes lista;
    
    public Banco(){
        nombre="Santander";
        lista = new ListaCuentaHabientes();
    }
    
    public void agreCuenHa(CuentaHabiente cuanHa){
        lista.agreCuenHa(cuanHa);
    }
    
    @Override
    public String toString(){
        return "Banco "+nombre+"\n\n"+lista.toString();
    }
}
