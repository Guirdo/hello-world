package caja;

public class CuentaHabiente {

    private final String nombre, calle, colonia, ciudad;
    private final int edad;

    public CuentaHabiente(String nombre, String calle, String colonia, String ciudad, int edad) {
        this.nombre = nombre;
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.edad = edad;
    }

    public CuentaHabiente(CuentaHabiente cuenHa) {
        /*nombre=cuenHa.getNombre();
        calle=cuenHa.getCalle();
        colonia=cuenHa.getColonia();
        ciudad=cuenHa.getCiudad();
        edad=cuenHa.getEdad();*/

        this(cuenHa.getNombre(), cuenHa.getCalle(), cuenHa.getColonia(), cuenHa.getCiudad(), cuenHa.getEdad());
    }

    public String getNombre() {
        return nombre;
    }

    public String getCalle() {
        return calle;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre + "\tEdad: " + edad
                + "\nDomicilio: " + calle + ", Col. " + colonia + ", " + ciudad;
    }

}
