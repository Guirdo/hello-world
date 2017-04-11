
package apptienda;

import java.util.ArrayList;

public class Venta {
    java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    
    private String listaCompras;
    private String fechaCom,empleado;
    private double totalVenta;

    public Venta(String lista,String numEmpl,double totalVenta) {
        this.listaCompras=lista;
        this.empleado=numEmpl;
        this.fechaCom=sqlDate.toString();
        this.totalVenta=totalVenta;
    }

    public String getFechaCom() {
        return fechaCom;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    @Override
    public String toString() {
        return "Fecha de compra: " + fechaCom + "\nLista de ventas \n"+listaCompras+"\nNumero de empleado: "+empleado+"\n\n";
    }
    
    
    
}
