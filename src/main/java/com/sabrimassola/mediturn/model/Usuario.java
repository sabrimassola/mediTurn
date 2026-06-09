package com.sabrimassola.mediturn.model;

import java.util.Objects;

public abstract class Usuario implements Autenticable {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Roles rol;

    private static int contadorId;

    public Usuario() {
        this.id = ++contadorId;
    }

    public Usuario(String nombre, String apellido, String email, String password, Roles rol) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRol() {
        return rol;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean login(String email, String password) {
        return Objects.equals(this.email, email) && Objects.equals(this.password, password);
    }

    @Override
    public void logout() {
        System.out.println("Sesion cerrada");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Usuario)) return false;
        Usuario u = (Usuario) obj;
        return Objects.equals(email, u.email);
    }

    @Override
    public String toString() {
        return getDatos();
    }

    abstract public String getDatos();
}
