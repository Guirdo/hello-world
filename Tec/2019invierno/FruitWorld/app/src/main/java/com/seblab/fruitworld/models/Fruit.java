package com.seblab.fruitworld.models;

public class Fruit {

    private String nombre;
    private String origen;
    private int icono;

    public Fruit(String nombre, String origen, int icono) {
        this.nombre = nombre;
        this.origen = origen;
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public int getIcono() {
        return icono;
    }
}
