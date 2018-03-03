
package apptienda;

public class Venta {
    java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    
    private String fechaCom,proCom;
    private int cantiCom;
    private double totalVenta;

    public Venta(String proCom, int cantiCom,double totalVenta) {
        this.proCom = proCom;
        this.cantiCom = cantiCom;
        this.fechaCom=sqlDate.toString();
        this.totalVenta=totalVenta;
    }

    public String getFechaCom() {
        return fechaCom;
    }

    public String getProCom() {
        return proCom;
    }

    public void setProCom(String proCom) {
        this.proCom = proCom;
    }

    public int getCantiCom() {
        return cantiCom;
    }

    public void setCantiCom(int cantiCom) {
        this.cantiCom = cantiCom;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    @Override
    public String toString() {
        return "Fecha de compra: " + fechaCom + "\nProducto comprado: " + proCom + "\nCantidad comprada: " + cantiCom + "\n";
    }
    
    
    
}
