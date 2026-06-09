package com.sabrimassola.mediturn.model;


public class Especialidad {
    private int id;
    private String nombre;
    private String descripcion;
    private int duracionMinutos;

    private static int contadorId;

    public Especialidad(String nombre, String descripcion, int duracionMinutos) {
        this.id = ++contadorId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMinutos = duracionMinutos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
