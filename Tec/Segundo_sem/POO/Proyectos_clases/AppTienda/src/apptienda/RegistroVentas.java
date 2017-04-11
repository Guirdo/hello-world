package apptienda;

import java.util.ArrayList;

public class RegistroVentas {

    ArrayList<Venta> ventas;
    private static double totalVentas =0.0; 

    public RegistroVentas() {
        ventas = new ArrayList<>();
    }

    public void agregaVenta(Venta ven) {
        ventas.add(ven);
    }
    
    private void sumarVenta(Venta ven){
        totalVentas+=ven.getTotalVenta();
    }

    @Override
    public String toString() {
        String sal = "";

        for (int i = 0; i < ventas.size(); i++) {
            sal += ventas.get(i).toString();
        }
        
        sal+="\n-Total de ventas del día: $"+totalVentas;

        return sal;
    }

}
