package mx.edu.itch.seblab.clases;

public class Negocio {

    private int[] numeroVentasRealesDiarias;

    private String producto;
    private double renta;
    private double servicios;
    private double salarioAdministrativos;
    private double salarioVentas;
    private double costoProduccionUnidad;
    private double precioVentaUnidad;

    private double gastoProPeriodo,gastoProDiario;
    private int periodo;
    private double[][] limites;
    private double totalVentaPeriodo;

    public Negocio(String producto,int[] datosHistoricos, double renta, double servicios, double salarioAdministrativos,
                   double salarioVentas, double costoProduccionUnidad, double precioVentaUnidad) {
        this.numeroVentasRealesDiarias = datosHistoricos;
        this.producto = producto;
        this.renta = renta;
        this.servicios = servicios;
        this.salarioAdministrativos = salarioAdministrativos;
        this.salarioVentas = salarioVentas;
        this.costoProduccionUnidad = costoProduccionUnidad;
        this.precioVentaUnidad = precioVentaUnidad;

        this.periodo=numeroVentasRealesDiarias.length;
        this.gastoProPeriodo = renta+servicios+salarioAdministrativos+salarioVentas;
        this.gastoProDiario = this.gastoProPeriodo/numeroVentasRealesDiarias.length;
    }

    public double[][] calcularProbabilides() {
        int filas =this.periodo;
        int columnas = 6;
        double[][] probabilidades = new double[filas][columnas];

        this.limites = new double[filas][3];

        totalVentaPeriodo = 0;
        double probabilidadAnterior=0;

        for (double numVentasDia : numeroVentasRealesDiarias) totalVentaPeriodo+=numVentasDia;

        for(int i=0;i<filas;i++){
            double numVentaDia = (double) numeroVentasRealesDiarias[i];

            //Dia
            probabilidades[i][0] = i+1;
            //Numero de ventas reales al dia
            probabilidades[i][1] = numVentaDia;
            //Probabilidad
            probabilidades[i][2] = numVentaDia / totalVentaPeriodo;
            //Probabilidad acumulada
            probabilidades[i][3] = numVentaDia*(1/totalVentaPeriodo)+probabilidadAnterior;
            //Limite inferior
            probabilidades[i][4] = probabilidadAnterior;
            //Limite superior
            probabilidades[i][5] = probabilidades[i][3];

            limites[i][0] = probabilidades[i][1];
            limites[i][1] = probabilidades[i][4];
            limites[i][2] = probabilidades[i][5];

            probabilidadAnterior+=probabilidades[i][2];
        }

        return probabilidades;
    }


    public int[] getNumeroVentasRealesDiarias() {
        return numeroVentasRealesDiarias;
    }

    public String getProducto() {
        return producto;
    }

    public double getRenta() {
        return renta;
    }

    public double getServicios() {
        return servicios;
    }

    public double getSalarioAdministrativos() {
        return salarioAdministrativos;
    }

    public double getSalarioVentas() {
        return salarioVentas;
    }

    public double getCostoProduccionUnidad() {
        return costoProduccionUnidad;
    }

    public double getPrecioVentaUnidad() {
        return precioVentaUnidad;
    }

    public int getPeriodo() {
        return periodo;
    }

    public double[][] getLimites() {
        return limites;
    }

    public double getGastoProDiario() {
        return gastoProDiario;
    }

    public double getGastoProPeriodo() {
        return gastoProPeriodo;
    }

    public double getTotalVentaPeriodo() {
        return totalVentaPeriodo;
    }
}
